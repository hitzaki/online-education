package com.git.hitzaki.education.model.teacher.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TeacherQueryVo {
    private Long id;

    /**
     * 讲师姓名
     */
    private String name;

    /**
     * 讲师简介
     */
    private String intro;

    /**
     * 讲师资历, 一句话说明讲师
     */
    private String career;

    /**
     * 头衔 1高级讲师 2首席讲师
     */
    private Integer level;

    /**
     * 讲师头像
     */
    private String avatar;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 入驻时间
     */
    private LocalDate joinDate;
}
