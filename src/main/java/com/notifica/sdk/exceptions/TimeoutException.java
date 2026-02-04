package com.notifica.sdk.exceptions;

/**
 * Request timed out.
 */
public class TimeoutException extends NotificaException {

    private final long timeoutMs;

    public TimeoutException(long timeoutMs) {
        super("Request timed out after " + timeoutMs + "ms");
        this.timeoutMs = timeoutMs;
    }

    public long getTimeoutMs() {
        return timeoutMs;
    }
}
