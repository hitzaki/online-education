package com.git.hitzaki.education.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 统错误码
 *
 * */
@Getter
@AllArgsConstructor
public enum ExceptionEnum {

    COMMON_EXCEPTION(50000,"系统未知异常"),

    /**
     * 认证授权相关 50100 - 50199
     */
    ADMIN_LOGIN_ERROR(50100,"账号密码错误"),
    ;
    private final Integer code;
    private final String description;

}
