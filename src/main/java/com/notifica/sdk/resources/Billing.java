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
 * Resource for billing management (plans, subscription, invoices, payment methods, usage, settings).
 */
public class Billing {

    private final Plans plans;
    private final Settings settings;
    private final Subscription subscription;
    private final Usage usage;
    private final Invoices invoices;
    private final PaymentMethods paymentMethods;

    public Billing(NotificaClient client) {
        this.plans = new Plans(client);
        this.settings = new Settings(client);
        this.subscription = new Subscription(client);
        this.usage = new Usage(client);
        this.invoices = new Invoices(client);
        this.paymentMethods = new PaymentMethods(client);
    }

    public Plans plans() { return plans; }
    public Settings settings() { return settings; }
    public Subscription subscription() { return subscription; }
    public Usage usage() { return usage; }
    public Invoices invoices() { return invoices; }
    public PaymentMethods paymentMethods() { return paymentMethods; }

    /**
     * Billing Plans sub-resource.
     */
    public static class Plans {
        private final NotificaClient client;

        public Plans(NotificaClient client) {
            this.client = client;
        }

        public List<BillingPlan> list() {
            return list(null);
        }

        public List<BillingPlan> list(RequestOptions options) {
            return client.get("/billing/plans", null, options,
                    new TypeReference<Map<String, List<BillingPlan>>>() {}).get("data");
        }

        public CompletableFuture<List<BillingPlan>> listAsync() {
            return listAsync(null);
        }

        public CompletableFuture<List<BillingPlan>> listAsync(RequestOptions options) {
            return client.getAsync("/billing/plans", null, options,
                    new TypeReference<Map<String, List<BillingPlan>>>() {}).thenApply(r -> r.get("data"));
        }

        public BillingPlan get(String name) {
            return get(name, null);
        }

        public BillingPlan get(String name, RequestOptions options) {
            return client.getOne("/billing/plans/" + name, options, BillingPlan.class);
        }

        public CompletableFuture<BillingPlan> getAsync(String name) {
            return getAsync(name, null);
        }

        public CompletableFuture<BillingPlan> getAsync(String name, RequestOptions options) {
            return client.getOneAsync("/billing/plans/" + name, options, BillingPlan.class);
        }
    }

    /**
     * Billing Settings sub-resource.
     */
    public static class Settings {
        private final NotificaClient client;

        public Settings(NotificaClient client) {
            this.client = client;
        }

        public BillingSettings get() {
            return get(null);
        }

        public BillingSettings get(RequestOptions options) {
            return client.getOne("/billing/settings", options, BillingSettings.class);
        }

        public CompletableFuture<BillingSettings> getAsync() {
            return getAsync(null);
        }

        public CompletableFuture<BillingSettings> getAsync(RequestOptions options) {
            return client.getOneAsync("/billing/settings", options, BillingSettings.class);
        }
    }

    /**
     * Subscription sub-resource.
     */
    public static class Subscription {
        private final NotificaClient client;

        public Subscription(NotificaClient client) {
            this.client = client;
        }

        public com.notifica.sdk.models.Subscription get() {
            return get(null);
        }

        public com.notifica.sdk.models.Subscription get(RequestOptions options) {
            return client.getOne("/billing/subscription", options, com.notifica.sdk.models.Subscription.class);
        }

        public CompletableFuture<com.notifica.sdk.models.Subscription> getAsync() {
            return getAsync(null);
        }

        public CompletableFuture<com.notifica.sdk.models.Subscription> getAsync(RequestOptions options) {
            return client.getOneAsync("/billing/subscription", options, com.notifica.sdk.models.Subscription.class);
        }

        public com.notifica.sdk.models.Subscription subscribe(Map<String, Object> params) {
            return subscribe(params, null);
        }

        public com.notifica.sdk.models.Subscription subscribe(Map<String, Object> params, RequestOptions options) {
            return client.post("/billing/subscribe", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<com.notifica.sdk.models.Subscription>>() {}).getData();
        }

        public CompletableFuture<com.notifica.sdk.models.Subscription> subscribeAsync(Map<String, Object> params) {
            return subscribeAsync(params, null);
        }

        public CompletableFuture<com.notifica.sdk.models.Subscription> subscribeAsync(Map<String, Object> params, RequestOptions options) {
            return client.postAsync("/billing/subscribe", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<com.notifica.sdk.models.Subscription>>() {}).thenApply(r -> r.getData());
        }

        public com.notifica.sdk.models.Subscription changePlan(Map<String, Object> params) {
            return changePlan(params, null);
        }

        public com.notifica.sdk.models.Subscription changePlan(Map<String, Object> params, RequestOptions options) {
            return client.post("/billing/change-plan", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<com.notifica.sdk.models.Subscription>>() {}).getData();
        }

        public CompletableFuture<com.notifica.sdk.models.Subscription> changePlanAsync(Map<String, Object> params) {
            return changePlanAsync(params, null);
        }

        public CompletableFuture<com.notifica.sdk.models.Subscription> changePlanAsync(Map<String, Object> params, RequestOptions options) {
            return client.postAsync("/billing/change-plan", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<com.notifica.sdk.models.Subscription>>() {}).thenApply(r -> r.getData());
        }

        public com.notifica.sdk.models.Subscription cancel() {
            return cancel(null, null);
        }

        public com.notifica.sdk.models.Subscription cancel(Map<String, Object> params) {
            return cancel(params, null);
        }

        public com.notifica.sdk.models.Subscription cancel(Map<String, Object> params, RequestOptions options) {
            return client.post("/billing/cancel", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<com.notifica.sdk.models.Subscription>>() {}).getData();
        }

        public CompletableFuture<com.notifica.sdk.models.Subscription> cancelAsync() {
            return cancelAsync(null, null);
        }

        public CompletableFuture<com.notifica.sdk.models.Subscription> cancelAsync(Map<String, Object> params) {
            return cancelAsync(params, null);
        }

        public CompletableFuture<com.notifica.sdk.models.Subscription> cancelAsync(Map<String, Object> params, RequestOptions options) {
            return client.postAsync("/billing/cancel", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<com.notifica.sdk.models.Subscription>>() {}).thenApply(r -> r.getData());
        }

        public CalculateProrationResult calculateProration(Map<String, Object> params) {
            return calculateProration(params, null);
        }

        public CalculateProrationResult calculateProration(Map<String, Object> params, RequestOptions options) {
            return client.post("/billing/calculate-proration", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<CalculateProrationResult>>() {}).getData();
        }

        public CompletableFuture<CalculateProrationResult> calculateProrationAsync(Map<String, Object> params) {
            return calculateProrationAsync(params, null);
        }

        public CompletableFuture<CalculateProrationResult> calculateProrationAsync(Map<String, Object> params, RequestOptions options) {
            return client.postAsync("/billing/calculate-proration", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<CalculateProrationResult>>() {}).thenApply(r -> r.getData());
        }

        public com.notifica.sdk.models.Subscription reactivate() {
            return reactivate(null, null);
        }

        public com.notifica.sdk.models.Subscription reactivate(Map<String, Object> params) {
            return reactivate(params, null);
        }

        public com.notifica.sdk.models.Subscription reactivate(Map<String, Object> params, RequestOptions options) {
            return client.post("/billing/reactivate", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<com.notifica.sdk.models.Subscription>>() {}).getData();
        }

        public CompletableFuture<com.notifica.sdk.models.Subscription> reactivateAsync() {
            return reactivateAsync(null, null);
        }

        public CompletableFuture<com.notifica.sdk.models.Subscription> reactivateAsync(Map<String, Object> params) {
            return reactivateAsync(params, null);
        }

        public CompletableFuture<com.notifica.sdk.models.Subscription> reactivateAsync(Map<String, Object> params, RequestOptions options) {
            return client.postAsync("/billing/reactivate", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<com.notifica.sdk.models.Subscription>>() {}).thenApply(r -> r.getData());
        }
    }

    /**
     * Usage sub-resource.
     */
    public static class Usage {
        private final NotificaClient client;

        public Usage(NotificaClient client) {
            this.client = client;
        }

        public BillingUsage get() {
            return get(null);
        }

        public BillingUsage get(RequestOptions options) {
            return client.getOne("/billing/usage", options, BillingUsage.class);
        }

        public CompletableFuture<BillingUsage> getAsync() {
            return getAsync(null);
        }

        public CompletableFuture<BillingUsage> getAsync(RequestOptions options) {
            return client.getOneAsync("/billing/usage", options, BillingUsage.class);
        }
    }

    /**
     * Invoices sub-resource.
     */
    public static class Invoices {
        private final NotificaClient client;

        public Invoices(NotificaClient client) {
            this.client = client;
        }

        public PaginatedResponse<Invoice> list() {
            return list(null, null);
        }

        public PaginatedResponse<Invoice> list(Map<String, Object> params) {
            return list(params, null);
        }

        public PaginatedResponse<Invoice> list(Map<String, Object> params, RequestOptions options) {
            return client.list("/billing/invoices", params, options, Invoice.class);
        }

        public CompletableFuture<PaginatedResponse<Invoice>> listAsync() {
            return listAsync(null, null);
        }

        public CompletableFuture<PaginatedResponse<Invoice>> listAsync(Map<String, Object> params) {
            return listAsync(params, null);
        }

        public CompletableFuture<PaginatedResponse<Invoice>> listAsync(Map<String, Object> params, RequestOptions options) {
            return client.listAsync("/billing/invoices", params, options, Invoice.class);
        }

        public Invoice get(String id) {
            return get(id, null);
        }

        public Invoice get(String id, RequestOptions options) {
            return client.getOne("/billing/invoices/" + id, options, Invoice.class);
        }

        public CompletableFuture<Invoice> getAsync(String id) {
            return getAsync(id, null);
        }

        public CompletableFuture<Invoice> getAsync(String id, RequestOptions options) {
            return client.getOneAsync("/billing/invoices/" + id, options, Invoice.class);
        }
    }

    /**
     * Payment Methods sub-resource.
     */
    public static class PaymentMethods {
        private final NotificaClient client;

        public PaymentMethods(NotificaClient client) {
            this.client = client;
        }

        public List<PaymentMethod> list() {
            return list(null);
        }

        public List<PaymentMethod> list(RequestOptions options) {
            return client.get("/billing/payment-methods", null, options,
                    new TypeReference<Map<String, List<PaymentMethod>>>() {}).get("data");
        }

        public CompletableFuture<List<PaymentMethod>> listAsync() {
            return listAsync(null);
        }

        public CompletableFuture<List<PaymentMethod>> listAsync(RequestOptions options) {
            return client.getAsync("/billing/payment-methods", null, options,
                    new TypeReference<Map<String, List<PaymentMethod>>>() {}).thenApply(r -> r.get("data"));
        }

        public PaymentMethod create(Map<String, Object> params) {
            return create(params, null);
        }

        public PaymentMethod create(Map<String, Object> params, RequestOptions options) {
            return client.post("/billing/payment-methods", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<PaymentMethod>>() {}).getData();
        }

        public CompletableFuture<PaymentMethod> createAsync(Map<String, Object> params) {
            return createAsync(params, null);
        }

        public CompletableFuture<PaymentMethod> createAsync(Map<String, Object> params, RequestOptions options) {
            return client.postAsync("/billing/payment-methods", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<PaymentMethod>>() {}).thenApply(r -> r.getData());
        }

        public PaymentMethod get(String id) {
            return get(id, null);
        }

        public PaymentMethod get(String id, RequestOptions options) {
            return client.getOne("/billing/payment-methods/" + id, options, PaymentMethod.class);
        }

        public CompletableFuture<PaymentMethod> getAsync(String id) {
            return getAsync(id, null);
        }

        public CompletableFuture<PaymentMethod> getAsync(String id, RequestOptions options) {
            return client.getOneAsync("/billing/payment-methods/" + id, options, PaymentMethod.class);
        }

        public PaymentMethod update(String id, Map<String, Object> params) {
            return update(id, params, null);
        }

        public PaymentMethod update(String id, Map<String, Object> params, RequestOptions options) {
            return client.put("/billing/payment-methods/" + id, params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<PaymentMethod>>() {}).getData();
        }

        public CompletableFuture<PaymentMethod> updateAsync(String id, Map<String, Object> params) {
            return updateAsync(id, params, null);
        }

        public CompletableFuture<PaymentMethod> updateAsync(String id, Map<String, Object> params, RequestOptions options) {
            return client.putAsync("/billing/payment-methods/" + id, params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<PaymentMethod>>() {}).thenApply(r -> r.getData());
        }

        public void delete(String id) {
            delete(id, null);
        }

        public void delete(String id, RequestOptions options) {
            client.delete("/billing/payment-methods/" + id, options);
        }

        public CompletableFuture<Void> deleteAsync(String id) {
            return deleteAsync(id, null);
        }

        public CompletableFuture<Void> deleteAsync(String id, RequestOptions options) {
            return client.deleteVoidAsync("/billing/payment-methods/" + id, options);
        }

        public PaymentMethod setDefault(String id) {
            return setDefault(id, null);
        }

        public PaymentMethod setDefault(String id, RequestOptions options) {
            return client.post("/billing/payment-methods/" + id + "/set-default", null, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<PaymentMethod>>() {}).getData();
        }

        public CompletableFuture<PaymentMethod> setDefaultAsync(String id) {
            return setDefaultAsync(id, null);
        }

        public CompletableFuture<PaymentMethod> setDefaultAsync(String id, RequestOptions options) {
            return client.postAsync("/billing/payment-methods/" + id + "/set-default", null, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<PaymentMethod>>() {}).thenApply(r -> r.getData());
        }
    }
}
