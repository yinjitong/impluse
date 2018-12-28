package com.msp.impulse.base;

public enum ResponseCode {
    OK(200, "成功"),
    SERVER_FAILED(500, "失败"),
    PARAMETER_VALIDATION_FAILED(2001, "参数不合法"),
    PARAMETER_ISNULL(2002, "参数为空"),
    USERNAME_OR_PWD_WRONG(3001,"用户名或者密码错误"),
    OPWD_WRONG(3002,"原密码输入不正确!"),
    NOT_LOGIN(3003,"未登录，请先登录"),
    USERNAME_NULL(3004,"请输入用户名"),
    PASSWORD_NULL(3005,"请输入密码"),
    ;



    private int code;
    private String message;
    private ResponseCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
