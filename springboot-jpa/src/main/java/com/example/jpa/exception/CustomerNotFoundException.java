package com.example.jpa.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CustomerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}