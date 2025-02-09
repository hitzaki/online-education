package com.git.hitzaki.education.model.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 是
 * @author hitzaki
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {

    ADMIN(0,"管理员"),
    SALESMAN(1,"业务员"),
    USER(2,"用户"),
    ;
    private final Integer code;
    private final String description;

    public static final List<Integer> ADMIN_TYPE = Arrays.asList(ADMIN.code, SALESMAN.code);

}
