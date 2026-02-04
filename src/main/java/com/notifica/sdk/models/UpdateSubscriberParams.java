package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateSubscriberParams {

    private String email;
    private String phone;
    private String name;
    private String locale;
    private String timezone;

    @JsonProperty("custom_properties")
    private Map<String, Object> customProperties;

    public UpdateSubscriberParams() {}

    public String getEmail() { return email; }
    public UpdateSubscriberParams setEmail(String email) { this.email = email; return this; }

    public String getPhone() { return phone; }
    public UpdateSubscriberParams setPhone(String phone) { this.phone = phone; return this; }

    public String getName() { return name; }
    public UpdateSubscriberParams setName(String name) { this.name = name; return this; }

    public String getLocale() { return locale; }
    public UpdateSubscriberParams setLocale(String locale) { this.locale = locale; return this; }

    public String getTimezone() { return timezone; }
    public UpdateSubscriberParams setTimezone(String timezone) { this.timezone = timezone; return this; }

    public Map<String, Object> getCustomProperties() { return customProperties; }
    public UpdateSubscriberParams setCustomProperties(Map<String, Object> customProperties) { this.customProperties = customProperties; return this; }
}
