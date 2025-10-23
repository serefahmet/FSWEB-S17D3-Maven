package com.workintech.zoo.exceptions;

import org.springframework.http.HttpStatus;

public class ZooException extends RuntimeException {
    private HttpStatus status;

    public ZooException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public HttpStatus getHttpStatus() {
        return status;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.status = httpStatus;
    }
}
