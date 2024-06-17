package com.marcelo.helpdesk.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.List;
import java.util.ArrayList;

public class ValidationError extends StandardError {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public void addError(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
