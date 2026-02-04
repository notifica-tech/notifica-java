package com.notifica.sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.notifica.sdk.NotificaClient;
import com.notifica.sdk.models.*;
import com.notifica.sdk.models.common.RequestOptions;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for managing channel configurations.
 */
public class Channels {

    private final NotificaClient client;

    public Channels(NotificaClient client) {
        this.client = client;
    }

    public ChannelConfiguration create(CreateChannelParams params) {
        return create(params, null);
    }

    public ChannelConfiguration create(CreateChannelParams params, RequestOptions options) {
        return client.post("/channels", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<ChannelConfiguration>>() {}).getData();
    }

    public CompletableFuture<ChannelConfiguration> createAsync(CreateChannelParams params) {
        return createAsync(params, null);
    }

    public CompletableFuture<ChannelConfiguration> createAsync(CreateChannelParams params, RequestOptions options) {
        return client.postAsync("/channels", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<ChannelConfiguration>>() {}).thenApply(r -> r.getData());
    }

    public List<ChannelConfiguration> list() {
        return list(null);
    }

    public List<ChannelConfiguration> list(RequestOptions options) {
        return client.get("/channels", null, options,
                new TypeReference<Map<String, List<ChannelConfiguration>>>() {}).get("data");
    }

    public CompletableFuture<List<ChannelConfiguration>> listAsync() {
        return listAsync(null);
    }

    public CompletableFuture<List<ChannelConfiguration>> listAsync(RequestOptions options) {
        return client.getAsync("/channels", null, options,
                new TypeReference<Map<String, List<ChannelConfiguration>>>() {}).thenApply(r -> r.get("data"));
    }

    public ChannelConfiguration get(String channel) {
        return get(channel, null);
    }

    public ChannelConfiguration get(String channel, RequestOptions options) {
        return client.getOne("/channels/" + channel, options, ChannelConfiguration.class);
    }

    public CompletableFuture<ChannelConfiguration> getAsync(String channel) {
        return getAsync(channel, null);
    }

    public CompletableFuture<ChannelConfiguration> getAsync(String channel, RequestOptions options) {
        return client.getOneAsync("/channels/" + channel, options, ChannelConfiguration.class);
    }

    public ChannelConfiguration update(String channel, UpdateChannelParams params) {
        return update(channel, params, null);
    }

    public ChannelConfiguration update(String channel, UpdateChannelParams params, RequestOptions options) {
        return client.put("/channels/" + channel, params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<ChannelConfiguration>>() {}).getData();
    }

    public CompletableFuture<ChannelConfiguration> updateAsync(String channel, UpdateChannelParams params) {
        return updateAsync(channel, params, null);
    }

    public CompletableFuture<ChannelConfiguration> updateAsync(String channel, UpdateChannelParams params, RequestOptions options) {
        return client.putAsync("/channels/" + channel, params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<ChannelConfiguration>>() {}).thenApply(r -> r.getData());
    }

    public void delete(String channel) {
        delete(channel, null);
    }

    public void delete(String channel, RequestOptions options) {
        client.delete("/channels/" + channel, options);
    }

    public CompletableFuture<Void> deleteAsync(String channel) {
        return deleteAsync(channel, null);
    }

    public CompletableFuture<Void> deleteAsync(String channel, RequestOptions options) {
        return client.deleteVoidAsync("/channels/" + channel, options);
    }

    public TestChannelResult test(String channel) {
        return test(channel, null);
    }

    public TestChannelResult test(String channel, RequestOptions options) {
        return client.post("/channels/" + channel + "/test", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<TestChannelResult>>() {}).getData();
    }

    public CompletableFuture<TestChannelResult> testAsync(String channel) {
        return testAsync(channel, null);
    }

    public CompletableFuture<TestChannelResult> testAsync(String channel, RequestOptions options) {
        return client.postAsync("/channels/" + channel + "/test", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<TestChannelResult>>() {}).thenApply(r -> r.getData());
    }
}
