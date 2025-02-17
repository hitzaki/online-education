package com.git.hitzaki.education.model.learnpath.vo;

import com.git.hitzaki.education.model.course.vo.CompanyQueryVo;
import com.git.hitzaki.education.model.tag.vo.TagQueryVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class LearnPathQueryVo {

    private Long id;

    /**
     * 路线名称
     */
    private String title;

    /**
     * 简介
     */
    private String description;

    /**
     * 删除
     */
    private Boolean deleteFlag;

    /**
     * 优惠规则
     */
    private Long rule;

    private List<LearnPathDetailQueryVo> detailList;

}
