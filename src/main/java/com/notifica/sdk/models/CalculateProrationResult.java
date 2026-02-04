package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculateProrationResult {

    @JsonProperty("current_plan_credit_cents")
    private long currentPlanCreditCents;

    @JsonProperty("new_plan_debit_cents")
    private long newPlanDebitCents;

    @JsonProperty("proration_amount_cents")
    private long prorationAmountCents;

    @JsonProperty("next_billing_date")
    private String nextBillingDate;

    public CalculateProrationResult() {}

    public long getCurrentPlanCreditCents() { return currentPlanCreditCents; }
    public void setCurrentPlanCreditCents(long currentPlanCreditCents) { this.currentPlanCreditCents = currentPlanCreditCents; }

    public long getNewPlanDebitCents() { return newPlanDebitCents; }
    public void setNewPlanDebitCents(long newPlanDebitCents) { this.newPlanDebitCents = newPlanDebitCents; }

    public long getProrationAmountCents() { return prorationAmountCents; }
    public void setProrationAmountCents(long prorationAmountCents) { this.prorationAmountCents = prorationAmountCents; }

    public String getNextBillingDate() { return nextBillingDate; }
    public void setNextBillingDate(String nextBillingDate) { this.nextBillingDate = nextBillingDate; }
}
