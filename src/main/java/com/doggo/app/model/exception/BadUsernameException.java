package com.doggo.app.model.exception;

import javax.naming.AuthenticationException;

public class BadUsernameException extends AuthenticationException {

    public BadUsernameException(final String msg) {
        super(msg);
    }
}
