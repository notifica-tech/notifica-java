package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateSmsProviderParams {

    private String name;
    private Map<String, Object> config;
    private Boolean active;

    @JsonProperty("allowed_regions")
    private List<String> allowedRegions;

    @JsonProperty("rate_limit_per_minute")
    private Integer rateLimitPerMinute;

    public UpdateSmsProviderParams() {}

    public String getName() { return name; }
    public UpdateSmsProviderParams setName(String name) { this.name = name; return this; }

    public Map<String, Object> getConfig() { return config; }
    public UpdateSmsProviderParams setConfig(Map<String, Object> config) { this.config = config; return this; }

    public Boolean getActive() { return active; }
    public UpdateSmsProviderParams setActive(Boolean active) { this.active = active; return this; }

    public List<String> getAllowedRegions() { return allowedRegions; }
    public UpdateSmsProviderParams setAllowedRegions(List<String> allowedRegions) { this.allowedRegions = allowedRegions; return this; }

    public Integer getRateLimitPerMinute() { return rateLimitPerMinute; }
    public UpdateSmsProviderParams setRateLimitPerMinute(Integer rateLimitPerMinute) { this.rateLimitPerMinute = rateLimitPerMinute; return this; }
}
