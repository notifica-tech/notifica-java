package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateSubscriberParams {

    @JsonProperty("external_id")
    private String externalId;

    private String email;
    private String phone;
    private String name;
    private String locale;
    private String timezone;

    @JsonProperty("custom_properties")
    private Map<String, Object> customProperties;

    public CreateSubscriberParams() {}

    public String getExternalId() { return externalId; }
    public CreateSubscriberParams setExternalId(String externalId) { this.externalId = externalId; return this; }

    public String getEmail() { return email; }
    public CreateSubscriberParams setEmail(String email) { this.email = email; return this; }

    public String getPhone() { return phone; }
    public CreateSubscriberParams setPhone(String phone) { this.phone = phone; return this; }

    public String getName() { return name; }
    public CreateSubscriberParams setName(String name) { this.name = name; return this; }

    public String getLocale() { return locale; }
    public CreateSubscriberParams setLocale(String locale) { this.locale = locale; return this; }

    public String getTimezone() { return timezone; }
    public CreateSubscriberParams setTimezone(String timezone) { this.timezone = timezone; return this; }

    public Map<String, Object> getCustomProperties() { return customProperties; }
    public CreateSubscriberParams setCustomProperties(Map<String, Object> customProperties) { this.customProperties = customProperties; return this; }
}
