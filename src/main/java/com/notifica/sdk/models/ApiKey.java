package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiKey {

    private String id;

    @JsonProperty("key_type")
    private String keyType;

    private String label;
    private String prefix;
    private String environment;

    @JsonProperty("raw_key")
    private String rawKey;

    @JsonProperty("created_at")
    private String createdAt;

    public ApiKey() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getKeyType() { return keyType; }
    public void setKeyType(String keyType) { this.keyType = keyType; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getPrefix() { return prefix; }
    public void setPrefix(String prefix) { this.prefix = prefix; }

    public String getEnvironment() { return environment; }
    public void setEnvironment(String environment) { this.environment = environment; }

    public String getRawKey() { return rawKey; }
    public void setRawKey(String rawKey) { this.rawKey = rawKey; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
