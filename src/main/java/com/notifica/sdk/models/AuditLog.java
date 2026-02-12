package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.Map;

/**
 * Audit log entry representing a security-sensitive action.
 */
public class AuditLog {

    private String id;
    private String action;
    @JsonProperty("resource_type")
    private String resourceType;
    @JsonProperty("resource_id")
    private String resourceId;
    private AuditActor actor;
    private Map<String, Object> metadata;
    @JsonProperty("previous_state")
    private Map<String, Object> previousState;
    @JsonProperty("new_state")
    private Map<String, Object> newState;
    @JsonProperty("organization_id")
    private String organizationId;
    @JsonProperty("created_at")
    private Instant createdAt;

    public AuditLog() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getResourceType() { return resourceType; }
    public void setResourceType(String resourceType) { this.resourceType = resourceType; }

    public String getResourceId() { return resourceId; }
    public void setResourceId(String resourceId) { this.resourceId = resourceId; }

    public AuditActor getActor() { return actor; }
    public void setActor(AuditActor actor) { this.actor = actor; }

    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }

    public Map<String, Object> getPreviousState() { return previousState; }
    public void setPreviousState(Map<String, Object> previousState) { this.previousState = previousState; }

    public Map<String, Object> getNewState() { return newState; }
    public void setNewState(Map<String, Object> newState) { this.newState = newState; }

    public String getOrganizationId() { return organizationId; }
    public void setOrganizationId(String organizationId) { this.organizationId = organizationId; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id='" + id + '\'' +
                ", action='" + action + '\'' +
                ", resourceType='" + resourceType + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", actor=" + actor +
                ", createdAt=" + createdAt +
                '}';
    }
}
