package com.git.hitzaki.education.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 是
 * @author hitzaki
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {

    ADMIN(0, "admin","管理员"),
    SALESMAN(1, "salesman","业务员"),
    USER(2, "user","用户"),
    ;
    private final Integer code;
    private final String type;
    private final String description;

    public static final List<String> ADMIN_TYPE = Arrays.asList(ADMIN.type, SALESMAN.type);

    public static String getLoginType(Integer code){
        for (LoginTypeEnum typeEnum : LoginTypeEnum.values()) {
            if (typeEnum.code.equals(code)){
                return typeEnum.type;
            }
        }
        return "";
    }
}
