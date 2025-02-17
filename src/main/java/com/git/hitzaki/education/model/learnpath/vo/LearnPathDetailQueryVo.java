package com.git.hitzaki.education.model.learnpath.vo;

import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class LearnPathDetailQueryVo {
    private Long id;

    private Long pathId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 标题
     */
    private String title;

    /**
     * 简介
     */
    private String description;

    /**
     * 学习目标
     */
    private String target;

    private List<CourseQueryVo> courseList;
}
