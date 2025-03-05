package com.git.hitzaki.education.model.course.constant;

import lombok.AllArgsConstructor;

/**
 * 课程状态
 *
 * */
@AllArgsConstructor
public enum CourseStatus {

    NO_PUBLISH(0,"未发布"),
    PUBLISH(2,"已发布"),
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
