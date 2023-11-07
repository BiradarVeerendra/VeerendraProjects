package com.veerendra.biradar.api_req_res.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ResponseDTO {

    private int code;
    private String message;
    private Object result;

    public ResponseDTO() {
    }

    public ResponseDTO(int code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
