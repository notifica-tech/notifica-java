package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalyticsOverview {

    @JsonProperty("total_sent")
    private long totalSent;

    @JsonProperty("total_delivered")
    private long totalDelivered;

    @JsonProperty("total_failed")
    private long totalFailed;

    @JsonProperty("delivery_rate")
    private double deliveryRate;

    private String period;

    public AnalyticsOverview() {}

    public long getTotalSent() { return totalSent; }
    public void setTotalSent(long totalSent) { this.totalSent = totalSent; }

    public long getTotalDelivered() { return totalDelivered; }
    public void setTotalDelivered(long totalDelivered) { this.totalDelivered = totalDelivered; }

    public long getTotalFailed() { return totalFailed; }
    public void setTotalFailed(long totalFailed) { this.totalFailed = totalFailed; }

    public double getDeliveryRate() { return deliveryRate; }
    public void setDeliveryRate(double deliveryRate) { this.deliveryRate = deliveryRate; }

    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }
}
