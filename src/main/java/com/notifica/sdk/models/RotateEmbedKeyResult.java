package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RotateEmbedKeyResult {

    @JsonProperty("embed_key")
    private String embedKey;

    @JsonProperty("old_key_expires_at")
    private String oldKeyExpiresAt;

    public RotateEmbedKeyResult() {}

    public String getEmbedKey() { return embedKey; }
    public void setEmbedKey(String embedKey) { this.embedKey = embedKey; }

    public String getOldKeyExpiresAt() { return oldKeyExpiresAt; }
    public void setOldKeyExpiresAt(String oldKeyExpiresAt) { this.oldKeyExpiresAt = oldKeyExpiresAt; }
}
