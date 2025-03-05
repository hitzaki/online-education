package com.git.hitzaki.education.biz.learnpath.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Ezreal
 * @since 2025-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("path_user_mapping")
public class PathUserMappingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户
     */
    private Long userId;

    /**
     * 学习路线
     */
    private Long pathId;

    /**
     * 学习路线明细
     */
    private Long pathDetailId;

    /**
     * 课程
     */
    private Long courseId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标记
     */
    private Integer deleteFlag;

    private Integer detailSort;
    private Integer courseSort;


}
