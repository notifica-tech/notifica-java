package com.notifica.sdk.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.notifica.sdk.NotificaClient;
import com.notifica.sdk.models.*;
import com.notifica.sdk.models.common.PaginatedResponse;
import com.notifica.sdk.models.common.RequestOptions;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for managing templates.
 */
public class Templates {

    private final NotificaClient client;

    public Templates(NotificaClient client) {
        this.client = client;
    }

    /**
     * Create a new template.
     */
    public Template create(CreateTemplateParams params) {
        return create(params, null);
    }

    public Template create(CreateTemplateParams params, RequestOptions options) {
        return client.post("/templates", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Template>>() {}).getData();
    }

    public CompletableFuture<Template> createAsync(CreateTemplateParams params) {
        return createAsync(params, null);
    }

    public CompletableFuture<Template> createAsync(CreateTemplateParams params, RequestOptions options) {
        return client.postAsync("/templates", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Template>>() {}).thenApply(r -> r.getData());
    }

    /**
     * List templates with pagination.
     */
    public PaginatedResponse<Template> list() {
        return list(null, null);
    }

    public PaginatedResponse<Template> list(Map<String, Object> params) {
        return list(params, null);
    }

    public PaginatedResponse<Template> list(Map<String, Object> params, RequestOptions options) {
        return client.list("/templates", params, options, Template.class);
    }

    public CompletableFuture<PaginatedResponse<Template>> listAsync() {
        return listAsync(null, null);
    }

    public CompletableFuture<PaginatedResponse<Template>> listAsync(Map<String, Object> params) {
        return listAsync(params, null);
    }

    public CompletableFuture<PaginatedResponse<Template>> listAsync(Map<String, Object> params, RequestOptions options) {
        return client.listAsync("/templates", params, options, Template.class);
    }

    /**
     * Get a template by ID.
     */
    public Template get(String id) {
        return get(id, null);
    }

    public Template get(String id, RequestOptions options) {
        return client.getOne("/templates/" + id, options, Template.class);
    }

    public CompletableFuture<Template> getAsync(String id) {
        return getAsync(id, null);
    }

    public CompletableFuture<Template> getAsync(String id, RequestOptions options) {
        return client.getOneAsync("/templates/" + id, options, Template.class);
    }

    /**
     * Update a template.
     */
    public Template update(String id, UpdateTemplateParams params) {
        return update(id, params, null);
    }

    public Template update(String id, UpdateTemplateParams params, RequestOptions options) {
        return client.put("/templates/" + id, params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Template>>() {}).getData();
    }

    public CompletableFuture<Template> updateAsync(String id, UpdateTemplateParams params) {
        return updateAsync(id, params, null);
    }

    public CompletableFuture<Template> updateAsync(String id, UpdateTemplateParams params, RequestOptions options) {
        return client.putAsync("/templates/" + id, params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<Template>>() {}).thenApply(r -> r.getData());
    }

    /**
     * Delete a template.
     */
    public void delete(String id) {
        delete(id, null);
    }

    public void delete(String id, RequestOptions options) {
        client.delete("/templates/" + id, options);
    }

    public CompletableFuture<Void> deleteAsync(String id) {
        return deleteAsync(id, null);
    }

    public CompletableFuture<Void> deleteAsync(String id, RequestOptions options) {
        return client.deleteVoidAsync("/templates/" + id, options);
    }

    /**
     * Preview a template with variables.
     */
    public PreviewResult preview(String id, PreviewTemplateParams params) {
        return preview(id, params, null);
    }

    public PreviewResult preview(String id, PreviewTemplateParams params, RequestOptions options) {
        return client.post("/templates/" + id + "/preview", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<PreviewResult>>() {}).getData();
    }

    public CompletableFuture<PreviewResult> previewAsync(String id, PreviewTemplateParams params) {
        return previewAsync(id, params, null);
    }

    public CompletableFuture<PreviewResult> previewAsync(String id, PreviewTemplateParams params, RequestOptions options) {
        return client.postAsync("/templates/" + id + "/preview", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<PreviewResult>>() {}).thenApply(r -> r.getData());
    }

    /**
     * Preview arbitrary content.
     */
    public PreviewResult previewContent(PreviewContentParams params) {
        return previewContent(params, null);
    }

    public PreviewResult previewContent(PreviewContentParams params, RequestOptions options) {
        return client.post("/templates/preview", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<PreviewResult>>() {}).getData();
    }

    public CompletableFuture<PreviewResult> previewContentAsync(PreviewContentParams params) {
        return previewContentAsync(params, null);
    }

    public CompletableFuture<PreviewResult> previewContentAsync(PreviewContentParams params, RequestOptions options) {
        return client.postAsync("/templates/preview", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<PreviewResult>>() {}).thenApply(r -> r.getData());
    }

    /**
     * Validate a template.
     */
    public ValidationResult validate(String id) {
        return validate(id, null);
    }

    public ValidationResult validate(String id, RequestOptions options) {
        return client.post("/templates/" + id + "/validate", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<ValidationResult>>() {}).getData();
    }

    public CompletableFuture<ValidationResult> validateAsync(String id) {
        return validateAsync(id, null);
    }

    public CompletableFuture<ValidationResult> validateAsync(String id, RequestOptions options) {
        return client.postAsync("/templates/" + id + "/validate", null, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<ValidationResult>>() {}).thenApply(r -> r.getData());
    }

    /**
     * Validate arbitrary content.
     */
    public ValidationResult validateContent(ValidateContentParams params) {
        return validateContent(params, null);
    }

    public ValidationResult validateContent(ValidateContentParams params, RequestOptions options) {
        return client.post("/templates/validate", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<ValidationResult>>() {}).getData();
    }

    public CompletableFuture<ValidationResult> validateContentAsync(ValidateContentParams params) {
        return validateContentAsync(params, null);
    }

    public CompletableFuture<ValidationResult> validateContentAsync(ValidateContentParams params, RequestOptions options) {
        return client.postAsync("/templates/validate", params, options,
                new TypeReference<com.notifica.sdk.models.common.SingleResponse<ValidationResult>>() {}).thenApply(r -> r.getData());
    }
}
