package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeseriesPoint {

    private String timestamp;
    private long sent;
    private long delivered;
    private long failed;

    public TimeseriesPoint() {}

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public long getSent() { return sent; }
    public void setSent(long sent) { this.sent = sent; }

    public long getDelivered() { return delivered; }
    public void setDelivered(long delivered) { this.delivered = delivered; }

    public long getFailed() { return failed; }
    public void setFailed(long failed) { this.failed = failed; }
}
