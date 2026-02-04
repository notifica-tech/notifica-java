package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateSmsConsentParams {

    private String phone;
    private String status;
    private String source;
    private Map<String, Object> metadata;

    public CreateSmsConsentParams() {}

    public String getPhone() { return phone; }
    public CreateSmsConsentParams setPhone(String phone) { this.phone = phone; return this; }

    public String getStatus() { return status; }
    public CreateSmsConsentParams setStatus(String status) { this.status = status; return this; }

    public String getSource() { return source; }
    public CreateSmsConsentParams setSource(String source) { this.source = source; return this; }

    public Map<String, Object> getMetadata() { return metadata; }
    public CreateSmsConsentParams setMetadata(Map<String, Object> metadata) { this.metadata = metadata; return this; }
}
