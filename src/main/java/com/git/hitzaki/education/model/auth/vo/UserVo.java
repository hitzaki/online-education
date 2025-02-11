package com.git.hitzaki.education.model.auth.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 角色Vo
 * @author hitzaki
 */
@Data
public class UserVo implements Serializable {

    private Long id;

    /**
     * 手机
     */
    private String phone;

    /**
     * 微信登陆code
     */
    private String wechatCode;

    /**
     * 状态 0正常 1停用 2注销 3黑名单  ..................
     */
    private Integer status;


    /**
     * 用户id
     */
    private Long accountId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 会员等级0 普通用户
     */
    private Integer vipType;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 积分
     */
    private BigDecimal points;


}
