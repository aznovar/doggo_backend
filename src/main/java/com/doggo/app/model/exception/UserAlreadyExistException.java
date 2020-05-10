package com.doggo.app.model.exception;

import org.springframework.security.core.AuthenticationException;

public class UserAlreadyExistException extends AuthenticationException {

    public UserAlreadyExistException(final String msg, Throwable t) {
        super(msg, t);
    }

    public UserAlreadyExistException(final String msg) {
        super(msg);
    }

}
