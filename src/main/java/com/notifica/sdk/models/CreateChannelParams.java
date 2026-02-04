package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateChannelParams {

    private String channel;
    private String provider;
    private Map<String, Object> credentials;
    private Map<String, Object> settings;

    public CreateChannelParams() {}

    public String getChannel() { return channel; }
    public CreateChannelParams setChannel(String channel) { this.channel = channel; return this; }

    public String getProvider() { return provider; }
    public CreateChannelParams setProvider(String provider) { this.provider = provider; return this; }

    public Map<String, Object> getCredentials() { return credentials; }
    public CreateChannelParams setCredentials(Map<String, Object> credentials) { this.credentials = credentials; return this; }

    public Map<String, Object> getSettings() { return settings; }
    public CreateChannelParams setSettings(Map<String, Object> settings) { this.settings = settings; return this; }
}
