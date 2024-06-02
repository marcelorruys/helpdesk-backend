package com.marcelo.helpdesk.services.exceptions;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
