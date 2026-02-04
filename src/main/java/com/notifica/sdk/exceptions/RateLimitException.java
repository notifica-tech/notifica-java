package com.notifica.sdk.exceptions;

/**
 * Rate limit exceeded (HTTP 429).
 * Includes the time until the next retry is allowed.
 */
public class RateLimitException extends ApiException {

    private final Integer retryAfter;

    public RateLimitException(String message, Integer retryAfter, String requestId) {
        super(message, 429, "rate_limit_exceeded", null, requestId);
        this.retryAfter = retryAfter;
    }

    /**
     * Seconds until the next request is allowed, or null if unknown.
     */
    public Integer getRetryAfter() {
        return retryAfter;
    }
}
