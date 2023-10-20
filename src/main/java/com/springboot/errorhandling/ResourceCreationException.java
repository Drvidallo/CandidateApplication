package com.springboot.errorhandling;

public class ResourceCreationException extends RuntimeException {

    private final String code;
    private final String details;

    public ResourceCreationException(String message, String code, String details) {
        super(message);
        this.code = code;
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public String getDetails() {
        return details;
    }
}