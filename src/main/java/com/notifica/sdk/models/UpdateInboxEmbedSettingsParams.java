package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateInboxEmbedSettingsParams {

    private Boolean enabled;
    private String theme;
    private String position;
    private String title;

    @JsonProperty("primary_color")
    private String primaryColor;

    @JsonProperty("background_color")
    private String backgroundColor;

    @JsonProperty("show_sender_avatar")
    private Boolean showSenderAvatar;

    @JsonProperty("show_timestamp")
    private Boolean showTimestamp;

    @JsonProperty("date_format")
    private String dateFormat;

    @JsonProperty("max_notifications")
    private Integer maxNotifications;

    @JsonProperty("empty_state_text")
    private String emptyStateText;

    @JsonProperty("custom_logo_url")
    private String customLogoUrl;

    @JsonProperty("custom_css")
    private String customCss;

    @JsonProperty("allowed_domains")
    private List<String> allowedDomains;

    public UpdateInboxEmbedSettingsParams() {}

    public Boolean getEnabled() { return enabled; }
    public UpdateInboxEmbedSettingsParams setEnabled(Boolean enabled) { this.enabled = enabled; return this; }

    public String getTheme() { return theme; }
    public UpdateInboxEmbedSettingsParams setTheme(String theme) { this.theme = theme; return this; }

    public String getPosition() { return position; }
    public UpdateInboxEmbedSettingsParams setPosition(String position) { this.position = position; return this; }

    public String getTitle() { return title; }
    public UpdateInboxEmbedSettingsParams setTitle(String title) { this.title = title; return this; }

    public String getPrimaryColor() { return primaryColor; }
    public UpdateInboxEmbedSettingsParams setPrimaryColor(String primaryColor) { this.primaryColor = primaryColor; return this; }

    public String getBackgroundColor() { return backgroundColor; }
    public UpdateInboxEmbedSettingsParams setBackgroundColor(String backgroundColor) { this.backgroundColor = backgroundColor; return this; }

    public Boolean getShowSenderAvatar() { return showSenderAvatar; }
    public UpdateInboxEmbedSettingsParams setShowSenderAvatar(Boolean showSenderAvatar) { this.showSenderAvatar = showSenderAvatar; return this; }

    public Boolean getShowTimestamp() { return showTimestamp; }
    public UpdateInboxEmbedSettingsParams setShowTimestamp(Boolean showTimestamp) { this.showTimestamp = showTimestamp; return this; }

    public String getDateFormat() { return dateFormat; }
    public UpdateInboxEmbedSettingsParams setDateFormat(String dateFormat) { this.dateFormat = dateFormat; return this; }

    public Integer getMaxNotifications() { return maxNotifications; }
    public UpdateInboxEmbedSettingsParams setMaxNotifications(Integer maxNotifications) { this.maxNotifications = maxNotifications; return this; }

    public String getEmptyStateText() { return emptyStateText; }
    public UpdateInboxEmbedSettingsParams setEmptyStateText(String emptyStateText) { this.emptyStateText = emptyStateText; return this; }

    public String getCustomLogoUrl() { return customLogoUrl; }
    public UpdateInboxEmbedSettingsParams setCustomLogoUrl(String customLogoUrl) { this.customLogoUrl = customLogoUrl; return this; }

    public String getCustomCss() { return customCss; }
    public UpdateInboxEmbedSettingsParams setCustomCss(String customCss) { this.customCss = customCss; return this; }

    public List<String> getAllowedDomains() { return allowedDomains; }
    public UpdateInboxEmbedSettingsParams setAllowedDomains(List<String> allowedDomains) { this.allowedDomains = allowedDomains; return this; }
}
