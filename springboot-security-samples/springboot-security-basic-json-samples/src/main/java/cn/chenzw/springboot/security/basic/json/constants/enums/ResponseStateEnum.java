package cn.chenzw.springboot.security.basic.json.constants.enums;

public enum ResponseStateEnum {

    SUCCESS(200, "成功"),
    FAILURE(500, "失败"),
    USER_UNAUTHORIZED(401, "用户未登录"),
    ACCESS_DENIED(403, "用户无权访问");

    /*SUCCESS(101, "成功"),
    FAILURE(102, "失败"),
    USER_NEED_AUTHORITIES(201, "用户未登录"),
    USER_LOGIN_FAILED(202, "用户账号或密码错误"),
    USER_LOGIN_SUCCESS(203, "用户登录成功"),
    USER_NO_ACCESS(204, "用户无权访问"),
    USER_LOGOUT_SUCCESS(205, "用户登出成功"),
    TOKEN_IS_BLACKLIST(206, "此token为黑名单"),
    LOGIN_IS_OVERDUE(207, "登录已失效");*/


    private Integer code;
    private String message;

    ResponseStateEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
