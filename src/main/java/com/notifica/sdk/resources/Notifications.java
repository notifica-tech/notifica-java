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
 * Resource for managing notifications.
 */
public class Notifications {

    private final NotificaClient client;

    public Notifications(NotificaClient client) {
        this.client = client;
    }

    /**
     * Send a notification.
     */
    public Notification send(SendNotificationParams params) {
        return send(params, null);
    }

    public Notification send(SendNotificationParams params, RequestOptions options) {
        return client.post("/notifications", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Notification>>() {}).getData();
    }

    /**
     * Send a notification (async).
     */
    public CompletableFuture<Notification> sendAsync(SendNotificationParams params) {
        return sendAsync(params, null);
    }

    public CompletableFuture<Notification> sendAsync(SendNotificationParams params, RequestOptions options) {
        return client.postAsync("/notifications", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Notification>>() {}).thenApply(r -> r.getData());
    }

    /**
     * List notifications with pagination.
     */
    public PaginatedResponse<Notification> list() {
        return list(null, null);
    }

    public PaginatedResponse<Notification> list(Map<String, Object> params) {
        return list(params, null);
    }

    public PaginatedResponse<Notification> list(Map<String, Object> params, RequestOptions options) {
        return client.list("/notifications", params, options, Notification.class);
    }

    /**
     * List notifications (async).
     */
    public CompletableFuture<PaginatedResponse<Notification>> listAsync() {
        return listAsync(null, null);
    }

    public CompletableFuture<PaginatedResponse<Notification>> listAsync(Map<String, Object> params) {
        return listAsync(params, null);
    }

    public CompletableFuture<PaginatedResponse<Notification>> listAsync(Map<String, Object> params, RequestOptions options) {
        return client.listAsync("/notifications", params, options, Notification.class);
    }

    /**
     * Get a notification by ID.
     */
    public Notification get(String id) {
        return get(id, null);
    }

    public Notification get(String id, RequestOptions options) {
        return client.getOne("/notifications/" + id, options, Notification.class);
    }

    /**
     * Get a notification (async).
     */
    public CompletableFuture<Notification> getAsync(String id) {
        return getAsync(id, null);
    }

    public CompletableFuture<Notification> getAsync(String id, RequestOptions options) {
        return client.getOneAsync("/notifications/" + id, options, Notification.class);
    }

    /**
     * List delivery attempts for a notification.
     */
    public List<MessageAttempt> listAttempts(String notificationId) {
        return listAttempts(notificationId, null);
    }

    public List<MessageAttempt> listAttempts(String notificationId, RequestOptions options) {
        return client.get("/notifications/" + notificationId + "/attempts", null, options,
                new TypeReference<Map<String, List<MessageAttempt>>>() {}).get("data");
    }

    /**
     * List delivery attempts (async).
     */
    public CompletableFuture<List<MessageAttempt>> listAttemptsAsync(String notificationId) {
        return listAttemptsAsync(notificationId, null);
    }

    public CompletableFuture<List<MessageAttempt>> listAttemptsAsync(String notificationId, RequestOptions options) {
        return client.getAsync("/notifications/" + notificationId + "/attempts", null, options,
                new TypeReference<Map<String, List<MessageAttempt>>>() {}).thenApply(r -> r.get("data"));
    }
}
