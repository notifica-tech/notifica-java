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
 * Resource for managing subscribers.
 */
public class Subscribers {

    private final NotificaClient client;

    public Subscribers(NotificaClient client) {
        this.client = client;
    }

    public Subscriber create(CreateSubscriberParams params) {
        return create(params, null);
    }

    public Subscriber create(CreateSubscriberParams params, RequestOptions options) {
        return client.post("/subscribers", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Subscriber>>() {}).getData();
    }

    public CompletableFuture<Subscriber> createAsync(CreateSubscriberParams params) {
        return createAsync(params, null);
    }

    public CompletableFuture<Subscriber> createAsync(CreateSubscriberParams params, RequestOptions options) {
        return client.postAsync("/subscribers", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Subscriber>>() {}).thenApply(r -> r.getData());
    }

    public PaginatedResponse<Subscriber> list() {
        return list(null, null);
    }

    public PaginatedResponse<Subscriber> list(Map<String, Object> params) {
        return list(params, null);
    }

    public PaginatedResponse<Subscriber> list(Map<String, Object> params, RequestOptions options) {
        return client.list("/subscribers", params, options, Subscriber.class);
    }

    public CompletableFuture<PaginatedResponse<Subscriber>> listAsync() {
        return listAsync(null, null);
    }

    public CompletableFuture<PaginatedResponse<Subscriber>> listAsync(Map<String, Object> params) {
        return listAsync(params, null);
    }

    public CompletableFuture<PaginatedResponse<Subscriber>> listAsync(Map<String, Object> params, RequestOptions options) {
        return client.listAsync("/subscribers", params, options, Subscriber.class);
    }

    public Subscriber get(String id) {
        return get(id, null);
    }

    public Subscriber get(String id, RequestOptions options) {
        return client.getOne("/subscribers/" + id, options, Subscriber.class);
    }

    public CompletableFuture<Subscriber> getAsync(String id) {
        return getAsync(id, null);
    }

    public CompletableFuture<Subscriber> getAsync(String id, RequestOptions options) {
        return client.getOneAsync("/subscribers/" + id, options, Subscriber.class);
    }

    public Subscriber update(String id, UpdateSubscriberParams params) {
        return update(id, params, null);
    }

    public Subscriber update(String id, UpdateSubscriberParams params, RequestOptions options) {
        return client.put("/subscribers/" + id, params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Subscriber>>() {}).getData();
    }

    public CompletableFuture<Subscriber> updateAsync(String id, UpdateSubscriberParams params) {
        return updateAsync(id, params, null);
    }

    public CompletableFuture<Subscriber> updateAsync(String id, UpdateSubscriberParams params, RequestOptions options) {
        return client.putAsync("/subscribers/" + id, params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Subscriber>>() {}).thenApply(r -> r.getData());
    }

    public void delete(String id) {
        delete(id, null);
    }

    public void delete(String id, RequestOptions options) {
        client.delete("/subscribers/" + id, options);
    }

    public CompletableFuture<Void> deleteAsync(String id) {
        return deleteAsync(id, null);
    }

    public CompletableFuture<Void> deleteAsync(String id, RequestOptions options) {
        return client.deleteVoidAsync("/subscribers/" + id, options);
    }

    // ── Preferences ─────────────────────────────────────

    public SubscriberPreferences getPreferences(String id) {
        return getPreferences(id, null);
    }

    public SubscriberPreferences getPreferences(String id, RequestOptions options) {
        return client.getOne("/subscribers/" + id + "/preferences", options, SubscriberPreferences.class);
    }

    public CompletableFuture<SubscriberPreferences> getPreferencesAsync(String id) {
        return getPreferencesAsync(id, null);
    }

    public CompletableFuture<SubscriberPreferences> getPreferencesAsync(String id, RequestOptions options) {
        return client.getOneAsync("/subscribers/" + id + "/preferences", options, SubscriberPreferences.class);
    }

    public SubscriberPreferences updatePreferences(String id, UpdatePreferencesParams params) {
        return updatePreferences(id, params, null);
    }

    public SubscriberPreferences updatePreferences(String id, UpdatePreferencesParams params, RequestOptions options) {
        return client.put("/subscribers/" + id + "/preferences", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<SubscriberPreferences>>() {}).getData();
    }

    public CompletableFuture<SubscriberPreferences> updatePreferencesAsync(String id, UpdatePreferencesParams params) {
        return updatePreferencesAsync(id, params, null);
    }

    public CompletableFuture<SubscriberPreferences> updatePreferencesAsync(String id, UpdatePreferencesParams params, RequestOptions options) {
        return client.putAsync("/subscribers/" + id + "/preferences", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<SubscriberPreferences>>() {}).thenApply(r -> r.getData());
    }

    // ── Bulk Import ─────────────────────────────────────

    public BulkImportResult bulkImport(BulkImportParams params) {
        return bulkImport(params, null);
    }

    public BulkImportResult bulkImport(BulkImportParams params, RequestOptions options) {
        return client.post("/subscribers/import", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<BulkImportResult>>() {}).getData();
    }

    public CompletableFuture<BulkImportResult> bulkImportAsync(BulkImportParams params) {
        return bulkImportAsync(params, null);
    }

    public CompletableFuture<BulkImportResult> bulkImportAsync(BulkImportParams params, RequestOptions options) {
        return client.postAsync("/subscribers/import", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<BulkImportResult>>() {}).thenApply(r -> r.getData());
    }

    // ── In-App Notifications ────────────────────────────

    public List<InAppNotification> listNotifications(String subscriberId) {
        return listNotifications(subscriberId, null, null);
    }

    public List<InAppNotification> listNotifications(String subscriberId, Map<String, Object> params) {
        return listNotifications(subscriberId, params, null);
    }

    public List<InAppNotification> listNotifications(String subscriberId, Map<String, Object> params, RequestOptions options) {
        return client.get("/subscribers/" + subscriberId + "/notifications", params, options,
                new TypeReference<Map<String, List<InAppNotification>>>() {}).get("data");
    }

    public CompletableFuture<List<InAppNotification>> listNotificationsAsync(String subscriberId) {
        return listNotificationsAsync(subscriberId, null, null);
    }

    public CompletableFuture<List<InAppNotification>> listNotificationsAsync(String subscriberId, Map<String, Object> params) {
        return listNotificationsAsync(subscriberId, params, null);
    }

    public CompletableFuture<List<InAppNotification>> listNotificationsAsync(String subscriberId, Map<String, Object> params, RequestOptions options) {
        return client.getAsync("/subscribers/" + subscriberId + "/notifications", params, options,
                new TypeReference<Map<String, List<InAppNotification>>>() {}).thenApply(r -> r.get("data"));
    }

    public void markRead(String subscriberId, String notificationId) {
        markRead(subscriberId, notificationId, null);
    }

    public void markRead(String subscriberId, String notificationId, RequestOptions options) {
        client.post("/subscribers/" + subscriberId + "/notifications/" + notificationId + "/read",
                null, options, null);
    }

    public CompletableFuture<Void> markReadAsync(String subscriberId, String notificationId) {
        return markReadAsync(subscriberId, notificationId, null);
    }

    public CompletableFuture<Void> markReadAsync(String subscriberId, String notificationId, RequestOptions options) {
        return client.postAsync("/subscribers/" + subscriberId + "/notifications/" + notificationId + "/read",
                null, options, new TypeReference<Void>() {}).thenApply(r -> null);
    }

    public void markAllRead(String subscriberId) {
        markAllRead(subscriberId, null);
    }

    public void markAllRead(String subscriberId, RequestOptions options) {
        client.post("/subscribers/" + subscriberId + "/notifications/read-all",
                null, options, null);
    }

    public CompletableFuture<Void> markAllReadAsync(String subscriberId) {
        return markAllReadAsync(subscriberId, null);
    }

    public CompletableFuture<Void> markAllReadAsync(String subscriberId, RequestOptions options) {
        return client.postAsync("/subscribers/" + subscriberId + "/notifications/read-all",
                null, options, new TypeReference<Void>() {}).thenApply(r -> null);
    }

    public int getUnreadCount(String subscriberId) {
        return getUnreadCount(subscriberId, null);
    }

    public int getUnreadCount(String subscriberId, RequestOptions options) {
        Map<String, Integer> response = client.get("/subscribers/" + subscriberId + "/notifications/unread-count",
                null, options, new TypeReference<Map<String, Map<String, Integer>>>() {}).get("data");
        return response.get("count");
    }

    public CompletableFuture<Integer> getUnreadCountAsync(String subscriberId) {
        return getUnreadCountAsync(subscriberId, null);
    }

    public CompletableFuture<Integer> getUnreadCountAsync(String subscriberId, RequestOptions options) {
        return client.getAsync("/subscribers/" + subscriberId + "/notifications/unread-count",
                null, options, new TypeReference<Map<String, Map<String, Integer>>>() {})
                .thenApply(r -> r.get("data").get("count"));
    }
}
