package com.git.hitzaki.education.model.course.vo;

import com.git.hitzaki.education.model.tag.vo.TagQueryVo;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CourseQueryVo {
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

    private List<TagQueryVo> tagList;
    //进度
    private BigDecimal schedule;
    //最近xuexi
    private boolean visitedRecently;
}
