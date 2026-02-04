package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingUsage {

    @JsonProperty("period_start")
    private String periodStart;

    @JsonProperty("period_end")
    private String periodEnd;

    private Map<String, Object> current;
    private Map<String, Object> quotas;
    private Map<String, Object> percentages;

    public BillingUsage() {}

    public String getPeriodStart() { return periodStart; }
    public void setPeriodStart(String periodStart) { this.periodStart = periodStart; }

    public String getPeriodEnd() { return periodEnd; }
    public void setPeriodEnd(String periodEnd) { this.periodEnd = periodEnd; }

    public Map<String, Object> getCurrent() { return current; }
    public void setCurrent(Map<String, Object> current) { this.current = current; }

    public Map<String, Object> getQuotas() { return quotas; }
    public void setQuotas(Map<String, Object> quotas) { this.quotas = quotas; }

    public Map<String, Object> getPercentages() { return percentages; }
    public void setPercentages(Map<String, Object> percentages) { this.percentages = percentages; }
}
