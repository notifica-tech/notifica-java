package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateTemplateParams {

    private String channel;
    private String slug;
    private String name;
    private String content;
    private List<String> variables;
    private Map<String, String> variants;
    private String language;
    private String status;
    private Map<String, Object> metadata;

    @JsonProperty("provider_template_id")
    private String providerTemplateId;

    public CreateTemplateParams() {}

    public String getChannel() { return channel; }
    public CreateTemplateParams setChannel(String channel) { this.channel = channel; return this; }

    public String getSlug() { return slug; }
    public CreateTemplateParams setSlug(String slug) { this.slug = slug; return this; }

    public String getName() { return name; }
    public CreateTemplateParams setName(String name) { this.name = name; return this; }

    public String getContent() { return content; }
    public CreateTemplateParams setContent(String content) { this.content = content; return this; }

    public List<String> getVariables() { return variables; }
    public CreateTemplateParams setVariables(List<String> variables) { this.variables = variables; return this; }

    public Map<String, String> getVariants() { return variants; }
    public CreateTemplateParams setVariants(Map<String, String> variants) { this.variants = variants; return this; }

    public String getLanguage() { return language; }
    public CreateTemplateParams setLanguage(String language) { this.language = language; return this; }

    public String getStatus() { return status; }
    public CreateTemplateParams setStatus(String status) { this.status = status; return this; }

    public Map<String, Object> getMetadata() { return metadata; }
    public CreateTemplateParams setMetadata(Map<String, Object> metadata) { this.metadata = metadata; return this; }

    public String getProviderTemplateId() { return providerTemplateId; }
    public CreateTemplateParams setProviderTemplateId(String providerTemplateId) { this.providerTemplateId = providerTemplateId; return this; }
}
