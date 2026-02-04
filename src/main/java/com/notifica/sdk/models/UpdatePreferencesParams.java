package com.notifica.sdk.models;

import java.util.List;

public class UpdatePreferencesParams {

    private List<NotificationPreference> preferences;

    public UpdatePreferencesParams() {}

    public List<NotificationPreference> getPreferences() { return preferences; }
    public UpdatePreferencesParams setPreferences(List<NotificationPreference> preferences) { this.preferences = preferences; return this; }
}
