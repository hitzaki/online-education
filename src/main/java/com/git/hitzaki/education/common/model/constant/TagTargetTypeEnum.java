package com.git.hitzaki.education.common.model.constant;

import lombok.AllArgsConstructor;

/**
 * tag目标类型
 *
 * */
@AllArgsConstructor
public enum TagTargetTypeEnum {
    STATION(1,"岗位"),
    COURSE(2,"课程"),
    ;
    private final Integer k;
    private final String description;

    public String getDescription() {
        return description;
    }

    public Integer getK() {
        return k;
    }
}
