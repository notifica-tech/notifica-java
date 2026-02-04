package com.notifica.sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.notifica.sdk.NotificaClient;
import com.notifica.sdk.models.*;
import com.notifica.sdk.models.common.RequestOptions;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for managing API keys.
 */
public class ApiKeys {

    private final NotificaClient client;

    public ApiKeys(NotificaClient client) {
        this.client = client;
    }

    public ApiKey create(CreateApiKeyParams params) {
        return create(params, null);
    }

    public ApiKey create(CreateApiKeyParams params, RequestOptions options) {
        return client.post("/api-keys", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<ApiKey>>() {}).getData();
    }

    public CompletableFuture<ApiKey> createAsync(CreateApiKeyParams params) {
        return createAsync(params, null);
    }

    public CompletableFuture<ApiKey> createAsync(CreateApiKeyParams params, RequestOptions options) {
        return client.postAsync("/api-keys", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<ApiKey>>() {}).thenApply(r -> r.getData());
    }

    public List<ApiKey> list() {
        return list(null);
    }

    public List<ApiKey> list(RequestOptions options) {
        return client.get("/api-keys", null, options,
                new TypeReference<Map<String, List<ApiKey>>>() {}).get("data");
    }

    public CompletableFuture<List<ApiKey>> listAsync() {
        return listAsync(null);
    }

    public CompletableFuture<List<ApiKey>> listAsync(RequestOptions options) {
        return client.getAsync("/api-keys", null, options,
                new TypeReference<Map<String, List<ApiKey>>>() {}).thenApply(r -> r.get("data"));
    }

    public void revoke(String id) {
        revoke(id, null);
    }

    public void revoke(String id, RequestOptions options) {
        client.delete("/api-keys/" + id, options);
    }

    public CompletableFuture<Void> revokeAsync(String id) {
        return revokeAsync(id, null);
    }

    public CompletableFuture<Void> revokeAsync(String id, RequestOptions options) {
        return client.deleteVoidAsync("/api-keys/" + id, options);
    }
}
