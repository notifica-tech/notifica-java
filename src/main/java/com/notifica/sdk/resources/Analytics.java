package com.notifica.sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.notifica.sdk.NotificaClient;
import com.notifica.sdk.models.*;
import com.notifica.sdk.models.common.RequestOptions;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for analytics data.
 */
public class Analytics {

    private final NotificaClient client;

    public Analytics(NotificaClient client) {
        this.client = client;
    }

    public AnalyticsOverview overview() {
        return overview(null, null);
    }

    public AnalyticsOverview overview(Map<String, Object> params) {
        return overview(params, null);
    }

    public AnalyticsOverview overview(Map<String, Object> params, RequestOptions options) {
        return client.get("/analytics/overview", params, options,
                new TypeReference<Map<String, AnalyticsOverview>>() {}).get("data");
    }

    public CompletableFuture<AnalyticsOverview> overviewAsync() {
        return overviewAsync(null, null);
    }

    public CompletableFuture<AnalyticsOverview> overviewAsync(Map<String, Object> params) {
        return overviewAsync(params, null);
    }

    public CompletableFuture<AnalyticsOverview> overviewAsync(Map<String, Object> params, RequestOptions options) {
        return client.getAsync("/analytics/overview", params, options,
                new TypeReference<Map<String, AnalyticsOverview>>() {}).thenApply(r -> r.get("data"));
    }

    public List<ChannelAnalytics> byChannel() {
        return byChannel(null, null);
    }

    public List<ChannelAnalytics> byChannel(Map<String, Object> params) {
        return byChannel(params, null);
    }

    public List<ChannelAnalytics> byChannel(Map<String, Object> params, RequestOptions options) {
        return client.get("/analytics/channels", params, options,
                new TypeReference<Map<String, List<ChannelAnalytics>>>() {}).get("data");
    }

    public CompletableFuture<List<ChannelAnalytics>> byChannelAsync() {
        return byChannelAsync(null, null);
    }

    public CompletableFuture<List<ChannelAnalytics>> byChannelAsync(Map<String, Object> params) {
        return byChannelAsync(params, null);
    }

    public CompletableFuture<List<ChannelAnalytics>> byChannelAsync(Map<String, Object> params, RequestOptions options) {
        return client.getAsync("/analytics/channels", params, options,
                new TypeReference<Map<String, List<ChannelAnalytics>>>() {}).thenApply(r -> r.get("data"));
    }

    public List<TimeseriesPoint> timeseries() {
        return timeseries(null, null);
    }

    public List<TimeseriesPoint> timeseries(Map<String, Object> params) {
        return timeseries(params, null);
    }

    public List<TimeseriesPoint> timeseries(Map<String, Object> params, RequestOptions options) {
        return client.get("/analytics/timeseries", params, options,
                new TypeReference<Map<String, List<TimeseriesPoint>>>() {}).get("data");
    }

    public CompletableFuture<List<TimeseriesPoint>> timeseriesAsync() {
        return timeseriesAsync(null, null);
    }

    public CompletableFuture<List<TimeseriesPoint>> timeseriesAsync(Map<String, Object> params) {
        return timeseriesAsync(params, null);
    }

    public CompletableFuture<List<TimeseriesPoint>> timeseriesAsync(Map<String, Object> params, RequestOptions options) {
        return client.getAsync("/analytics/timeseries", params, options,
                new TypeReference<Map<String, List<TimeseriesPoint>>>() {}).thenApply(r -> r.get("data"));
    }

    public List<TemplateAnalytics> topTemplates() {
        return topTemplates(null, null);
    }

    public List<TemplateAnalytics> topTemplates(Map<String, Object> params) {
        return topTemplates(params, null);
    }

    public List<TemplateAnalytics> topTemplates(Map<String, Object> params, RequestOptions options) {
        return client.get("/analytics/templates", params, options,
                new TypeReference<Map<String, List<TemplateAnalytics>>>() {}).get("data");
    }

    public CompletableFuture<List<TemplateAnalytics>> topTemplatesAsync() {
        return topTemplatesAsync(null, null);
    }

    public CompletableFuture<List<TemplateAnalytics>> topTemplatesAsync(Map<String, Object> params) {
        return topTemplatesAsync(params, null);
    }

    public CompletableFuture<List<TemplateAnalytics>> topTemplatesAsync(Map<String, Object> params, RequestOptions options) {
        return client.getAsync("/analytics/templates", params, options,
                new TypeReference<Map<String, List<TemplateAnalytics>>>() {}).thenApply(r -> r.get("data"));
    }
}
