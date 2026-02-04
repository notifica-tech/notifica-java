package com.notifica.sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.notifica.sdk.NotificaClient;
import com.notifica.sdk.models.*;
import com.notifica.sdk.models.common.PaginatedResponse;
import com.notifica.sdk.models.common.RequestOptions;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for public inbox operations (uses publishable key).
 */
public class Inbox {

    private final NotificaClient client;

    public Inbox(NotificaClient client) {
        this.client = client;
    }

    public PaginatedResponse<InboxNotification> listNotifications(String subscriberId) {
        return listNotifications(subscriberId, null, null);
    }

    public PaginatedResponse<InboxNotification> listNotifications(String subscriberId, Map<String, Object> params) {
        return listNotifications(subscriberId, params, null);
    }

    public PaginatedResponse<InboxNotification> listNotifications(String subscriberId, Map<String, Object> params, RequestOptions options) {
        Map<String, Object> query = new java.util.HashMap<>();
        if (params != null) query.putAll(params);
        query.put("subscriber_id", subscriberId);
        return client.list("/inbox/notifications", query, options, InboxNotification.class);
    }

    public CompletableFuture<PaginatedResponse<InboxNotification>> listNotificationsAsync(String subscriberId) {
        return listNotificationsAsync(subscriberId, null, null);
    }

    public CompletableFuture<PaginatedResponse<InboxNotification>> listNotificationsAsync(String subscriberId, Map<String, Object> params) {
        return listNotificationsAsync(subscriberId, params, null);
    }

    public CompletableFuture<PaginatedResponse<InboxNotification>> listNotificationsAsync(String subscriberId, Map<String, Object> params, RequestOptions options) {
        Map<String, Object> query = new java.util.HashMap<>();
        if (params != null) query.putAll(params);
        query.put("subscriber_id", subscriberId);
        return client.listAsync("/inbox/notifications", query, options, InboxNotification.class);
    }

    public int getUnreadCount(String subscriberId) {
        return getUnreadCount(subscriberId, null);
    }

    public int getUnreadCount(String subscriberId, RequestOptions options) {
        Map<String, Object> query = Map.of("subscriber_id", subscriberId);
        Map<String, Integer> response = client.get("/inbox/notifications/unread-count", query, options,
                new TypeReference<Map<String, Map<String, Integer>>>() {}).get("data");
        return response.get("count");
    }

    public CompletableFuture<Integer> getUnreadCountAsync(String subscriberId) {
        return getUnreadCountAsync(subscriberId, null);
    }

    public CompletableFuture<Integer> getUnreadCountAsync(String subscriberId, RequestOptions options) {
        Map<String, Object> query = Map.of("subscriber_id", subscriberId);
        return client.getAsync("/inbox/notifications/unread-count", query, options,
                new TypeReference<Map<String, Map<String, Integer>>>() {}).thenApply(r -> r.get("data").get("count"));
    }

    public MarkInboxReadResult markRead(String notificationId) {
        return markRead(notificationId, null);
    }

    public MarkInboxReadResult markRead(String notificationId, RequestOptions options) {
        return client.post("/inbox/notifications/" + notificationId + "/read", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<MarkInboxReadResult>>() {}).getData();
    }

    public CompletableFuture<MarkInboxReadResult> markReadAsync(String notificationId) {
        return markReadAsync(notificationId, null);
    }

    public CompletableFuture<MarkInboxReadResult> markReadAsync(String notificationId, RequestOptions options) {
        return client.postAsync("/inbox/notifications/" + notificationId + "/read", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<MarkInboxReadResult>>() {}).thenApply(r -> r.getData());
    }

    public MarkInboxReadAllResult markAllRead(String subscriberId) {
        return markAllRead(subscriberId, null);
    }

    public MarkInboxReadAllResult markAllRead(String subscriberId, RequestOptions options) {
        Map<String, Object> query = Map.of("subscriber_id", subscriberId);
        return client.post("/inbox/notifications/read-all", query, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<MarkInboxReadAllResult>>() {}).getData();
    }

    public CompletableFuture<MarkInboxReadAllResult> markAllReadAsync(String subscriberId) {
        return markAllReadAsync(subscriberId, null);
    }

    public CompletableFuture<MarkInboxReadAllResult> markAllReadAsync(String subscriberId, RequestOptions options) {
        Map<String, Object> query = Map.of("subscriber_id", subscriberId);
        return client.postAsync("/inbox/notifications/read-all", query, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<MarkInboxReadAllResult>>() {}).thenApply(r -> r.getData());
    }
}
