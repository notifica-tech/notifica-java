package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PreviewContentParams {

    private String content;
    private String channel;
    private Map<String, Object> variables;
    private Map<String, String> variants;

    public PreviewContentParams() {}

    public String getContent() { return content; }
    public PreviewContentParams setContent(String content) { this.content = content; return this; }

    public String getChannel() { return channel; }
    public PreviewContentParams setChannel(String channel) { this.channel = channel; return this; }

    public Map<String, Object> getVariables() { return variables; }
    public PreviewContentParams setVariables(Map<String, Object> variables) { this.variables = variables; return this; }

    public Map<String, String> getVariants() { return variants; }
    public PreviewContentParams setVariants(Map<String, String> variants) { this.variants = variants; return this; }
}
