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
    ;
    private final Integer code;
    private final String description;

}
