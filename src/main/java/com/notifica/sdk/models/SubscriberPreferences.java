package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriberPreferences {

    private List<NotificationPreference> preferences;

    public SubscriberPreferences() {}

    public List<NotificationPreference> getPreferences() { return preferences; }
    public void setPreferences(List<NotificationPreference> preferences) { this.preferences = preferences; }
}
