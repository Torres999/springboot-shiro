package com.torres999.sprintboot.shiro.framework;

/**
 * Created by t9 on 2018/9/14.
 */
public enum ExceptionCode {
    BACK_SERVER_ERROR_5000("5000", "服务端异常"),
    BACK_APPLY_ERROR_5001("5001", "没有访问权限"),
    BACK_APPLY_ERROR_5002("5002", "没有登陆");

    private String code;
    private String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
