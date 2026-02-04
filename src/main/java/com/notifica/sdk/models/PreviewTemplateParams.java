package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PreviewTemplateParams {

    private Map<String, Object> variables;

    public PreviewTemplateParams() {}

    public Map<String, Object> getVariables() { return variables; }
    public PreviewTemplateParams setVariables(Map<String, Object> variables) { this.variables = variables; return this; }
}
