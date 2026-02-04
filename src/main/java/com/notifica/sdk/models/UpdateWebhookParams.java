package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateWebhookParams {

    private String url;
    private List<String> events;
    private Boolean active;

    public UpdateWebhookParams() {}

    public String getUrl() { return url; }
    public UpdateWebhookParams setUrl(String url) { this.url = url; return this; }

    public List<String> getEvents() { return events; }
    public UpdateWebhookParams setEvents(List<String> events) { this.events = events; return this; }

    public Boolean getActive() { return active; }
    public UpdateWebhookParams setActive(Boolean active) { this.active = active; return this; }
}
