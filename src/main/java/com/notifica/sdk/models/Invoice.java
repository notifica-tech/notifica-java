package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {

    private String id;

    @JsonProperty("subscription_id")
    private String subscriptionId;

    private String status;

    @JsonProperty("amount_cents")
    private long amountCents;

    @JsonProperty("amount_paid_cents")
    private long amountPaidCents;

    private String currency;
    private String description;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("due_date")
    private String dueDate;

    @JsonProperty("paid_at")
    private String paidAt;

    @JsonProperty("boleto_url")
    private String boletoUrl;

    @JsonProperty("pix_code")
    private String pixCode;

    @JsonProperty("pix_qr_code")
    private String pixQrCode;

    @JsonProperty("boleto_line")
    private String boletoLine;

    @JsonProperty("boleto_pdf_url")
    private String boletoPdfUrl;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public Invoice() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSubscriptionId() { return subscriptionId; }
    public void setSubscriptionId(String subscriptionId) { this.subscriptionId = subscriptionId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public long getAmountCents() { return amountCents; }
    public void setAmountCents(long amountCents) { this.amountCents = amountCents; }

    public long getAmountPaidCents() { return amountPaidCents; }
    public void setAmountPaidCents(long amountPaidCents) { this.amountPaidCents = amountPaidCents; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public String getPaidAt() { return paidAt; }
    public void setPaidAt(String paidAt) { this.paidAt = paidAt; }

    public String getBoletoUrl() { return boletoUrl; }
    public void setBoletoUrl(String boletoUrl) { this.boletoUrl = boletoUrl; }

    public String getPixCode() { return pixCode; }
    public void setPixCode(String pixCode) { this.pixCode = pixCode; }

    public String getPixQrCode() { return pixQrCode; }
    public void setPixQrCode(String pixQrCode) { this.pixQrCode = pixQrCode; }

    public String getBoletoLine() { return boletoLine; }
    public void setBoletoLine(String boletoLine) { this.boletoLine = boletoLine; }

    public String getBoletoPdfUrl() { return boletoPdfUrl; }
    public void setBoletoPdfUrl(String boletoPdfUrl) { this.boletoPdfUrl = boletoPdfUrl; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
