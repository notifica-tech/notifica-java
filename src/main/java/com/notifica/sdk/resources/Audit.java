package com.notifica.sdk.resources;

import com.notifica.sdk.NotificaClient;
import com.notifica.sdk.models.AuditLog;
import com.notifica.sdk.models.ListAuditLogsParams;
import com.notifica.sdk.models.common.PaginatedResponse;
import com.notifica.sdk.models.common.RequestOptions;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Resource for accessing audit logs.
 *
 * <p><strong>⚠️ Admin Only:</strong> This resource requires admin authentication
 * (Bearer token from backoffice login). Not available with regular API keys.
 *
 * <p>Use audit logs to track security-sensitive actions in your organization:
 * <ul>
 *   <li>API key lifecycle (created, rotated, revoked)</li>
 *   <li>Team member changes (invited, removed, role changes)</li>
 *   <li>Subscription events (created, plan changes, cancellation, payment failures)</li>
 *   <li>Domain management (added, verified, removed)</li>
 *   <li>Webhook configuration (created, updated, deleted)</li>
 * </ul>
 *
 * <p>Example usage:
 * <pre>{@code
 * // List recent audit logs
 * PaginatedResponse<AuditLog> logs = notifica.audit().list(
 *     new ListAuditLogsParams().setLimit(50));
 *
 * // Filter by action type
 * PaginatedResponse<AuditLog> apiKeyLogs = notifica.audit().list(
 *     new ListAuditLogsParams()
 *         .setAction("api_key.created")
 *         .setLimit(20));
 *
 * // Get a specific audit log
 * AuditLog log = notifica.audit().get("audit_abc123");
 * }</pre>
 */
public class Audit {

    private static final String BASE_PATH = "/internal/audit-logs";
    private final NotificaClient client;

    public Audit(NotificaClient client) {
        this.client = client;
    }

    /**
     * List audit logs with optional filters.
     *
     * <p><strong>⚠️ Admin Only:</strong> Requires admin authentication.
     *
     * @return paginated list of audit logs
     */
    public PaginatedResponse<AuditLog> list() {
        return list((Map<String, Object>) null, null);
    }

    /**
     * List audit logs with filters.
     *
     * <p><strong>⚠️ Admin Only:</strong> Requires admin authentication.
     *
     * @param params filter parameters
     * @return paginated list of audit logs
     */
    public PaginatedResponse<AuditLog> list(ListAuditLogsParams params) {
        return list(params != null ? params.toMap() : null, null);
    }

    /**
     * List audit logs with filters and request options.
     *
     * <p><strong>⚠️ Admin Only:</strong> Requires admin authentication.
     *
     * @param params  filter parameters
     * @param options request options
     * @return paginated list of audit logs
     */
    public PaginatedResponse<AuditLog> list(ListAuditLogsParams params, RequestOptions options) {
        return list(params != null ? params.toMap() : null, options);
    }

    /**
     * List audit logs with raw params map.
     *
     * <p><strong>⚠️ Admin Only:</strong> Requires admin authentication.
     *
     * @param params  query parameters map
     * @param options request options
     * @return paginated list of audit logs
     */
    public PaginatedResponse<AuditLog> list(Map<String, Object> params, RequestOptions options) {
        return client.list(BASE_PATH, params, options, AuditLog.class);
    }

    /**
     * List audit logs asynchronously.
     *
     * <p><strong>⚠️ Admin Only:</strong> Requires admin authentication.
     *
     * @return CompletableFuture with paginated list of audit logs
     */
    public CompletableFuture<PaginatedResponse<AuditLog>> listAsync() {
        return listAsync((Map<String, Object>) null, null);
    }

    /**
     * List audit logs asynchronously with filters.
     *
     * <p><strong>⚠️ Admin Only:</strong> Requires admin authentication.
     *
     * @param params filter parameters
     * @return CompletableFuture with paginated list of audit logs
     */
    public CompletableFuture<PaginatedResponse<AuditLog>> listAsync(ListAuditLogsParams params) {
        return listAsync(params != null ? params.toMap() : null, null);
    }

    /**
     * List audit logs asynchronously with filters and options.
     *
     * <p><strong>⚠️ Admin Only:</strong> Requires admin authentication.
     *
     * @param params  filter parameters
     * @param options request options
     * @return CompletableFuture with paginated list of audit logs
     */
    public CompletableFuture<PaginatedResponse<AuditLog>> listAsync(ListAuditLogsParams params, RequestOptions options) {
        return listAsync(params != null ? params.toMap() : null, options);
    }

    /**
     * List audit logs asynchronously with raw params map.
     *
     * <p><strong>⚠️ Admin Only:</strong> Requires admin authentication.
     *
     * @param params  query parameters map
     * @param options request options
     * @return CompletableFuture with paginated list of audit logs
     */
    public CompletableFuture<PaginatedResponse<AuditLog>> listAsync(Map<String, Object> params, RequestOptions options) {
        return client.listAsync(BASE_PATH, params, options, AuditLog.class);
    }

    /**
     * Get a single audit log by ID.
     *
     * <p><strong>⚠️ Admin Only:</strong> Requires admin authentication.
     *
     * @param id audit log ID
     * @return the audit log
     */
    public AuditLog get(String id) {
        return get(id, null);
    }

    /**
     * Get a single audit log by ID with request options.
     *
     * <p><strong>⚠️ Admin Only:</strong> Requires admin authentication.
     *
     * @param id      audit log ID
     * @param options request options
     * @return the audit log
     */
    public AuditLog get(String id, RequestOptions options) {
        return client.getOne(BASE_PATH + "/" + id, options, AuditLog.class);
    }

    /**
     * Get a single audit log by ID asynchronously.
     *
     * <p><strong>⚠️ Admin Only:</strong> Requires admin authentication.
     *
     * @param id audit log ID
     * @return CompletableFuture with the audit log
     */
    public CompletableFuture<AuditLog> getAsync(String id) {
        return getAsync(id, null);
    }

    /**
     * Get a single audit log by ID asynchronously with request options.
     *
     * <p><strong>⚠️ Admin Only:</strong> Requires admin authentication.
     *
     * @param id      audit log ID
     * @param options request options
     * @return CompletableFuture with the audit log
     */
    public CompletableFuture<AuditLog> getAsync(String id, RequestOptions options) {
        return client.getOneAsync(BASE_PATH + "/" + id, options, AuditLog.class);
    }
}
