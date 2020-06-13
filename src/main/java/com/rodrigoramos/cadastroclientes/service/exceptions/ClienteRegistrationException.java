package com.rodrigoramos.cadastroclientes.service.exceptions;

public class ClienteRegistrationException extends RuntimeException {

    public ClienteRegistrationException(String message) {
        super(message);
    }

    public ClienteRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
