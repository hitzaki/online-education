package com.git.hitzaki.education.model.course.constant;

import lombok.AllArgsConstructor;

/**
 * 课程等级
 *
 * */
@AllArgsConstructor
public enum CourseLevel {
    PRIMER(0,"入门"),
    MIDDLE(1,"中级"),
    HIGH(1,"高级"),
            ;
    private final Integer k;
    private final String v;

    public String getV() {
        return v;
    }

    public Integer getK() {
        return k;
    }
}
