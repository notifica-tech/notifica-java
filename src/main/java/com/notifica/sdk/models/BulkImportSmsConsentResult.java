package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BulkImportSmsConsentResult {

    private int imported;
    private List<Map<String, String>> errors;

    public BulkImportSmsConsentResult() {}

    public int getImported() { return imported; }
    public void setImported(int imported) { this.imported = imported; }

    public List<Map<String, String>> getErrors() { return errors; }
    public void setErrors(List<Map<String, String>> errors) { this.errors = errors; }
}
