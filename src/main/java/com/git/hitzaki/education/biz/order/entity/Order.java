package com.git.hitzaki.education.biz.order.entity;

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
 * 订单表 订单表
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 原始金额
     */
    private BigDecimal originAmount;

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    /**
     * 最终金额
     */
    private BigDecimal finalAmount;

    /**
     * 订单状态 (0待支付 1已完成 2已失效)
     */
    private Integer orderStatus;

    /**
     * 订单类型 0 课程 1 学习路线
     */
    private Integer orderType;

    /**
     * 订单交易编号（第三方支付用)
     */
    private String outTradeNo;

    /**
     * 订单描述(第三方支付用)
     */
    private String outTradeBody;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 失效时间
     */
    private LocalDateTime expireTime;

    private Integer deleteFlag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
