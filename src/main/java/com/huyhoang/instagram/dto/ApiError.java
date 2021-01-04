package com.huyhoang.instagram.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Map;

public class ApiError implements Serializable {

    private HttpStatus status;
    private Map<String, String> errors;

    public ApiError(HttpStatus status, Map<String, String> errors) {
        this.status = status;
        this.errors = errors;
    }


    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
