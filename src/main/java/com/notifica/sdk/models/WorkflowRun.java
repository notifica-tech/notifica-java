package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkflowRun {

    private String id;

    @JsonProperty("workflow_id")
    private String workflowId;

    @JsonProperty("workflow_slug")
    private String workflowSlug;

    @JsonProperty("workflow_version")
    private int workflowVersion;

    private String status;
    private String recipient;
    private Map<String, Object> data;

    @JsonProperty("step_results")
    private List<StepResult> stepResults;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public WorkflowRun() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getWorkflowId() { return workflowId; }
    public void setWorkflowId(String workflowId) { this.workflowId = workflowId; }

    public String getWorkflowSlug() { return workflowSlug; }
    public void setWorkflowSlug(String workflowSlug) { this.workflowSlug = workflowSlug; }

    public int getWorkflowVersion() { return workflowVersion; }
    public void setWorkflowVersion(int workflowVersion) { this.workflowVersion = workflowVersion; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }

    public Map<String, Object> getData() { return data; }
    public void setData(Map<String, Object> data) { this.data = data; }

    public List<StepResult> getStepResults() { return stepResults; }
    public void setStepResults(List<StepResult> stepResults) { this.stepResults = stepResults; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
