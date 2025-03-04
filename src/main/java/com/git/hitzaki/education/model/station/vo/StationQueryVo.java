package com.git.hitzaki.education.model.station.vo;

import com.git.hitzaki.education.model.course.vo.CompanyQueryVo;
import com.git.hitzaki.education.model.tag.vo.TagQueryVo;
import lombok.Data;

import java.math.BigDecimal;

import java.util.List;

@Data
public class StationQueryVo {

    private Long id;

    /**
     * 岗位名
     */
    private String title;

    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;


    /**
     * 区
     */
    private String region;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 最小工资
     */
    private BigDecimal minSalary;

    /**
     * 最大工资
     */
    private BigDecimal maxSalary;

    /**
     * 最小工作经验
     */
    private Integer minYearLimit;

    /**
     * 最大工作经验
     */
    private Integer maxYearLimit;

    /**
     * 薪资结构
     */
    private Integer salaryStructure;

    /**
     * 所属公司
     */
    private Long companyId;

    /**
     * 所属公司信息
     */
    private CompanyQueryVo companyQueryInfo;


    /**
     * 职位描述
     */
    private String description;

    /**
     * 任职要求
     */
    private String require;

    /**
     * 地址图片
     */
    private String addressImage;

    /**
     * 标签
     */
    private List<TagQueryVo> tagList;

    /**
     * 学习路线
     */
    private Long pathId;
}
