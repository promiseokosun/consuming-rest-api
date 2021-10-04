package com.techblazer.consumingrestapi.dto;

import com.techblazer.consumingrestapi.constant.ResponseCode;

public class BaseResponse <T> {

    private String code;
    private String message;
    private T data;

    public BaseResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResponse successResponse(Object data) {
        return new BaseResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    public static BaseResponse failedResponse(Object data) {
        return new BaseResponse(ResponseCode.FAILED.getCode(), ResponseCode.FAILED.getMessage(), data);
    }

    public static BaseResponse response(String code, String message, Object data) {
        return new BaseResponse(code, message, data);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
