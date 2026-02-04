package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InboxEmbedSettings {

    private boolean enabled;
    private String theme;
    private String position;
    private String title;

    @JsonProperty("primary_color")
    private String primaryColor;

    @JsonProperty("background_color")
    private String backgroundColor;

    @JsonProperty("unread_badge_text")
    private String unreadBadgeText;

    @JsonProperty("show_sender_avatar")
    private boolean showSenderAvatar;

    @JsonProperty("show_timestamp")
    private boolean showTimestamp;

    @JsonProperty("date_format")
    private String dateFormat;

    @JsonProperty("max_notifications")
    private int maxNotifications;

    @JsonProperty("empty_state_text")
    private String emptyStateText;

    @JsonProperty("custom_logo_url")
    private String customLogoUrl;

    @JsonProperty("custom_css")
    private String customCss;

    @JsonProperty("embed_key")
    private String embedKey;

    @JsonProperty("allowed_domains")
    private List<String> allowedDomains;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public InboxEmbedSettings() {}

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPrimaryColor() { return primaryColor; }
    public void setPrimaryColor(String primaryColor) { this.primaryColor = primaryColor; }

    public String getBackgroundColor() { return backgroundColor; }
    public void setBackgroundColor(String backgroundColor) { this.backgroundColor = backgroundColor; }

    public String getUnreadBadgeText() { return unreadBadgeText; }
    public void setUnreadBadgeText(String unreadBadgeText) { this.unreadBadgeText = unreadBadgeText; }

    public boolean isShowSenderAvatar() { return showSenderAvatar; }
    public void setShowSenderAvatar(boolean showSenderAvatar) { this.showSenderAvatar = showSenderAvatar; }

    public boolean isShowTimestamp() { return showTimestamp; }
    public void setShowTimestamp(boolean showTimestamp) { this.showTimestamp = showTimestamp; }

    public String getDateFormat() { return dateFormat; }
    public void setDateFormat(String dateFormat) { this.dateFormat = dateFormat; }

    public int getMaxNotifications() { return maxNotifications; }
    public void setMaxNotifications(int maxNotifications) { this.maxNotifications = maxNotifications; }

    public String getEmptyStateText() { return emptyStateText; }
    public void setEmptyStateText(String emptyStateText) { this.emptyStateText = emptyStateText; }

    public String getCustomLogoUrl() { return customLogoUrl; }
    public void setCustomLogoUrl(String customLogoUrl) { this.customLogoUrl = customLogoUrl; }

    public String getCustomCss() { return customCss; }
    public void setCustomCss(String customCss) { this.customCss = customCss; }

    public String getEmbedKey() { return embedKey; }
    public void setEmbedKey(String embedKey) { this.embedKey = embedKey; }

    public List<String> getAllowedDomains() { return allowedDomains; }
    public void setAllowedDomains(List<String> allowedDomains) { this.allowedDomains = allowedDomains; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
