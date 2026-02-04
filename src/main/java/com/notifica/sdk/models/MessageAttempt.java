package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageAttempt {

    private String id;

    @JsonProperty("attempt_number")
    private int attemptNumber;

    private String status;

    @JsonProperty("provider_response")
    private Map<String, Object> providerResponse;

    @JsonProperty("created_at")
    private String createdAt;

    public MessageAttempt() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getAttemptNumber() { return attemptNumber; }
    public void setAttemptNumber(int attemptNumber) { this.attemptNumber = attemptNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Map<String, Object> getProviderResponse() { return providerResponse; }
    public void setProviderResponse(Map<String, Object> providerResponse) { this.providerResponse = providerResponse; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
