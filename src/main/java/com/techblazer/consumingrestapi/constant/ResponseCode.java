package com.techblazer.consumingrestapi.constant;

public enum ResponseCode {
    SUCCESS("A200", "Request Successful"),
    FAILED("F100", "Request Successful"),
    RESOURCE_NOT_FOUND("A419", "Resource not found");


    private String code;
    private String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
