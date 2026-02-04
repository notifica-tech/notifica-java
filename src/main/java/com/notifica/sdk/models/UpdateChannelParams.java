package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateChannelParams {

    private String provider;
    private Map<String, Object> credentials;
    private Map<String, Object> settings;

    public UpdateChannelParams() {}

    public String getProvider() { return provider; }
    public UpdateChannelParams setProvider(String provider) { this.provider = provider; return this; }

    public Map<String, Object> getCredentials() { return credentials; }
    public UpdateChannelParams setCredentials(Map<String, Object> credentials) { this.credentials = credentials; return this; }

    public Map<String, Object> getSettings() { return settings; }
    public UpdateChannelParams setSettings(Map<String, Object> settings) { this.settings = settings; return this; }
}
