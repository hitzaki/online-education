package com.git.hitzaki.education.model.auth.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色Vo
 * @author hitzaki
 */
@Data
public class UserRoleVo implements Serializable {


    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;


}
