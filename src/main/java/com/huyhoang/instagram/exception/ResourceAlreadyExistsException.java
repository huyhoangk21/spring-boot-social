package com.huyhoang.instagram.exception;

import java.util.HashMap;
import java.util.Map;

public class ResourceAlreadyExistsException extends RuntimeException{

    private Map<String, String> errors;

    public ResourceAlreadyExistsException() {
        errors = new HashMap<>();
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public void addError(String resource) {
        this.errors.put(resource, String.format("%s already exists",
                resource.substring(0, 1).toUpperCase() + resource.substring(1)));
    }
}
