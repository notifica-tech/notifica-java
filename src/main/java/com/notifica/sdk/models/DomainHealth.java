package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainHealth {

    @JsonProperty("domain_id")
    private String domainId;

    @JsonProperty("dns_valid")
    private boolean dnsValid;

    @JsonProperty("dkim_valid")
    private boolean dkimValid;

    @JsonProperty("spf_valid")
    private boolean spfValid;

    @JsonProperty("last_checked_at")
    private String lastCheckedAt;

    private List<String> issues;

    public DomainHealth() {}

    public String getDomainId() { return domainId; }
    public void setDomainId(String domainId) { this.domainId = domainId; }

    public boolean isDnsValid() { return dnsValid; }
    public void setDnsValid(boolean dnsValid) { this.dnsValid = dnsValid; }

    public boolean isDkimValid() { return dkimValid; }
    public void setDkimValid(boolean dkimValid) { this.dkimValid = dkimValid; }

    public boolean isSpfValid() { return spfValid; }
    public void setSpfValid(boolean spfValid) { this.spfValid = spfValid; }

    public String getLastCheckedAt() { return lastCheckedAt; }
    public void setLastCheckedAt(String lastCheckedAt) { this.lastCheckedAt = lastCheckedAt; }

    public List<String> getIssues() { return issues; }
    public void setIssues(List<String> issues) { this.issues = issues; }
}
