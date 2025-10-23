package com.workintech.zoo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ZooErrorResponse {
    private String message;
    private int status;
    private long timestamp;

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public ZooErrorResponse() {}

    public ZooErrorResponse(int status,String message, long timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
