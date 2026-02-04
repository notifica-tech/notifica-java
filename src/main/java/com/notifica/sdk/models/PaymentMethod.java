package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethod {

    private String id;
    private String type;

    @JsonProperty("is_default")
    private boolean isDefault;

    private Map<String, Object> card;

    @JsonProperty("pix_key")
    private String pixKey;

    @JsonProperty("pix_key_type")
    private String pixKeyType;

    private String nickname;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public PaymentMethod() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public boolean isDefault() { return isDefault; }
    public void setDefault(boolean isDefault) { this.isDefault = isDefault; }

    public Map<String, Object> getCard() { return card; }
    public void setCard(Map<String, Object> card) { this.card = card; }

    public String getPixKey() { return pixKey; }
    public void setPixKey(String pixKey) { this.pixKey = pixKey; }

    public String getPixKeyType() { return pixKeyType; }
    public void setPixKeyType(String pixKeyType) { this.pixKeyType = pixKeyType; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
