package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateAnalytics {

    @JsonProperty("template_id")
    private String templateId;

    @JsonProperty("template_name")
    private String templateName;

    private long sent;
    private long delivered;

    @JsonProperty("delivery_rate")
    private double deliveryRate;

    public TemplateAnalytics() {}

    public String getTemplateId() { return templateId; }
    public void setTemplateId(String templateId) { this.templateId = templateId; }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }

    public long getSent() { return sent; }
    public void setSent(long sent) { this.sent = sent; }

    public long getDelivered() { return delivered; }
    public void setDelivered(long delivered) { this.delivered = delivered; }

    public double getDeliveryRate() { return deliveryRate; }
    public void setDeliveryRate(double deliveryRate) { this.deliveryRate = deliveryRate; }
}
