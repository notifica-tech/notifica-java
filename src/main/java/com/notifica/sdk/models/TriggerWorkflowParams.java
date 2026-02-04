package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TriggerWorkflowParams {

    private String recipient;
    private Map<String, Object> data;

    public TriggerWorkflowParams() {}

    public String getRecipient() { return recipient; }
    public TriggerWorkflowParams setRecipient(String recipient) { this.recipient = recipient; return this; }

    public Map<String, Object> getData() { return data; }
    public TriggerWorkflowParams setData(Map<String, Object> data) { this.data = data; return this; }
}
