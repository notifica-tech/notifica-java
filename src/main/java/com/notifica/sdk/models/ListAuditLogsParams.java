package com.notifica.sdk.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Parameters for listing audit logs.
 */
public class ListAuditLogsParams {

    private String action;
    private String resourceType;
    private String resourceId;
    private String actorType;
    private String actorId;
    private String startDate;
    private String endDate;
    private Integer limit;
    private String cursor;

    public ListAuditLogsParams() {}

    /**
     * Filter by action (e.g., 'api_key.created').
     */
    public String getAction() { return action; }
    public ListAuditLogsParams setAction(String action) {
        this.action = action;
        return this;
    }

    /**
     * Filter by resource type (e.g., 'api_key', 'webhook').
     */
    public String getResourceType() { return resourceType; }
    public ListAuditLogsParams setResourceType(String resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    /**
     * Filter by resource ID.
     */
    public String getResourceId() { return resourceId; }
    public ListAuditLogsParams setResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * Filter by actor type ('user', 'api_key', 'system').
     */
    public String getActorType() { return actorType; }
    public ListAuditLogsParams setActorType(String actorType) {
        this.actorType = actorType;
        return this;
    }

    /**
     * Filter by actor ID.
     */
    public String getActorId() { return actorId; }
    public ListAuditLogsParams setActorId(String actorId) {
        this.actorId = actorId;
        return this;
    }

    /**
     * Start date (ISO 8601).
     */
    public String getStartDate() { return startDate; }
    public ListAuditLogsParams setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * End date (ISO 8601).
     */
    public String getEndDate() { return endDate; }
    public ListAuditLogsParams setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Maximum number of results.
     */
    public Integer getLimit() { return limit; }
    public ListAuditLogsParams setLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Cursor for pagination.
     */
    public String getCursor() { return cursor; }
    public ListAuditLogsParams setCursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    /**
     * Convert to a Map for query parameters.
     */
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        if (action != null) map.put("action", action);
        if (resourceType != null) map.put("resource_type", resourceType);
        if (resourceId != null) map.put("resource_id", resourceId);
        if (actorType != null) map.put("actor_type", actorType);
        if (actorId != null) map.put("actor_id", actorId);
        if (startDate != null) map.put("start_date", startDate);
        if (endDate != null) map.put("end_date", endDate);
        if (limit != null) map.put("limit", limit);
        if (cursor != null) map.put("cursor", cursor);
        return map;
    }
}
