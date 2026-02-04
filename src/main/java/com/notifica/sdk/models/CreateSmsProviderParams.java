package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateSmsProviderParams {

    private String type;
    private String name;
    private Map<String, Object> config;
    private Boolean active;

    @JsonProperty("allowed_regions")
    private List<String> allowedRegions;

    @JsonProperty("rate_limit_per_minute")
    private Integer rateLimitPerMinute;

    public CreateSmsProviderParams() {}

    public String getType() { return type; }
    public CreateSmsProviderParams setType(String type) { this.type = type; return this; }

    public String getName() { return name; }
    public CreateSmsProviderParams setName(String name) { this.name = name; return this; }

    public Map<String, Object> getConfig() { return config; }
    public CreateSmsProviderParams setConfig(Map<String, Object> config) { this.config = config; return this; }

    public Boolean getActive() { return active; }
    public CreateSmsProviderParams setActive(Boolean active) { this.active = active; return this; }

    public List<String> getAllowedRegions() { return allowedRegions; }
    public CreateSmsProviderParams setAllowedRegions(List<String> allowedRegions) { this.allowedRegions = allowedRegions; return this; }

    public Integer getRateLimitPerMinute() { return rateLimitPerMinute; }
    public CreateSmsProviderParams setRateLimitPerMinute(Integer rateLimitPerMinute) { this.rateLimitPerMinute = rateLimitPerMinute; return this; }
}
