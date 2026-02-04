package com.notifica.sdk;

import com.notifica.sdk.exceptions.*;
import com.notifica.sdk.models.common.RequestOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class NotificaClientTest {

    private HttpClient mockHttpClient;
    private NotificaClient client;
    
    @BeforeEach
    void setUp() {
        mockHttpClient = mock(HttpClient.class);
        NotificaConfig config = NotificaConfig.builder()
                .apiKey("test-key")
                .baseUrl("https://app.usenotifica.com.br/v1")
                .build();
        client = new NotificaClient(config, mockHttpClient);
    }
    
    @Test
    void testConfigBuilder() {
        NotificaConfig config = NotificaConfig.builder()
                .apiKey("my-key")
                .baseUrl("https://custom.api.com")
                .timeout(Duration.ofSeconds(45))
                .maxRetries(5)
                .autoIdempotency(false)
                .build();
        
        assertEquals("my-key", config.getApiKey());
        assertEquals("https://custom.api.com", config.getBaseUrl());
        assertEquals(Duration.ofSeconds(45), config.getTimeout());
        assertEquals(5, config.getMaxRetries());
        assertFalse(config.isAutoIdempotency());
    }
    
    @Test
    void testDefaultConfig() {
        NotificaConfig config = NotificaConfig.builder()
                .apiKey("key")
                .build();
        
        assertEquals("https://app.usenotifica.com.br/v1", config.getBaseUrl());
        assertEquals(Duration.ofSeconds(30), config.getTimeout());
        assertEquals(3, config.getMaxRetries());
        assertTrue(config.isAutoIdempotency());
    }
    
    @Test
    void testAuthorizationHeader() throws Exception {
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, "{}");
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        client.get("/test", null, null, new com.fasterxml.jackson.core.type.TypeReference<Object>() {});
        
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        verify(mockHttpClient).sendAsync(requestCaptor.capture(), any());
        
        HttpRequest request = requestCaptor.getValue();
        assertEquals("Bearer test-key", request.headers().firstValue("Authorization").orElse(null));
    }
    
    @Test
    void testUserAgentHeader() throws Exception {
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, "{}");
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        client.get("/test", null, null, new com.fasterxml.jackson.core.type.TypeReference<Object>() {});
        
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        verify(mockHttpClient).sendAsync(requestCaptor.capture(), any());
        
        HttpRequest request = requestCaptor.getValue();
        String userAgent = request.headers().firstValue("User-Agent").orElse(null);
        assertNotNull(userAgent);
        assertTrue(userAgent.startsWith("notifica-java/"));
    }
    
    @Test
    void testAutoIdempotencyKey() throws Exception {
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, "{}");
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        client.post("/test", Map.of("key", "value"), null, new com.fasterxml.jackson.core.type.TypeReference<Object>() {});
        
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        verify(mockHttpClient).sendAsync(requestCaptor.capture(), any());
        
        HttpRequest request = requestCaptor.getValue();
        String idempotencyKey = request.headers().firstValue("Idempotency-Key").orElse(null);
        assertNotNull(idempotencyKey);
        assertFalse(idempotencyKey.isEmpty());
    }
    
    @Test
    void testCustomIdempotencyKey() throws Exception {
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, "{}");
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        RequestOptions options = RequestOptions.withIdempotencyKey("custom-idem-key");
        client.post("/test", Map.of(), options, new com.fasterxml.jackson.core.type.TypeReference<Object>() {});
        
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        verify(mockHttpClient).sendAsync(requestCaptor.capture(), any());
        
        HttpRequest request = requestCaptor.getValue();
        assertEquals("custom-idem-key", request.headers().firstValue("Idempotency-Key").orElse(null));
    }
    
    @Test
    void testQueryParameters() throws Exception {
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, "{}");
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        Map<String, Object> query = Map.of(
                "status", "active",
                "limit", 50,
                "sort", "created_at"
        );
        
        client.get("/test", query, null, new com.fasterxml.jackson.core.type.TypeReference<Object>() {});
        
        ArgumentCaptor<HttpRequest> requestCaptor = ArgumentCaptor.forClass(HttpRequest.class);
        verify(mockHttpClient).sendAsync(requestCaptor.capture(), any());
        
        String uri = requestCaptor.getValue().uri().toString();
        assertTrue(uri.contains("status=active"));
        assertTrue(uri.contains("limit=50"));
        assertTrue(uri.contains("sort=created_at"));
    }
    
    @Test
    void testApiException() throws Exception {
        String errorBody = "{\"error\":{\"code\":\"invalid_request\",\"message\":\"Invalid parameter\"}}";
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(400, errorBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        try {
            client.get("/test", null, null, new com.fasterxml.jackson.core.type.TypeReference<Object>() {});
            fail("Expected ApiException to be thrown");
        } catch (java.util.concurrent.CompletionException e) {
            assertTrue(e.getCause() instanceof ApiException);
            ApiException exception = (ApiException) e.getCause();
            assertEquals(400, exception.getStatus());
            assertTrue(exception.getMessage().contains("Invalid parameter"));
        }
    }
    
    @Test
    void testValidationException() throws Exception {
        String errorBody = "{\"error\":{\"code\":\"validation_error\",\"message\":\"Validation failed\",\"details\":{\"email\":[\"Invalid format\"]}}}";
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(422, errorBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        try {
            client.post("/test", Map.of(), null, new com.fasterxml.jackson.core.type.TypeReference<Object>() {});
            fail("Expected ValidationException to be thrown");
        } catch (java.util.concurrent.CompletionException e) {
            assertTrue(e.getCause() instanceof ValidationException);
            ValidationException exception = (ValidationException) e.getCause();
            assertNotNull(exception.getDetails());
            assertTrue(exception.getDetails().containsKey("email"));
        }
    }
    
    @Test
    void testRateLimitException() throws Exception {
        String errorBody = "{\"error\":{\"code\":\"rate_limit_exceeded\",\"message\":\"Too many requests\"}}";
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(429, errorBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        try {
            client.get("/test", null, null, new com.fasterxml.jackson.core.type.TypeReference<Object>() {});
            fail("Expected RateLimitException to be thrown");
        } catch (java.util.concurrent.CompletionException e) {
            assertTrue(e.getCause() instanceof RateLimitException);
            RateLimitException exception = (RateLimitException) e.getCause();
            assertTrue(exception.getMessage().contains("Too many requests"));
        }
    }
    
    @Test
    void testAsyncRequest() throws Exception {
        String responseBody = TestHelpers.envelope(Map.of("id", "123", "status", "success"));
        HttpResponse<String> mockResponse = TestHelpers.mockResponse(200, responseBody);
        when(mockHttpClient.sendAsync(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));
        
        CompletableFuture<Object> future = client.getAsync("/test", null, null, 
                new com.fasterxml.jackson.core.type.TypeReference<Object>() {});
        
        assertNotNull(future);
        Object result = future.join();
        assertNotNull(result);
    }
}
