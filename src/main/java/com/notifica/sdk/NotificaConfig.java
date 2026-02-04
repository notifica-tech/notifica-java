package com.notifica.sdk;

import java.time.Duration;

/**
 * Configuration for the Notifica SDK client.
 * Use the builder pattern: {@code NotificaConfig.builder().apiKey("nk_live_...").build()}
 */
public class NotificaConfig {

    public static final String DEFAULT_BASE_URL = "https://app.usenotifica.com.br/v1";
    public static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(30);
    public static final int DEFAULT_MAX_RETRIES = 3;

    private final String apiKey;
    private final String baseUrl;
    private final Duration timeout;
    private final int maxRetries;
    private final boolean autoIdempotency;

    private NotificaConfig(Builder builder) {
        this.apiKey = builder.apiKey;
        this.baseUrl = builder.baseUrl;
        this.timeout = builder.timeout;
        this.maxRetries = builder.maxRetries;
        this.autoIdempotency = builder.autoIdempotency;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public Duration getTimeout() {
        return timeout;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public boolean isAutoIdempotency() {
        return autoIdempotency;
    }

    public static class Builder {
        private String apiKey;
        private String baseUrl = DEFAULT_BASE_URL;
        private Duration timeout = DEFAULT_TIMEOUT;
        private int maxRetries = DEFAULT_MAX_RETRIES;
        private boolean autoIdempotency = true;

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder timeout(Duration timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder maxRetries(int maxRetries) {
            this.maxRetries = maxRetries;
            return this;
        }

        public Builder autoIdempotency(boolean autoIdempotency) {
            this.autoIdempotency = autoIdempotency;
            return this;
        }

        public NotificaConfig build() {
            if (apiKey == null || apiKey.isEmpty()) {
                throw new IllegalArgumentException(
                    "API key is required. Pass via: NotificaConfig.builder().apiKey(\"nk_live_...\").build()");
            }
            // Normalize base URL: strip trailing slashes
            if (baseUrl != null) {
                this.baseUrl = baseUrl.replaceAll("/+$", "");
            }
            return new NotificaConfig(this);
        }
    }
}
