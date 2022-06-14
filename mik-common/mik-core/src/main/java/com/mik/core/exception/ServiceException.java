package com.mik.core.exception;

public class ServiceException extends RuntimeException{

    /**
     * 业务错误码
     */
    private String code;
    /**
     * 错误提示
     */
    private String msg;
    /**
     * 错误明细，内部调试错误
     */
    private String detailMessage;
    /**
     * 空构造方法，避免反序列化问题
     */
    public ServiceException() {
    }

    public ServiceException(String message) {
        this.code = "1";
        this.msg = message;
    }

    public ServiceException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }

    public ServiceException(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public ServiceException setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ServiceException setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return msg;
    }

    public ServiceException setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
