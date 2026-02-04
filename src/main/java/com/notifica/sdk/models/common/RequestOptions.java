package com.notifica.sdk.models.common;

import java.time.Duration;

/**
 * Per-request options that override client defaults.
 */
public class RequestOptions {

    private String idempotencyKey;
    private Duration timeout;

    public RequestOptions() {}

    public static RequestOptions withIdempotencyKey(String key) {
        RequestOptions opts = new RequestOptions();
        opts.idempotencyKey = key;
        return opts;
    }

    public static RequestOptions withTimeout(Duration timeout) {
        RequestOptions opts = new RequestOptions();
        opts.timeout = timeout;
        return opts;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public RequestOptions setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
        return this;
    }

    public Duration getTimeout() {
        return timeout;
    }

    public RequestOptions setTimeout(Duration timeout) {
        this.timeout = timeout;
        return this;
    }
}
