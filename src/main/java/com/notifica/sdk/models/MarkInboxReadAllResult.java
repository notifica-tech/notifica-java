package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarkInboxReadAllResult {

    private boolean success;

    @JsonProperty("marked_count")
    private int markedCount;

    public MarkInboxReadAllResult() {}

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public int getMarkedCount() { return markedCount; }
    public void setMarkedCount(int markedCount) { this.markedCount = markedCount; }
}
