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
 * Resource for managing domains.
 */
public class Domains {

    private final NotificaClient client;

    public Domains(NotificaClient client) {
        this.client = client;
    }

    public Domain create(CreateDomainParams params) {
        return create(params, null);
    }

    public Domain create(CreateDomainParams params, RequestOptions options) {
        return client.post("/domains", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Domain>>() {}).getData();
    }

    public CompletableFuture<Domain> createAsync(CreateDomainParams params) {
        return createAsync(params, null);
    }

    public CompletableFuture<Domain> createAsync(CreateDomainParams params, RequestOptions options) {
        return client.postAsync("/domains", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Domain>>() {}).thenApply(r -> r.getData());
    }

    public PaginatedResponse<Domain> list() {
        return list(null, null);
    }

    public PaginatedResponse<Domain> list(Map<String, Object> params) {
        return list(params, null);
    }

    public PaginatedResponse<Domain> list(Map<String, Object> params, RequestOptions options) {
        return client.list("/domains", params, options, Domain.class);
    }

    public CompletableFuture<PaginatedResponse<Domain>> listAsync() {
        return listAsync(null, null);
    }

    public CompletableFuture<PaginatedResponse<Domain>> listAsync(Map<String, Object> params) {
        return listAsync(params, null);
    }

    public CompletableFuture<PaginatedResponse<Domain>> listAsync(Map<String, Object> params, RequestOptions options) {
        return client.listAsync("/domains", params, options, Domain.class);
    }

    public Domain get(String id) {
        return get(id, null);
    }

    public Domain get(String id, RequestOptions options) {
        return client.getOne("/domains/" + id, options, Domain.class);
    }

    public CompletableFuture<Domain> getAsync(String id) {
        return getAsync(id, null);
    }

    public CompletableFuture<Domain> getAsync(String id, RequestOptions options) {
        return client.getOneAsync("/domains/" + id, options, Domain.class);
    }

    public Domain verify(String id) {
        return verify(id, null);
    }

    public Domain verify(String id, RequestOptions options) {
        return client.post("/domains/" + id + "/verify", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Domain>>() {}).getData();
    }

    public CompletableFuture<Domain> verifyAsync(String id) {
        return verifyAsync(id, null);
    }

    public CompletableFuture<Domain> verifyAsync(String id, RequestOptions options) {
        return client.postAsync("/domains/" + id + "/verify", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Domain>>() {}).thenApply(r -> r.getData());
    }

    public void delete(String id) {
        delete(id, null);
    }

    public void delete(String id, RequestOptions options) {
        client.delete("/domains/" + id, options);
    }

    public CompletableFuture<Void> deleteAsync(String id) {
        return deleteAsync(id, null);
    }

    public CompletableFuture<Void> deleteAsync(String id, RequestOptions options) {
        return client.deleteVoidAsync("/domains/" + id, options);
    }

    // ── Health ──────────────────────────────────────────

    public DomainHealth getHealth(String domainId) {
        return getHealth(domainId, null);
    }

    public DomainHealth getHealth(String domainId, RequestOptions options) {
        return client.getOne("/domains/" + domainId + "/health", options, DomainHealth.class);
    }

    public CompletableFuture<DomainHealth> getHealthAsync(String domainId) {
        return getHealthAsync(domainId, null);
    }

    public CompletableFuture<DomainHealth> getHealthAsync(String domainId, RequestOptions options) {
        return client.getOneAsync("/domains/" + domainId + "/health", options, DomainHealth.class);
    }

    public DomainHealth checkHealth(String domainId) {
        return checkHealth(domainId, null);
    }

    public DomainHealth checkHealth(String domainId, RequestOptions options) {
        return client.post("/domains/" + domainId + "/health/check", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<DomainHealth>>() {}).getData();
    }

    public CompletableFuture<DomainHealth> checkHealthAsync(String domainId) {
        return checkHealthAsync(domainId, null);
    }

    public CompletableFuture<DomainHealth> checkHealthAsync(String domainId, RequestOptions options) {
        return client.postAsync("/domains/" + domainId + "/health/check", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<DomainHealth>>() {}).thenApply(r -> r.getData());
    }

    public List<DomainAlert> listAlerts() {
        return listAlerts(null);
    }

    public List<DomainAlert> listAlerts(RequestOptions options) {
        return client.get("/domains/alerts", null, options,
                new TypeReference<Map<String, List<DomainAlert>>>() {}).get("data");
    }

    public CompletableFuture<List<DomainAlert>> listAlertsAsync() {
        return listAlertsAsync(null);
    }

    public CompletableFuture<List<DomainAlert>> listAlertsAsync(RequestOptions options) {
        return client.getAsync("/domains/alerts", null, options,
                new TypeReference<Map<String, List<DomainAlert>>>() {}).thenApply(r -> r.get("data"));
    }
}
