package com.git.hitzaki.education.biz.point.entity;

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
 * 积分记录表
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("points_history")
public class PointsHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 0增加 1减少
     */
    private Integer type;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 积分数量
     */
    private BigDecimal pointsCount;

    /**
     * 对应操作码--后端枚举维护
     */
    private String operationCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private Integer deleteFlag;


}
