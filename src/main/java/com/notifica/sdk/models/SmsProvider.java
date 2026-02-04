package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsProvider {

    private String id;
    private String type;
    private String name;

    @JsonProperty("config_mask")
    private String configMask;

    private boolean active;

    @JsonProperty("is_default")
    private boolean isDefault;

    @JsonProperty("allowed_regions")
    private List<String> allowedRegions;

    @JsonProperty("rate_limit_per_minute")
    private Integer rateLimitPerMinute;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public SmsProvider() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getConfigMask() { return configMask; }
    public void setConfigMask(String configMask) { this.configMask = configMask; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public boolean isDefault() { return isDefault; }
    public void setDefault(boolean isDefault) { this.isDefault = isDefault; }

    public List<String> getAllowedRegions() { return allowedRegions; }
    public void setAllowedRegions(List<String> allowedRegions) { this.allowedRegions = allowedRegions; }

    public Integer getRateLimitPerMinute() { return rateLimitPerMinute; }
    public void setRateLimitPerMinute(Integer rateLimitPerMinute) { this.rateLimitPerMinute = rateLimitPerMinute; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
