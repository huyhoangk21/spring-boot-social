package com.huyhoang.instagram.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;


public class ApiResponse<T> implements Serializable {

    private HttpStatus status;

    private String message;

    private List<T> data;

    public ApiResponse(HttpStatus status, String message, List<T> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
