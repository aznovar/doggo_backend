package com.doggo.app.model.exception;

import javax.naming.AuthenticationException;

public class BadPasswordException extends AuthenticationException {

    public BadPasswordException(final String msg) {
        super(msg);
    }
}
