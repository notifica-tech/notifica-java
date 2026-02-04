package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsConsentSummary {

    private long total;

    @JsonProperty("opted_in")
    private long optedIn;

    @JsonProperty("opted_out")
    private long optedOut;

    private long pending;

    @JsonProperty("by_source")
    private Map<String, Long> bySource;

    public SmsConsentSummary() {}

    public long getTotal() { return total; }
    public void setTotal(long total) { this.total = total; }

    public long getOptedIn() { return optedIn; }
    public void setOptedIn(long optedIn) { this.optedIn = optedIn; }

    public long getOptedOut() { return optedOut; }
    public void setOptedOut(long optedOut) { this.optedOut = optedOut; }

    public long getPending() { return pending; }
    public void setPending(long pending) { this.pending = pending; }

    public Map<String, Long> getBySource() { return bySource; }
    public void setBySource(Map<String, Long> bySource) { this.bySource = bySource; }
}
