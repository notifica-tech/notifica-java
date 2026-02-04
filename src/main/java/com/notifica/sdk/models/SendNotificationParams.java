package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendNotificationParams {

    private String channel;
    private String to;
    private String template;
    private Map<String, Object> data;
    private Map<String, Object> metadata;

    public SendNotificationParams() {}

    public String getChannel() { return channel; }
    public SendNotificationParams setChannel(String channel) { this.channel = channel; return this; }

    public String getTo() { return to; }
    public SendNotificationParams setTo(String to) { this.to = to; return this; }

    public String getTemplate() { return template; }
    public SendNotificationParams setTemplate(String template) { this.template = template; return this; }

    public Map<String, Object> getData() { return data; }
    public SendNotificationParams setData(Map<String, Object> data) { this.data = data; return this; }

    public Map<String, Object> getMetadata() { return metadata; }
    public SendNotificationParams setMetadata(Map<String, Object> metadata) { this.metadata = metadata; return this; }
}
