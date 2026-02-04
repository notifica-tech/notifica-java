package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsConsent {

    private String phone;
    private String status;
    private String source;
    private Map<String, Object> metadata;

    @JsonProperty("opted_in_at")
    private String optedInAt;

    @JsonProperty("opted_out_at")
    private String optedOutAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public SmsConsent() {}

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }

    public String getOptedInAt() { return optedInAt; }
    public void setOptedInAt(String optedInAt) { this.optedInAt = optedInAt; }

    public String getOptedOutAt() { return optedOutAt; }
    public void setOptedOutAt(String optedOutAt) { this.optedOutAt = optedOutAt; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
