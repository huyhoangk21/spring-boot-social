package com.huyhoang.instagram.exception;

import java.util.Map;

public class ResourceAlreadyExistsException extends RuntimeException{

    private Map<String, String> errors;

    public ResourceAlreadyExistsException(Map<String, String> errors) {
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
