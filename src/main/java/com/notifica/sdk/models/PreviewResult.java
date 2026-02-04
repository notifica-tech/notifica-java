package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PreviewResult {

    private Map<String, String> rendered;
    private List<String> variables;
    private ValidationResult validation;

    public PreviewResult() {}

    public Map<String, String> getRendered() { return rendered; }
    public void setRendered(Map<String, String> rendered) { this.rendered = rendered; }

    public List<String> getVariables() { return variables; }
    public void setVariables(List<String> variables) { this.variables = variables; }

    public ValidationResult getValidation() { return validation; }
    public void setValidation(ValidationResult validation) { this.validation = validation; }
}
