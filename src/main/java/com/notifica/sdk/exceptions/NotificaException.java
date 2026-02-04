package com.notifica.sdk.exceptions;

/**
 * Base exception for all Notifica SDK errors.
 */
public class NotificaException extends RuntimeException {

    public NotificaException(String message) {
        super(message);
    }

    public NotificaException(String message, Throwable cause) {
        super(message, cause);
    }
}
