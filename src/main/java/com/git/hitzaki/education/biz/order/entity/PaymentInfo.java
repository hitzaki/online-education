package com.git.hitzaki.education.biz.order.entity;

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
 * 支付信息表
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("payment_info")
public class PaymentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Long userId;

    /**
     * 订单编号
     */
    private Long orderId;

    /**
     * 支付金额
     */
    private BigDecimal totalAmount;

    /**
     * 交易内容
     */
    private String tradeBody;

    /**
     * 对外业务编号
     */
    private String outTradeNo;

    /**
     * 支付宝交易编号
     */
    private String alipayTradeNo;

    /**
     * 支付类型
     */
    private Integer paymentType;

    /**
     * 支付状态
     */
    private Integer paymentStatus;

    /**
     * 回调时间
     */
    private LocalDateTime callbackTime;

    /**
     * 回调信息
     */
    private String callbackContent;

    private Integer deleteFlag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
