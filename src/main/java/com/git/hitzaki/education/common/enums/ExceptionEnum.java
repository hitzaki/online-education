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
    AUTH_ERROR(50100,"认证信息异常"),
    ADMIN_LOGIN_ERROR(50101,"账号密码错误"),
    PHONE_FORMAT(50102,"手机号格式不正确"),
    VERIFY_CODE_ERROR(50103,"验证码错误"),
    WX_BIND(50111,"微信号未绑定, 请绑定手机号"),
    WX_BIND_ERROR(50112,"请勿重复绑定微信号"),
    ;
    private final Integer code;
    private final String description;

}
