package com.notifica.sdk.models;

import java.util.List;

public class CreateWebhookParams {

    private String url;
    private List<String> events;

    public CreateWebhookParams() {}

    public String getUrl() { return url; }
    public CreateWebhookParams setUrl(String url) { this.url = url; return this; }

    public List<String> getEvents() { return events; }
    public CreateWebhookParams setEvents(List<String> events) { this.events = events; return this; }
}
