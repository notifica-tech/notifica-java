package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidateSmsProviderResult {

    private boolean valid;
    private String message;
    private Map<String, List<String>> errors;

    public ValidateSmsProviderResult() {}

    public boolean isValid() { return valid; }
    public void setValid(boolean valid) { this.valid = valid; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Map<String, List<String>> getErrors() { return errors; }
    public void setErrors(Map<String, List<String>> errors) { this.errors = errors; }
}
