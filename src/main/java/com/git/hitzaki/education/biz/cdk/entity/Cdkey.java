package com.git.hitzaki.education.biz.cdk.entity;

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
 * 优惠券信息
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cdkey")
public class Cdkey implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 兑换码
     */
    private String code;

    /**
     * 可兑换的余额大小
     */
    private BigDecimal amount;

    /**
     * 创建人
     */
    private Long adminId;

    /**
     * 发行状态 0未上线 1已上线 2已使用 3已过期
     */
    private Integer status;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;

    private Integer deleteFlag;


}
