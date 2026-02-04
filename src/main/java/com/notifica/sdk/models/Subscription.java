package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {

    private String id;

    @JsonProperty("plan_name")
    private String planName;

    private String status;
    private String period;

    @JsonProperty("starts_at")
    private String startsAt;

    @JsonProperty("current_period_ends_at")
    private String currentPeriodEndsAt;

    @JsonProperty("ends_at")
    private String endsAt;

    @JsonProperty("trial_days_remaining")
    private Integer trialDaysRemaining;

    @JsonProperty("in_trial")
    private boolean inTrial;

    @JsonProperty("auto_renew")
    private boolean autoRenew;

    @JsonProperty("current_price_cents")
    private long currentPriceCents;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public Subscription() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPlanName() { return planName; }
    public void setPlanName(String planName) { this.planName = planName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }

    public String getStartsAt() { return startsAt; }
    public void setStartsAt(String startsAt) { this.startsAt = startsAt; }

    public String getCurrentPeriodEndsAt() { return currentPeriodEndsAt; }
    public void setCurrentPeriodEndsAt(String currentPeriodEndsAt) { this.currentPeriodEndsAt = currentPeriodEndsAt; }

    public String getEndsAt() { return endsAt; }
    public void setEndsAt(String endsAt) { this.endsAt = endsAt; }

    public Integer getTrialDaysRemaining() { return trialDaysRemaining; }
    public void setTrialDaysRemaining(Integer trialDaysRemaining) { this.trialDaysRemaining = trialDaysRemaining; }

    public boolean isInTrial() { return inTrial; }
    public void setInTrial(boolean inTrial) { this.inTrial = inTrial; }

    public boolean isAutoRenew() { return autoRenew; }
    public void setAutoRenew(boolean autoRenew) { this.autoRenew = autoRenew; }

    public long getCurrentPriceCents() { return currentPriceCents; }
    public void setCurrentPriceCents(long currentPriceCents) { this.currentPriceCents = currentPriceCents; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
