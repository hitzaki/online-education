package com.git.hitzaki.education.model.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TODO
 * @author hitzaki
 */
@Getter
@AllArgsConstructor
public enum AdminStatusEnum {

    USE(0,"正常使用"),
    STOP(1,"停用"),
    ;
    private final Integer code;
    private final String description;

}
