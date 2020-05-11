package com.doggo.app.model.exception;

import org.springframework.security.core.AuthenticationException;

public class BadPasswordException extends AuthenticationException {

    public BadPasswordException(final String msg) {
        super(msg);
    }
}
