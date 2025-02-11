package com.git.hitzaki.education.model.auth.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色Vo
 * @author hitzaki
 */
@Data
public class AdminVo implements Serializable {

    private Long id;

    /**
     * 类型0管理员1 业务员
     */
    private Integer type;

    /**
     * 手机
     */
    private String phone;

    /**
     * 账号
     */
    private String account;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态 0正常 1停用 ..................
     */
    private Integer status;

    private Integer deleteFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
