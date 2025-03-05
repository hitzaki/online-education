package com.git.hitzaki.education.model.learnpath.vo;

import com.git.hitzaki.education.biz.learnpath.entity.LearnPathDetailEntity;
import com.git.hitzaki.education.biz.learnpath.entity.PathDetailMappingEntity;
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

    public static LearnPathDetailQueryVo buildVoByEntity(LearnPathDetailEntity entity){
        LearnPathDetailQueryVo vo =new LearnPathDetailQueryVo();
        vo.setId(entity.getId());
        vo.setPathId(entity.getPathId());
        vo.setSort(entity.getSort());
        vo.setTitle(entity.getTitle());
        vo.setDescription(entity.getDescription());
        vo.setTarget(entity.getTarget());
        return vo;
    }
}
