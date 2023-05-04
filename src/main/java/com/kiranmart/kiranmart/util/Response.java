package com.kiranmart.kiranmart.util;

import lombok.Data;

@Data
public class Response {

    private boolean success;
    private String message;
    private  Object body;

    public Response(boolean success, String message, Object body) {
        this.success = success;
        this.message = message;
        this.body = body;
    }
}
