package com.notifica.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notifica.sdk.exceptions.*;
import com.notifica.sdk.models.common.PaginatedResponse;
import com.notifica.sdk.models.common.RequestOptions;
import com.notifica.sdk.models.common.SingleResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Low-level HTTP client for the Notifica API.
 * Handles authentication, retries, idempotency, and JSON serialization.
 */
public class NotificaClient {

    private static final String SDK_VERSION = "0.1.0";
    private static final String USER_AGENT = "notifica-java/" + SDK_VERSION;
    private static final Set<Integer> RETRYABLE_STATUS_CODES = Set.of(429, 500, 502, 503, 504);

    private final String apiKey;
    private final String baseUrl;
    private final Duration timeout;
    private final int maxRetries;
    private final boolean autoIdempotency;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public NotificaClient(NotificaConfig config) {
        this.apiKey = config.getApiKey();
        this.baseUrl = config.getBaseUrl();
        this.timeout = config.getTimeout();
        this.maxRetries = config.getMaxRetries();
        this.autoIdempotency = config.isAutoIdempotency();
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(timeout)
                .build();
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    // Visible for testing
    public NotificaClient(NotificaConfig config, HttpClient httpClient) {
        this.apiKey = config.getApiKey();
        this.baseUrl = config.getBaseUrl();
        this.timeout = config.getTimeout();
        this.maxRetries = config.getMaxRetries();
        this.autoIdempotency = config.isAutoIdempotency();
        this.httpClient = httpClient;
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    // ── Public sync methods ─────────────────────────────

    public <T> T get(String path, Map<String, Object> query, RequestOptions options, TypeReference<T> typeRef) {
        return getAsync(path, query, options, typeRef).join();
    }

    public <T> T post(String path, Object body, RequestOptions options, TypeReference<T> typeRef) {
        return postAsync(path, body, options, typeRef).join();
    }

    public <T> T put(String path, Object body, RequestOptions options, TypeReference<T> typeRef) {
        return putAsync(path, body, options, typeRef).join();
    }

    public <T> T patch(String path, Object body, RequestOptions options, TypeReference<T> typeRef) {
        return patchAsync(path, body, options, typeRef).join();
    }

    public <T> T delete(String path, RequestOptions options, TypeReference<T> typeRef) {
        return deleteAsync(path, options, typeRef).join();
    }

    public void delete(String path, RequestOptions options) {
        deleteVoidAsync(path, options).join();
    }

    // ── Convenience methods ─────────────────────────────

    public <T> T getOne(String path, RequestOptions options, Class<T> clazz) {
        return getOneAsync(path, options, clazz).join();
    }

    public <T> PaginatedResponse<T> list(String path, Map<String, Object> query,
                                          RequestOptions options, Class<T> itemClass) {
        return listAsync(path, query, options, itemClass).join();
    }

    // ── Public async methods ────────────────────────────

    public <T> CompletableFuture<T> getAsync(String path, Map<String, Object> query,
                                              RequestOptions options, TypeReference<T> typeRef) {
        return requestAsync("GET", path, null, query, options, typeRef);
    }

    public <T> CompletableFuture<T> postAsync(String path, Object body,
                                               RequestOptions options, TypeReference<T> typeRef) {
        return requestAsync("POST", path, body, null, options, typeRef);
    }

    public <T> CompletableFuture<T> putAsync(String path, Object body,
                                              RequestOptions options, TypeReference<T> typeRef) {
        return requestAsync("PUT", path, body, null, options, typeRef);
    }

    public <T> CompletableFuture<T> patchAsync(String path, Object body,
                                                RequestOptions options, TypeReference<T> typeRef) {
        return requestAsync("PATCH", path, body, null, options, typeRef);
    }

    public <T> CompletableFuture<T> deleteAsync(String path, RequestOptions options,
                                                 TypeReference<T> typeRef) {
        return requestAsync("DELETE", path, null, null, options, typeRef);
    }

    public CompletableFuture<Void> deleteVoidAsync(String path, RequestOptions options) {
        return requestAsync("DELETE", path, null, null, options, null)
                .thenApply(ignored -> null);
    }

    // ── Async convenience ───────────────────────────────

    public <T> CompletableFuture<T> getOneAsync(String path, RequestOptions options, Class<T> clazz) {
        TypeReference<SingleResponse<JsonNode>> typeRef = new TypeReference<SingleResponse<JsonNode>>() {};
        return requestAsync("GET", path, null, null, options, typeRef)
                .thenApply(response -> {
                    try {
                        return objectMapper.treeToValue(response.getData(), clazz);
                    } catch (Exception e) {
                        throw new NotificaException("Failed to deserialize response", e);
                    }
                });
    }

    public <T> CompletableFuture<PaginatedResponse<T>> listAsync(String path, Map<String, Object> query,
                                                                   RequestOptions options, Class<T> itemClass) {
        TypeReference<JsonNode> typeRef = new TypeReference<JsonNode>() {};
        return requestAsync("GET", path, null, query, options, typeRef)
                .thenApply(node -> {
                    try {
                        JavaType responseType = objectMapper.getTypeFactory()
                                .constructParametricType(PaginatedResponse.class, itemClass);
                        return objectMapper.convertValue(node, responseType);
                    } catch (Exception e) {
                        throw new NotificaException("Failed to deserialize paginated response", e);
                    }
                });
    }

    // ── Internal request ────────────────────────────────

    private <T> CompletableFuture<T> requestAsync(String method, String path, Object body,
                                                   Map<String, Object> query,
                                                   RequestOptions options,
                                                   TypeReference<T> typeRef) {
        return requestWithRetries(method, path, body, query, options, typeRef, 0, null);
    }

    private <T> CompletableFuture<T> requestWithRetries(String method, String path, Object body,
                                                         Map<String, Object> query,
                                                         RequestOptions options,
                                                         TypeReference<T> typeRef,
                                                         int attempt,
                                                         Exception lastError) {
        if (attempt > 0) {
            long delayMs = calculateBackoff(attempt, lastError);
            return delay(delayMs).thenCompose(ignored ->
                    executeRequest(method, path, body, query, options, typeRef, attempt, lastError));
        }
        return executeRequest(method, path, body, query, options, typeRef, attempt, lastError);
    }

    @SuppressWarnings("unchecked")
    private <T> CompletableFuture<T> executeRequest(String method, String path, Object body,
                                                     Map<String, Object> query,
                                                     RequestOptions options,
                                                     TypeReference<T> typeRef,
                                                     int attempt,
                                                     Exception lastError) {
        try {
            URI url = buildUrl(path, query);
            HttpRequest.Builder reqBuilder = HttpRequest.newBuilder()
                    .uri(url)
                    .timeout(options != null && options.getTimeout() != null ?
                            options.getTimeout() : timeout);

            // Set headers
            Map<String, String> headers = buildHeaders(method, options);
            headers.forEach(reqBuilder::header);

            // Set method + body
            if (body != null) {
                String json = objectMapper.writeValueAsString(body);
                reqBuilder.method(method, HttpRequest.BodyPublishers.ofString(json));
            } else if ("POST".equals(method) || "PUT".equals(method) || "PATCH".equals(method)) {
                reqBuilder.method(method, HttpRequest.BodyPublishers.noBody());
            } else {
                reqBuilder.method(method, HttpRequest.BodyPublishers.noBody());
            }

            HttpRequest request = reqBuilder.build();

            return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenCompose(response -> {
                        int status = response.statusCode();

                        // Success: 2xx
                        if (status >= 200 && status < 300) {
                            if (status == 204 || typeRef == null) {
                                return CompletableFuture.completedFuture(null);
                            }
                            try {
                                T result = objectMapper.readValue(response.body(), typeRef);
                                return CompletableFuture.completedFuture(result);
                            } catch (Exception e) {
                                return CompletableFuture.failedFuture(
                                        new NotificaException("Failed to parse response", e));
                            }
                        }

                        // Parse error body
                        String requestId = response.headers().firstValue("x-request-id").orElse(null);
                        JsonNode errorBody = safeParseJson(response.body());
                        String errorMessage = extractErrorMessage(errorBody, status);
                        String errorCode = extractErrorCode(errorBody);
                        Map<String, List<String>> details = extractErrorDetails(errorBody);

                        // Rate limit: maybe retry
                        if (status == 429) {
                            Integer retryAfter = parseRetryAfter(response);
                            RateLimitException error = new RateLimitException(errorMessage, retryAfter, requestId);
                            if (attempt < maxRetries) {
                                return requestWithRetries(method, path, body, query, options, typeRef, attempt + 1, error);
                            }
                            return CompletableFuture.failedFuture(error);
                        }

                        // Server error: maybe retry
                        if (RETRYABLE_STATUS_CODES.contains(status) && attempt < maxRetries) {
                            ApiException error = new ApiException(errorMessage, status, errorCode, details, requestId);
                            return requestWithRetries(method, path, body, query, options, typeRef, attempt + 1, error);
                        }

                        // Validation error
                        if (status == 422) {
                            return CompletableFuture.failedFuture(
                                    new ValidationException(errorMessage, details, requestId));
                        }

                        // Other error
                        return CompletableFuture.failedFuture(
                                new ApiException(errorMessage, status, errorCode, details, requestId));
                    })
                    .exceptionallyCompose(throwable -> {
                        Throwable cause = throwable instanceof java.util.concurrent.CompletionException ?
                                throwable.getCause() : throwable;

                        if (cause instanceof NotificaException) {
                            return CompletableFuture.failedFuture(cause);
                        }

                        if (cause instanceof java.net.http.HttpTimeoutException) {
                            if (attempt < maxRetries) {
                                return requestWithRetries(method, path, body, query, options, typeRef,
                                        attempt + 1, new TimeoutException(timeout.toMillis()));
                            }
                            return CompletableFuture.failedFuture(new TimeoutException(timeout.toMillis()));
                        }

                        if (attempt < maxRetries) {
                            Exception ex = cause instanceof Exception ? (Exception) cause : new Exception(cause);
                            return requestWithRetries(method, path, body, query, options, typeRef, attempt + 1, ex);
                        }

                        return CompletableFuture.failedFuture(
                                new NotificaException("Request failed: " + cause.getMessage(), cause));
                    });

        } catch (Exception e) {
            return CompletableFuture.failedFuture(new NotificaException("Request setup failed", e));
        }
    }

    // ── URL building ────────────────────────────────────

    private URI buildUrl(String path, Map<String, Object> query) {
        StringBuilder sb = new StringBuilder(baseUrl).append(path);
        if (query != null && !query.isEmpty()) {
            sb.append('?');
            boolean first = true;
            for (Map.Entry<String, Object> entry : query.entrySet()) {
                if (entry.getValue() != null) {
                    if (!first) sb.append('&');
                    sb.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8))
                      .append('=')
                      .append(URLEncoder.encode(String.valueOf(entry.getValue()), StandardCharsets.UTF_8));
                    first = false;
                }
            }
        }
        return URI.create(sb.toString());
    }

    // ── Headers ─────────────────────────────────────────

    private Map<String, String> buildHeaders(String method, RequestOptions options) {
        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("Authorization", "Bearer " + apiKey);
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("User-Agent", USER_AGENT);

        if ("POST".equals(method)) {
            if (options != null && options.getIdempotencyKey() != null) {
                headers.put("Idempotency-Key", options.getIdempotencyKey());
            } else if (autoIdempotency) {
                headers.put("Idempotency-Key", UUID.randomUUID().toString());
            }
        }

        return headers;
    }

    // ── Retry logic ─────────────────────────────────────

    private long calculateBackoff(int attempt, Exception lastError) {
        if (lastError instanceof RateLimitException) {
            Integer retryAfter = ((RateLimitException) lastError).getRetryAfter();
            if (retryAfter != null) {
                return retryAfter * 1000L;
            }
        }
        // Exponential backoff: 500ms, 1s, 2s... with jitter
        long base = 500L * (1L << (attempt - 1));
        long jitter = (long) (ThreadLocalRandom.current().nextDouble() * base * 0.5);
        return base + jitter;
    }

    private CompletableFuture<Void> delay(long ms) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    // ── Error parsing ───────────────────────────────────

    private JsonNode safeParseJson(String body) {
        try {
            return objectMapper.readTree(body);
        } catch (Exception e) {
            return null;
        }
    }

    private String extractErrorMessage(JsonNode errorBody, int status) {
        if (errorBody != null && errorBody.has("error") && errorBody.get("error").has("message")) {
            return errorBody.get("error").get("message").asText();
        }
        return "API error (" + status + ")";
    }

    private String extractErrorCode(JsonNode errorBody) {
        if (errorBody != null && errorBody.has("error") && errorBody.get("error").has("code")) {
            return errorBody.get("error").get("code").asText();
        }
        return "api_error";
    }

    private Map<String, List<String>> extractErrorDetails(JsonNode errorBody) {
        if (errorBody != null && errorBody.has("error") && errorBody.get("error").has("details")) {
            try {
                return objectMapper.convertValue(
                        errorBody.get("error").get("details"),
                        new TypeReference<Map<String, List<String>>>() {});
            } catch (Exception e) {
                return Collections.emptyMap();
            }
        }
        return Collections.emptyMap();
    }

    private Integer parseRetryAfter(HttpResponse<String> response) {
        return response.headers().firstValue("retry-after").map(header -> {
            try {
                return (int) Double.parseDouble(header);
            } catch (NumberFormatException e) {
                return null;
            }
        }).orElse(null);
    }
}
