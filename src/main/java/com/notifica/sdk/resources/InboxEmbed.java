package com.notifica.sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.notifica.sdk.NotificaClient;
import com.notifica.sdk.models.*;
import com.notifica.sdk.models.common.RequestOptions;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for inbox embed settings.
 */
public class InboxEmbed {

    private final NotificaClient client;

    public InboxEmbed(NotificaClient client) {
        this.client = client;
    }

    public InboxEmbedSettings getSettings() {
        return getSettings(null);
    }

    public InboxEmbedSettings getSettings(RequestOptions options) {
        return client.getOne("/inbox-embed/settings", options, InboxEmbedSettings.class);
    }

    public CompletableFuture<InboxEmbedSettings> getSettingsAsync() {
        return getSettingsAsync(null);
    }

    public CompletableFuture<InboxEmbedSettings> getSettingsAsync(RequestOptions options) {
        return client.getOneAsync("/inbox-embed/settings", options, InboxEmbedSettings.class);
    }

    public InboxEmbedSettings updateSettings(UpdateInboxEmbedSettingsParams params) {
        return updateSettings(params, null);
    }

    public InboxEmbedSettings updateSettings(UpdateInboxEmbedSettingsParams params, RequestOptions options) {
        return client.put("/inbox-embed/settings", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<InboxEmbedSettings>>() {}).getData();
    }

    public CompletableFuture<InboxEmbedSettings> updateSettingsAsync(UpdateInboxEmbedSettingsParams params) {
        return updateSettingsAsync(params, null);
    }

    public CompletableFuture<InboxEmbedSettings> updateSettingsAsync(UpdateInboxEmbedSettingsParams params, RequestOptions options) {
        return client.putAsync("/inbox-embed/settings", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<InboxEmbedSettings>>() {}).thenApply(r -> r.getData());
    }

    public RotateEmbedKeyResult rotateKey() {
        return rotateKey(null);
    }

    public RotateEmbedKeyResult rotateKey(RequestOptions options) {
        return client.post("/inbox-embed/keys/rotate", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<RotateEmbedKeyResult>>() {}).getData();
    }

    public CompletableFuture<RotateEmbedKeyResult> rotateKeyAsync() {
        return rotateKeyAsync(null);
    }

    public CompletableFuture<RotateEmbedKeyResult> rotateKeyAsync(RequestOptions options) {
        return client.postAsync("/inbox-embed/keys/rotate", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<RotateEmbedKeyResult>>() {}).thenApply(r -> r.getData());
    }
}
