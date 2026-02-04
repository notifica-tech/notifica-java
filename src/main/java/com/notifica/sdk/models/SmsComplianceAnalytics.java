package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsComplianceAnalytics {

    @JsonProperty("period_start")
    private String periodStart;

    @JsonProperty("period_end")
    private String periodEnd;

    @JsonProperty("total_messages")
    private long totalMessages;

    @JsonProperty("messages_blocked_by_compliance")
    private long messagesBlockedByCompliance;

    @JsonProperty("opt_outs_received")
    private long optOutsReceived;

    @JsonProperty("opt_ins_received")
    private long optInsReceived;

    @JsonProperty("violations_by_type")
    private Map<String, Long> violationsByType;

    public SmsComplianceAnalytics() {}

    public String getPeriodStart() { return periodStart; }
    public void setPeriodStart(String periodStart) { this.periodStart = periodStart; }

    public String getPeriodEnd() { return periodEnd; }
    public void setPeriodEnd(String periodEnd) { this.periodEnd = periodEnd; }

    public long getTotalMessages() { return totalMessages; }
    public void setTotalMessages(long totalMessages) { this.totalMessages = totalMessages; }

    public long getMessagesBlockedByCompliance() { return messagesBlockedByCompliance; }
    public void setMessagesBlockedByCompliance(long messagesBlockedByCompliance) { this.messagesBlockedByCompliance = messagesBlockedByCompliance; }

    public long getOptOutsReceived() { return optOutsReceived; }
    public void setOptOutsReceived(long optOutsReceived) { this.optOutsReceived = optOutsReceived; }

    public long getOptInsReceived() { return optInsReceived; }
    public void setOptInsReceived(long optInsReceived) { this.optInsReceived = optInsReceived; }

    public Map<String, Long> getViolationsByType() { return violationsByType; }
    public void setViolationsByType(Map<String, Long> violationsByType) { this.violationsByType = violationsByType; }
}
