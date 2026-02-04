package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotificationPreference {

    private String category;
    private String channel;
    private boolean enabled;

    public NotificationPreference() {}

    public String getCategory() { return category; }
    public NotificationPreference setCategory(String category) { this.category = category; return this; }

    public String getChannel() { return channel; }
    public NotificationPreference setChannel(String channel) { this.channel = channel; return this; }

    public boolean isEnabled() { return enabled; }
    public NotificationPreference setEnabled(boolean enabled) { this.enabled = enabled; return this; }
}
