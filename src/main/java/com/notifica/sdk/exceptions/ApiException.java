package com.notifica.sdk.exceptions;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Exception thrown when the API returns an error response.
 * Contains HTTP status code, error code, and request ID for debugging.
 */
public class ApiException extends NotificaException {

    private final int status;
    private final String code;
    private final Map<String, List<String>> details;
    private final String requestId;

    public ApiException(String message, int status, String code,
                        Map<String, List<String>> details, String requestId) {
        super(message);
        this.status = status;
        this.code = code;
        this.details = details != null ? details : Collections.emptyMap();
        this.requestId = requestId;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public Map<String, List<String>> getDetails() {
        return details;
    }

    public String getRequestId() {
        return requestId;
    }

    @Override
    public String toString() {
        return String.format("ApiException{status=%d, code='%s', message='%s', requestId='%s'}",
                status, code, getMessage(), requestId);
    }
}
