package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateApiKeyParams {

    @JsonProperty("key_type")
    private String keyType;

    private String label;
    private String environment;

    public CreateApiKeyParams() {}

    public String getKeyType() { return keyType; }
    public CreateApiKeyParams setKeyType(String keyType) { this.keyType = keyType; return this; }

    public String getLabel() { return label; }
    public CreateApiKeyParams setLabel(String label) { this.label = label; return this; }

    public String getEnvironment() { return environment; }
    public CreateApiKeyParams setEnvironment(String environment) { this.environment = environment; return this; }
}
