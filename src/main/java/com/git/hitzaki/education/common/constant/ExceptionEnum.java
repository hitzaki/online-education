package com.git.hitzaki.education.common.constant;

import lombok.AllArgsConstructor;

/**
 * 统错误码
 *
 * */
@AllArgsConstructor
public enum ExceptionEnum {

    COMMON_EXCEPTION(10000,"系统未知异常"),
    ;
    private final Integer code;
    private final String description;

    public String getDescription() {
        return description;
    }

    public Integer getCode() {
        return code;
    }

}
