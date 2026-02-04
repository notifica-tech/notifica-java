package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidateContentParams {

    private String content;
    private String channel;
    private Map<String, String> variants;

    public ValidateContentParams() {}

    public String getContent() { return content; }
    public ValidateContentParams setContent(String content) { this.content = content; return this; }

    public String getChannel() { return channel; }
    public ValidateContentParams setChannel(String channel) { this.channel = channel; return this; }

    public Map<String, String> getVariants() { return variants; }
    public ValidateContentParams setVariants(Map<String, String> variants) { this.variants = variants; return this; }
}
