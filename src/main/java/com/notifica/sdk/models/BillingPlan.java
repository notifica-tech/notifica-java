package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingPlan {

    private String name;

    @JsonProperty("display_name")
    private String displayName;

    private String description;

    @JsonProperty("monthly_price_cents")
    private long monthlyPriceCents;

    @JsonProperty("yearly_price_cents")
    private long yearlyPriceCents;

    @JsonProperty("trial_days")
    private int trialDays;

    private Map<String, Object> quotas;
    private Map<String, Object> features;
    private boolean available;

    @JsonProperty("sort_order")
    private int sortOrder;

    public BillingPlan() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public long getMonthlyPriceCents() { return monthlyPriceCents; }
    public void setMonthlyPriceCents(long monthlyPriceCents) { this.monthlyPriceCents = monthlyPriceCents; }

    public long getYearlyPriceCents() { return yearlyPriceCents; }
    public void setYearlyPriceCents(long yearlyPriceCents) { this.yearlyPriceCents = yearlyPriceCents; }

    public int getTrialDays() { return trialDays; }
    public void setTrialDays(int trialDays) { this.trialDays = trialDays; }

    public Map<String, Object> getQuotas() { return quotas; }
    public void setQuotas(Map<String, Object> quotas) { this.quotas = quotas; }

    public Map<String, Object> getFeatures() { return features; }
    public void setFeatures(Map<String, Object> features) { this.features = features; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public int getSortOrder() { return sortOrder; }
    public void setSortOrder(int sortOrder) { this.sortOrder = sortOrder; }
}
