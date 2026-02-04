package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingSettings {

    private String gateway;
    private String currency;
    private String timezone;

    @JsonProperty("due_day")
    private Integer dueDay;

    @JsonProperty("tax_info")
    private Map<String, Object> taxInfo;

    public BillingSettings() {}

    public String getGateway() { return gateway; }
    public void setGateway(String gateway) { this.gateway = gateway; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }

    public Integer getDueDay() { return dueDay; }
    public void setDueDay(Integer dueDay) { this.dueDay = dueDay; }

    public Map<String, Object> getTaxInfo() { return taxInfo; }
    public void setTaxInfo(Map<String, Object> taxInfo) { this.taxInfo = taxInfo; }
}
