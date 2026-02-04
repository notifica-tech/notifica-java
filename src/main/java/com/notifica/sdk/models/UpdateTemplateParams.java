package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateTemplateParams {

    private String name;
    private String content;
    private List<String> variables;
    private Map<String, String> variants;
    private String language;
    private String status;
    private Map<String, Object> metadata;

    @JsonProperty("provider_template_id")
    private String providerTemplateId;

    public UpdateTemplateParams() {}

    public String getName() { return name; }
    public UpdateTemplateParams setName(String name) { this.name = name; return this; }

    public String getContent() { return content; }
    public UpdateTemplateParams setContent(String content) { this.content = content; return this; }

    public List<String> getVariables() { return variables; }
    public UpdateTemplateParams setVariables(List<String> variables) { this.variables = variables; return this; }

    public Map<String, String> getVariants() { return variants; }
    public UpdateTemplateParams setVariants(Map<String, String> variants) { this.variants = variants; return this; }

    public String getLanguage() { return language; }
    public UpdateTemplateParams setLanguage(String language) { this.language = language; return this; }

    public String getStatus() { return status; }
    public UpdateTemplateParams setStatus(String status) { this.status = status; return this; }

    public Map<String, Object> getMetadata() { return metadata; }
    public UpdateTemplateParams setMetadata(Map<String, Object> metadata) { this.metadata = metadata; return this; }

    public String getProviderTemplateId() { return providerTemplateId; }
    public UpdateTemplateParams setProviderTemplateId(String providerTemplateId) { this.providerTemplateId = providerTemplateId; return this; }
}
