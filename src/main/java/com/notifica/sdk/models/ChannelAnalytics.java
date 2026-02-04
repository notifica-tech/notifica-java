package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelAnalytics {

    private String channel;
    private long sent;
    private long delivered;
    private long failed;

    @JsonProperty("delivery_rate")
    private double deliveryRate;

    public ChannelAnalytics() {}

    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }

    public long getSent() { return sent; }
    public void setSent(long sent) { this.sent = sent; }

    public long getDelivered() { return delivered; }
    public void setDelivered(long delivered) { this.delivered = delivered; }

    public long getFailed() { return failed; }
    public void setFailed(long failed) { this.failed = failed; }

    public double getDeliveryRate() { return deliveryRate; }
    public void setDeliveryRate(double deliveryRate) { this.deliveryRate = deliveryRate; }
}
