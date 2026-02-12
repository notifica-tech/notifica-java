package com.notifica.sdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Actor who performed an audited action.
 */
public class AuditActor {

    private String type;
    private String id;
    private String name;
    @JsonProperty("ip_address")
    private String ipAddress;
    @JsonProperty("user_agent")
    private String userAgent;

    public AuditActor() {}

    /**
     * Actor type (user, api_key, system).
     */
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    /**
     * Actor ID (user ID, API key ID, or null for system).
     */
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    /**
     * Actor display name or email.
     */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    /**
     * IP address of the actor (when available).
     */
    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    /**
     * User agent (when available).
     */
    public String getUserAgent() { return userAgent; }
    public void setUserAgent(String userAgent) { this.userAgent = userAgent; }

    @Override
    public String toString() {
        return "AuditActor{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
