package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsComplianceSettings {

    @JsonProperty("allowed_hours_start")
    private String allowedHoursStart;

    @JsonProperty("allowed_hours_end")
    private String allowedHoursEnd;

    @JsonProperty("allowed_weekdays")
    private List<Integer> allowedWeekdays;

    @JsonProperty("respect_national_holidays")
    private boolean respectNationalHolidays;

    @JsonProperty("custom_holidays")
    private List<String> customHolidays;

    @JsonProperty("opt_out_message")
    private String optOutMessage;

    @JsonProperty("opt_out_keywords")
    private List<String> optOutKeywords;

    @JsonProperty("opt_out_cooldown_hours")
    private Integer optOutCooldownHours;

    @JsonProperty("opt_in_confirmation_message")
    private String optInConfirmationMessage;

    public SmsComplianceSettings() {}

    public String getAllowedHoursStart() { return allowedHoursStart; }
    public void setAllowedHoursStart(String allowedHoursStart) { this.allowedHoursStart = allowedHoursStart; }

    public String getAllowedHoursEnd() { return allowedHoursEnd; }
    public void setAllowedHoursEnd(String allowedHoursEnd) { this.allowedHoursEnd = allowedHoursEnd; }

    public List<Integer> getAllowedWeekdays() { return allowedWeekdays; }
    public void setAllowedWeekdays(List<Integer> allowedWeekdays) { this.allowedWeekdays = allowedWeekdays; }

    public boolean isRespectNationalHolidays() { return respectNationalHolidays; }
    public void setRespectNationalHolidays(boolean respectNationalHolidays) { this.respectNationalHolidays = respectNationalHolidays; }

    public List<String> getCustomHolidays() { return customHolidays; }
    public void setCustomHolidays(List<String> customHolidays) { this.customHolidays = customHolidays; }

    public String getOptOutMessage() { return optOutMessage; }
    public void setOptOutMessage(String optOutMessage) { this.optOutMessage = optOutMessage; }

    public List<String> getOptOutKeywords() { return optOutKeywords; }
    public void setOptOutKeywords(List<String> optOutKeywords) { this.optOutKeywords = optOutKeywords; }

    public Integer getOptOutCooldownHours() { return optOutCooldownHours; }
    public void setOptOutCooldownHours(Integer optOutCooldownHours) { this.optOutCooldownHours = optOutCooldownHours; }

    public String getOptInConfirmationMessage() { return optInConfirmationMessage; }
    public void setOptInConfirmationMessage(String optInConfirmationMessage) { this.optInConfirmationMessage = optInConfirmationMessage; }
}
