package com.doggo.app.model.exception;

import org.springframework.security.core.AuthenticationException;

public class BadUsernameException extends AuthenticationException {

    public BadUsernameException(final String msg) {
        super(msg);
    }
}
