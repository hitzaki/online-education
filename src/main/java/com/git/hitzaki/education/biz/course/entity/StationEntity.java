package com.git.hitzaki.education.biz.course.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 岗位
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("station")
public class StationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 岗位名
     */
    private String title;

    private LocalDateTime updateTime;

    private Integer deleteFlag;

    private LocalDateTime createTime;

    /**
     * 省市区
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


}
