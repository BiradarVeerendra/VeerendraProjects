package com.veerendra.biradar.exception;

import java.util.ArrayList;

public final class VeerAppException extends Exception {

    private int statusCode;
    private String statusMessage;
    private Object result;

    public VeerAppException() {
    }

    public VeerAppException(int statusCode, String statusMessage, Object result) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.result = result;
    }

    public static VeerAppException invalidRequestError(String statusMessage, Object result) {
        return new VeerAppException(400, statusMessage, result);
    }

    public static VeerAppException internalServerError(String statusMessage, Object result) {
        return new VeerAppException(500, statusMessage, result);
    }

    public static VeerAppException standardError(){
        return new VeerAppException(500, "Something went wrong.", new ArrayList<>());
    }

    public static VeerAppException catchVeerAppError(VeerAppException e){
        return new VeerAppException(e.getStatusCode(), e.getStatusMessage(), e.getResult());
    }

    public static VeerAppException dataInsertUpdateError(String message, Object object){
        return new VeerAppException(100, message, object);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
