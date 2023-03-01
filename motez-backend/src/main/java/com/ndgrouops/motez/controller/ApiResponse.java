package com.ndgrouops.motez.controller;

import java.time.LocalDateTime;

public class ApiResponse {
    private final Boolean success;
    private final String message;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String geTimeStamp() {
        return LocalDateTime.now().toString();
    }
}
