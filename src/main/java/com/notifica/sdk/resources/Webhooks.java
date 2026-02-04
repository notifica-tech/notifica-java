package com.notifica.sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.notifica.sdk.NotificaClient;
import com.notifica.sdk.models.*;
import com.notifica.sdk.models.common.PaginatedResponse;
import com.notifica.sdk.models.common.RequestOptions;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for managing webhooks.
 */
public class Webhooks {

    private final NotificaClient client;

    public Webhooks(NotificaClient client) {
        this.client = client;
    }

    public Webhook create(CreateWebhookParams params) {
        return create(params, null);
    }

    public Webhook create(CreateWebhookParams params, RequestOptions options) {
        return client.post("/webhooks", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Webhook>>() {}).getData();
    }

    public CompletableFuture<Webhook> createAsync(CreateWebhookParams params) {
        return createAsync(params, null);
    }

    public CompletableFuture<Webhook> createAsync(CreateWebhookParams params, RequestOptions options) {
        return client.postAsync("/webhooks", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Webhook>>() {}).thenApply(r -> r.getData());
    }

    public PaginatedResponse<Webhook> list() {
        return list(null, null);
    }

    public PaginatedResponse<Webhook> list(Map<String, Object> params) {
        return list(params, null);
    }

    public PaginatedResponse<Webhook> list(Map<String, Object> params, RequestOptions options) {
        return client.list("/webhooks", params, options, Webhook.class);
    }

    public CompletableFuture<PaginatedResponse<Webhook>> listAsync() {
        return listAsync(null, null);
    }

    public CompletableFuture<PaginatedResponse<Webhook>> listAsync(Map<String, Object> params) {
        return listAsync(params, null);
    }

    public CompletableFuture<PaginatedResponse<Webhook>> listAsync(Map<String, Object> params, RequestOptions options) {
        return client.listAsync("/webhooks", params, options, Webhook.class);
    }

    public Webhook get(String id) {
        return get(id, null);
    }

    public Webhook get(String id, RequestOptions options) {
        return client.getOne("/webhooks/" + id, options, Webhook.class);
    }

    public CompletableFuture<Webhook> getAsync(String id) {
        return getAsync(id, null);
    }

    public CompletableFuture<Webhook> getAsync(String id, RequestOptions options) {
        return client.getOneAsync("/webhooks/" + id, options, Webhook.class);
    }

    public Webhook update(String id, UpdateWebhookParams params) {
        return update(id, params, null);
    }

    public Webhook update(String id, UpdateWebhookParams params, RequestOptions options) {
        return client.put("/webhooks/" + id, params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Webhook>>() {}).getData();
    }

    public CompletableFuture<Webhook> updateAsync(String id, UpdateWebhookParams params) {
        return updateAsync(id, params, null);
    }

    public CompletableFuture<Webhook> updateAsync(String id, UpdateWebhookParams params, RequestOptions options) {
        return client.putAsync("/webhooks/" + id, params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Webhook>>() {}).thenApply(r -> r.getData());
    }

    public void delete(String id) {
        delete(id, null);
    }

    public void delete(String id, RequestOptions options) {
        client.delete("/webhooks/" + id, options);
    }

    public CompletableFuture<Void> deleteAsync(String id) {
        return deleteAsync(id, null);
    }

    public CompletableFuture<Void> deleteAsync(String id, RequestOptions options) {
        return client.deleteVoidAsync("/webhooks/" + id, options);
    }

    public void test(String id) {
        test(id, null);
    }

    public void test(String id, RequestOptions options) {
        client.post("/webhooks/" + id + "/test", null, options, null);
    }

    public CompletableFuture<Void> testAsync(String id) {
        return testAsync(id, null);
    }

    public CompletableFuture<Void> testAsync(String id, RequestOptions options) {
        return client.postAsync("/webhooks/" + id + "/test", null, options,
                new TypeReference<Void>() {}).thenApply(r -> null);
    }

    public List<WebhookDelivery> listDeliveries(String id) {
        return listDeliveries(id, null, null);
    }

    public List<WebhookDelivery> listDeliveries(String id, Map<String, Object> params) {
        return listDeliveries(id, params, null);
    }

    public List<WebhookDelivery> listDeliveries(String id, Map<String, Object> params, RequestOptions options) {
        return client.get("/webhooks/" + id + "/deliveries", params, options,
                new TypeReference<Map<String, List<WebhookDelivery>>>() {}).get("data");
    }

    public CompletableFuture<List<WebhookDelivery>> listDeliveriesAsync(String id) {
        return listDeliveriesAsync(id, null, null);
    }

    public CompletableFuture<List<WebhookDelivery>> listDeliveriesAsync(String id, Map<String, Object> params) {
        return listDeliveriesAsync(id, params, null);
    }

    public CompletableFuture<List<WebhookDelivery>> listDeliveriesAsync(String id, Map<String, Object> params, RequestOptions options) {
        return client.getAsync("/webhooks/" + id + "/deliveries", params, options,
                new TypeReference<Map<String, List<WebhookDelivery>>>() {}).thenApply(r -> r.get("data"));
    }

    /**
     * Verify webhook signature.
     * Validates that the payload was sent by Notifica using HMAC-SHA256.
     *
     * @param payload the raw request body
     * @param signature the value from X-Notifica-Signature header
     * @param secret the signing_secret from the webhook
     * @return true if the signature is valid
     */
    public boolean verify(String payload, String signature, String secret) {
        if (payload == null || signature == null || secret == null) {
            return false;
        }
        try {
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA256");
            mac.init(new javax.crypto.spec.SecretKeySpec(secret.getBytes(java.nio.charset.StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] hash = mac.doFinal(payload.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            String computed = bytesToHex(hash);
            return timingSafeEqual(computed, signature);
        } catch (Exception e) {
            return false;
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private boolean timingSafeEqual(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            result |= a.charAt(i) ^ b.charAt(i);
        }
        return result == 0;
    }
}
