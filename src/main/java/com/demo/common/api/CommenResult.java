package com.demo.common.api;

public class CommenResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommenResult() {}
    protected CommenResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommenResult<T> success(T data) {
        return new CommenResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> CommenResult<T> success(T data, String message) {
        return new CommenResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }
    public static <T> CommenResult<T> failed(IErrorCode errorCode) {
        return new CommenResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }
    public static <T> CommenResult<T> failed(String message) {
        return new CommenResult<T>(ResultCode.FAILED.getCode(), message, null);
    }
    public static <T> CommenResult<T> failed() {
        return failed(ResultCode.FAILED);
    }
    public static <T> CommenResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }
    public static <T> CommenResult<T> unauthorized(T data) {
        return new CommenResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }
    public static <T> CommenResult<T> forbidden(T data) {
        return new CommenResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
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
