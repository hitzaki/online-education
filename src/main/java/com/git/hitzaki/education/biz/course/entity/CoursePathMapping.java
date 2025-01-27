package com.git.hitzaki.education.biz.course.entity;

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
 * 
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("course_path_mapping")
public class CoursePathMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 课程
     */
    private Long courseId;

    /**
     * 学习路线
     */
    private Long pathId;

    /**
     * 排序
     */
    private Integer sort;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
