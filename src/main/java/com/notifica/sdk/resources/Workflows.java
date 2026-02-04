package com.notifica.sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.notifica.sdk.NotificaClient;
import com.notifica.sdk.models.*;
import com.notifica.sdk.models.common.PaginatedResponse;
import com.notifica.sdk.models.common.RequestOptions;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for managing workflows.
 */
public class Workflows {

    private final NotificaClient client;

    public Workflows(NotificaClient client) {
        this.client = client;
    }

    // ── Workflows ───────────────────────────────────────

    public Workflow create(CreateWorkflowParams params) {
        return create(params, null);
    }

    public Workflow create(CreateWorkflowParams params, RequestOptions options) {
        return client.post("/workflows", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Workflow>>() {}).getData();
    }

    public CompletableFuture<Workflow> createAsync(CreateWorkflowParams params) {
        return createAsync(params, null);
    }

    public CompletableFuture<Workflow> createAsync(CreateWorkflowParams params, RequestOptions options) {
        return client.postAsync("/workflows", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Workflow>>() {}).thenApply(r -> r.getData());
    }

    public PaginatedResponse<Workflow> list() {
        return list(null, null);
    }

    public PaginatedResponse<Workflow> list(Map<String, Object> params) {
        return list(params, null);
    }

    public PaginatedResponse<Workflow> list(Map<String, Object> params, RequestOptions options) {
        return client.list("/workflows", params, options, Workflow.class);
    }

    public CompletableFuture<PaginatedResponse<Workflow>> listAsync() {
        return listAsync(null, null);
    }

    public CompletableFuture<PaginatedResponse<Workflow>> listAsync(Map<String, Object> params) {
        return listAsync(params, null);
    }

    public CompletableFuture<PaginatedResponse<Workflow>> listAsync(Map<String, Object> params, RequestOptions options) {
        return client.listAsync("/workflows", params, options, Workflow.class);
    }

    public Workflow get(String id) {
        return get(id, null);
    }

    public Workflow get(String id, RequestOptions options) {
        return client.getOne("/workflows/" + id, options, Workflow.class);
    }

    public CompletableFuture<Workflow> getAsync(String id) {
        return getAsync(id, null);
    }

    public CompletableFuture<Workflow> getAsync(String id, RequestOptions options) {
        return client.getOneAsync("/workflows/" + id, options, Workflow.class);
    }

    public Workflow update(String id, UpdateWorkflowParams params) {
        return update(id, params, null);
    }

    public Workflow update(String id, UpdateWorkflowParams params, RequestOptions options) {
        return client.put("/workflows/" + id, params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Workflow>>() {}).getData();
    }

    public CompletableFuture<Workflow> updateAsync(String id, UpdateWorkflowParams params) {
        return updateAsync(id, params, null);
    }

    public CompletableFuture<Workflow> updateAsync(String id, UpdateWorkflowParams params, RequestOptions options) {
        return client.putAsync("/workflows/" + id, params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Workflow>>() {}).thenApply(r -> r.getData());
    }

    public void delete(String id) {
        delete(id, null);
    }

    public void delete(String id, RequestOptions options) {
        client.delete("/workflows/" + id, options);
    }

    public CompletableFuture<Void> deleteAsync(String id) {
        return deleteAsync(id, null);
    }

    public CompletableFuture<Void> deleteAsync(String id, RequestOptions options) {
        return client.deleteVoidAsync("/workflows/" + id, options);
    }

    public WorkflowRun trigger(String slug, TriggerWorkflowParams params) {
        return trigger(slug, params, null);
    }

    public WorkflowRun trigger(String slug, TriggerWorkflowParams params, RequestOptions options) {
        return client.post("/workflows/" + slug + "/trigger", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<WorkflowRun>>() {}).getData();
    }

    public CompletableFuture<WorkflowRun> triggerAsync(String slug, TriggerWorkflowParams params) {
        return triggerAsync(slug, params, null);
    }

    public CompletableFuture<WorkflowRun> triggerAsync(String slug, TriggerWorkflowParams params, RequestOptions options) {
        return client.postAsync("/workflows/" + slug + "/trigger", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<WorkflowRun>>() {}).thenApply(r -> r.getData());
    }

    // ── Workflow Runs ───────────────────────────────────

    public PaginatedResponse<WorkflowRun> listRuns() {
        return listRuns(null, null);
    }

    public PaginatedResponse<WorkflowRun> listRuns(Map<String, Object> params) {
        return listRuns(params, null);
    }

    public PaginatedResponse<WorkflowRun> listRuns(Map<String, Object> params, RequestOptions options) {
        return client.list("/workflow-runs", params, options, WorkflowRun.class);
    }

    public CompletableFuture<PaginatedResponse<WorkflowRun>> listRunsAsync() {
        return listRunsAsync(null, null);
    }

    public CompletableFuture<PaginatedResponse<WorkflowRun>> listRunsAsync(Map<String, Object> params) {
        return listRunsAsync(params, null);
    }

    public CompletableFuture<PaginatedResponse<WorkflowRun>> listRunsAsync(Map<String, Object> params, RequestOptions options) {
        return client.listAsync("/workflow-runs", params, options, WorkflowRun.class);
    }

    public WorkflowRun getRun(String id) {
        return getRun(id, null);
    }

    public WorkflowRun getRun(String id, RequestOptions options) {
        return client.getOne("/workflow-runs/" + id, options, WorkflowRun.class);
    }

    public CompletableFuture<WorkflowRun> getRunAsync(String id) {
        return getRunAsync(id, null);
    }

    public CompletableFuture<WorkflowRun> getRunAsync(String id, RequestOptions options) {
        return client.getOneAsync("/workflow-runs/" + id, options, WorkflowRun.class);
    }

    public WorkflowRun cancelRun(String id) {
        return cancelRun(id, null);
    }

    public WorkflowRun cancelRun(String id, RequestOptions options) {
        return client.post("/workflow-runs/" + id + "/cancel", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<WorkflowRun>>() {}).getData();
    }

    public CompletableFuture<WorkflowRun> cancelRunAsync(String id) {
        return cancelRunAsync(id, null);
    }

    public CompletableFuture<WorkflowRun> cancelRunAsync(String id, RequestOptions options) {
        return client.postAsync("/workflow-runs/" + id + "/cancel", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<WorkflowRun>>() {}).thenApply(r -> r.getData());
    }
}
