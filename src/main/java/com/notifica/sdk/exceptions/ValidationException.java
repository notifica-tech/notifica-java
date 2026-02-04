package com.notifica.sdk.exceptions;

import java.util.List;
import java.util.Map;

/**
 * Validation error (HTTP 422).
 */
public class ValidationException extends ApiException {

    public ValidationException(String message, Map<String, List<String>> details, String requestId) {
        super(message, 422, "validation_failed", details, requestId);
    }
}
