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
 * Resource for SMS management (providers, compliance, consents).
 */
public class Sms {

    private final Providers providers;
    private final Compliance compliance;
    private final Consents consents;

    public Sms(NotificaClient client) {
        this.providers = new Providers(client);
        this.compliance = new Compliance(client);
        this.consents = new Consents(client);
    }

    public Providers providers() { return providers; }
    public Compliance compliance() { return compliance; }
    public Consents consents() { return consents; }

    /**
     * SMS Providers sub-resource.
     */
    public static class Providers {
        private final NotificaClient client;

        public Providers(NotificaClient client) {
            this.client = client;
        }

        public List<SmsProvider> list() {
            return list(null);
        }

        public List<SmsProvider> list(RequestOptions options) {
            return client.get("/channels/sms/providers", null, options,
                    new TypeReference<Map<String, List<SmsProvider>>>() {}).get("data");
        }

        public CompletableFuture<List<SmsProvider>> listAsync() {
            return listAsync(null);
        }

        public CompletableFuture<List<SmsProvider>> listAsync(RequestOptions options) {
            return client.getAsync("/channels/sms/providers", null, options,
                    new TypeReference<Map<String, List<SmsProvider>>>() {}).thenApply(r -> r.get("data"));
        }

        public SmsProvider create(CreateSmsProviderParams params) {
            return create(params, null);
        }

        public SmsProvider create(CreateSmsProviderParams params, RequestOptions options) {
            return client.post("/channels/sms/providers", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<SmsProvider>>() {}).getData();
        }

        public CompletableFuture<SmsProvider> createAsync(CreateSmsProviderParams params) {
            return createAsync(params, null);
        }

        public CompletableFuture<SmsProvider> createAsync(CreateSmsProviderParams params, RequestOptions options) {
            return client.postAsync("/channels/sms/providers", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<SmsProvider>>() {}).thenApply(r -> r.getData());
        }

        public SmsProvider get(String id) {
            return get(id, null);
        }

        public SmsProvider get(String id, RequestOptions options) {
            return client.getOne("/channels/sms/providers/" + id, options, SmsProvider.class);
        }

        public CompletableFuture<SmsProvider> getAsync(String id) {
            return getAsync(id, null);
        }

        public CompletableFuture<SmsProvider> getAsync(String id, RequestOptions options) {
            return client.getOneAsync("/channels/sms/providers/" + id, options, SmsProvider.class);
        }

        public SmsProvider update(String id, UpdateSmsProviderParams params) {
            return update(id, params, null);
        }

        public SmsProvider update(String id, UpdateSmsProviderParams params, RequestOptions options) {
            return client.patch("/channels/sms/providers/" + id, params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<SmsProvider>>() {}).getData();
        }

        public CompletableFuture<SmsProvider> updateAsync(String id, UpdateSmsProviderParams params) {
            return updateAsync(id, params, null);
        }

        public CompletableFuture<SmsProvider> updateAsync(String id, UpdateSmsProviderParams params, RequestOptions options) {
            return client.patchAsync("/channels/sms/providers/" + id, params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<SmsProvider>>() {}).thenApply(r -> r.getData());
        }

        public SmsProvider activate(String id) {
            return activate(id, null);
        }

        public SmsProvider activate(String id, RequestOptions options) {
            return client.post("/channels/sms/providers/" + id + "/activate", null, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<SmsProvider>>() {}).getData();
        }

        public CompletableFuture<SmsProvider> activateAsync(String id) {
            return activateAsync(id, null);
        }

        public CompletableFuture<SmsProvider> activateAsync(String id, RequestOptions options) {
            return client.postAsync("/channels/sms/providers/" + id + "/activate", null, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<SmsProvider>>() {}).thenApply(r -> r.getData());
        }

        public void delete(String id) {
            delete(id, null);
        }

        public void delete(String id, RequestOptions options) {
            client.delete("/channels/sms/providers/" + id, options);
        }

        public CompletableFuture<Void> deleteAsync(String id) {
            return deleteAsync(id, null);
        }

        public CompletableFuture<Void> deleteAsync(String id, RequestOptions options) {
            return client.deleteVoidAsync("/channels/sms/providers/" + id, options);
        }

        public ValidateSmsProviderResult validate(Map<String, Object> params) {
            return validate(params, null);
        }

        public ValidateSmsProviderResult validate(Map<String, Object> params, RequestOptions options) {
            return client.post("/channels/sms/providers/validate", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<ValidateSmsProviderResult>>() {}).getData();
        }

        public CompletableFuture<ValidateSmsProviderResult> validateAsync(Map<String, Object> params) {
            return validateAsync(params, null);
        }

        public CompletableFuture<ValidateSmsProviderResult> validateAsync(Map<String, Object> params, RequestOptions options) {
            return client.postAsync("/channels/sms/providers/validate", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<ValidateSmsProviderResult>>() {}).thenApply(r -> r.getData());
        }

        public TestSmsProviderResult test(Map<String, Object> params) {
            return test(params, null);
        }

        public TestSmsProviderResult test(Map<String, Object> params, RequestOptions options) {
            return client.post("/channels/sms/providers/test", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<TestSmsProviderResult>>() {}).getData();
        }

        public CompletableFuture<TestSmsProviderResult> testAsync(Map<String, Object> params) {
            return testAsync(params, null);
        }

        public CompletableFuture<TestSmsProviderResult> testAsync(Map<String, Object> params, RequestOptions options) {
            return client.postAsync("/channels/sms/providers/test", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<TestSmsProviderResult>>() {}).thenApply(r -> r.getData());
        }
    }

    /**
     * SMS Compliance sub-resource.
     */
    public static class Compliance {
        private final NotificaClient client;

        public Compliance(NotificaClient client) {
            this.client = client;
        }

        public SmsComplianceSettings show() {
            return show(null);
        }

        public SmsComplianceSettings show(RequestOptions options) {
            return client.getOne("/channels/sms/compliance", options, SmsComplianceSettings.class);
        }

        public CompletableFuture<SmsComplianceSettings> showAsync() {
            return showAsync(null);
        }

        public CompletableFuture<SmsComplianceSettings> showAsync(RequestOptions options) {
            return client.getOneAsync("/channels/sms/compliance", options, SmsComplianceSettings.class);
        }

        public SmsComplianceSettings update(Map<String, Object> params) {
            return update(params, null);
        }

        public SmsComplianceSettings update(Map<String, Object> params, RequestOptions options) {
            return client.patch("/channels/sms/compliance", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<SmsComplianceSettings>>() {}).getData();
        }

        public CompletableFuture<SmsComplianceSettings> updateAsync(Map<String, Object> params) {
            return updateAsync(params, null);
        }

        public CompletableFuture<SmsComplianceSettings> updateAsync(Map<String, Object> params, RequestOptions options) {
            return client.patchAsync("/channels/sms/compliance", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<SmsComplianceSettings>>() {}).thenApply(r -> r.getData());
        }

        public SmsComplianceAnalytics analytics() {
            return analytics(null);
        }

        public SmsComplianceAnalytics analytics(RequestOptions options) {
            return client.getOne("/channels/sms/compliance/analytics", options, SmsComplianceAnalytics.class);
        }

        public CompletableFuture<SmsComplianceAnalytics> analyticsAsync() {
            return analyticsAsync(null);
        }

        public CompletableFuture<SmsComplianceAnalytics> analyticsAsync(RequestOptions options) {
            return client.getOneAsync("/channels/sms/compliance/analytics", options, SmsComplianceAnalytics.class);
        }

        public PaginatedResponse<SmsComplianceLog> logs() {
            return logs(null, null);
        }

        public PaginatedResponse<SmsComplianceLog> logs(Map<String, Object> params) {
            return logs(params, null);
        }

        public PaginatedResponse<SmsComplianceLog> logs(Map<String, Object> params, RequestOptions options) {
            return client.list("/channels/sms/compliance/logs", params, options, SmsComplianceLog.class);
        }

        public CompletableFuture<PaginatedResponse<SmsComplianceLog>> logsAsync() {
            return logsAsync(null, null);
        }

        public CompletableFuture<PaginatedResponse<SmsComplianceLog>> logsAsync(Map<String, Object> params) {
            return logsAsync(params, null);
        }

        public CompletableFuture<PaginatedResponse<SmsComplianceLog>> logsAsync(Map<String, Object> params, RequestOptions options) {
            return client.listAsync("/channels/sms/compliance/logs", params, options, SmsComplianceLog.class);
        }
    }

    /**
     * SMS Consents sub-resource.
     */
    public static class Consents {
        private final NotificaClient client;

        public Consents(NotificaClient client) {
            this.client = client;
        }

        public PaginatedResponse<SmsConsent> list() {
            return list(null, null);
        }

        public PaginatedResponse<SmsConsent> list(Map<String, Object> params) {
            return list(params, null);
        }

        public PaginatedResponse<SmsConsent> list(Map<String, Object> params, RequestOptions options) {
            return client.list("/channels/sms/consents", params, options, SmsConsent.class);
        }

        public CompletableFuture<PaginatedResponse<SmsConsent>> listAsync() {
            return listAsync(null, null);
        }

        public CompletableFuture<PaginatedResponse<SmsConsent>> listAsync(Map<String, Object> params) {
            return listAsync(params, null);
        }

        public CompletableFuture<PaginatedResponse<SmsConsent>> listAsync(Map<String, Object> params, RequestOptions options) {
            return client.listAsync("/channels/sms/consents", params, options, SmsConsent.class);
        }

        public SmsConsentSummary summary() {
            return summary(null);
        }

        public SmsConsentSummary summary(RequestOptions options) {
            return client.getOne("/channels/sms/consents/summary", options, SmsConsentSummary.class);
        }

        public CompletableFuture<SmsConsentSummary> summaryAsync() {
            return summaryAsync(null);
        }

        public CompletableFuture<SmsConsentSummary> summaryAsync(RequestOptions options) {
            return client.getOneAsync("/channels/sms/consents/summary", options, SmsConsentSummary.class);
        }

        public SmsConsent get(String phone) {
            return get(phone, null);
        }

        public SmsConsent get(String phone, RequestOptions options) {
            return client.getOne("/channels/sms/consents/" + java.net.URLEncoder.encode(phone, java.nio.charset.StandardCharsets.UTF_8), options, SmsConsent.class);
        }

        public CompletableFuture<SmsConsent> getAsync(String phone) {
            return getAsync(phone, null);
        }

        public CompletableFuture<SmsConsent> getAsync(String phone, RequestOptions options) {
            return client.getOneAsync("/channels/sms/consents/" + java.net.URLEncoder.encode(phone, java.nio.charset.StandardCharsets.UTF_8), options, SmsConsent.class);
        }

        public void revoke(String phone) {
            revoke(phone, null);
        }

        public void revoke(String phone, RequestOptions options) {
            client.delete("/channels/sms/consents/" + java.net.URLEncoder.encode(phone, java.nio.charset.StandardCharsets.UTF_8), options);
        }

        public CompletableFuture<Void> revokeAsync(String phone) {
            return revokeAsync(phone, null);
        }

        public CompletableFuture<Void> revokeAsync(String phone, RequestOptions options) {
            return client.deleteVoidAsync("/channels/sms/consents/" + java.net.URLEncoder.encode(phone, java.nio.charset.StandardCharsets.UTF_8), options);
        }

        public SmsConsent create(CreateSmsConsentParams params) {
            return create(params, null);
        }

        public SmsConsent create(CreateSmsConsentParams params, RequestOptions options) {
            return client.post("/channels/sms/consents", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<SmsConsent>>() {}).getData();
        }

        public CompletableFuture<SmsConsent> createAsync(CreateSmsConsentParams params) {
            return createAsync(params, null);
        }

        public CompletableFuture<SmsConsent> createAsync(CreateSmsConsentParams params, RequestOptions options) {
            return client.postAsync("/channels/sms/consents", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<SmsConsent>>() {}).thenApply(r -> r.getData());
        }

        public BulkImportSmsConsentResult bulkImport(Map<String, Object> params) {
            return bulkImport(params, null);
        }

        public BulkImportSmsConsentResult bulkImport(Map<String, Object> params, RequestOptions options) {
            return client.post("/channels/sms/consents/import", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<BulkImportSmsConsentResult>>() {}).getData();
        }

        public CompletableFuture<BulkImportSmsConsentResult> bulkImportAsync(Map<String, Object> params) {
            return bulkImportAsync(params, null);
        }

        public CompletableFuture<BulkImportSmsConsentResult> bulkImportAsync(Map<String, Object> params, RequestOptions options) {
            return client.postAsync("/channels/sms/consents/import", params, options,
                    new TypeReference<com.notifica.sdk.models.common.SingleResponse<BulkImportSmsConsentResult>>() {}).thenApply(r -> r.getData());
        }
    }
}
