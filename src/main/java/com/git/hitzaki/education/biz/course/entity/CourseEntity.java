package com.git.hitzaki.education.biz.course.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("course")
public class CourseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 课程讲师ID
     */
    private Long teacherId;

    /**
     * 课程专业ID
     */
    private Long subjectId;

    /**
     * 课程专业父级ID
     */
    private Long subjectParentId;

    /**
     * 课程标题
     */
    private String title;

    /**
     * 课程销售价格，设置为0则可免费观看
     */
    private BigDecimal price;

    /**
     * 总课时
     */
    private Integer lessonNum;

    /**
     * 视频总时长（秒）
     */
    private Integer durationSum;

    /**
     * 课程封面图片路径
     */
    private String cover;

    /**
     * 销售数量
     */
    private Long buyCount;

    /**
     * 浏览数量
     */
    private Long viewCount;

    /**
     * 课程状态 0未发布 1已发布
     */
    private Integer status;

    /**
     * 课程发布时间
     */
    private LocalDateTime publishTime;

    /**
     * 课程简介
     */
    private String description;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;

    private Integer deleteFlag;

    /**
     * 课程重点
     */
    private String focus;

    /**
     * 课程须知
     */
    private String notes;

    /**
     * 可以学到什么
     */
    private String canLearn;


}
