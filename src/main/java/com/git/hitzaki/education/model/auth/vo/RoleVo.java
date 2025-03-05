package com.git.hitzaki.education.model.auth.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色Vo
 * @author hitzaki
 */
@Data
public class RoleVo implements Serializable {

    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 备注
     */
    private String remark;

    private Integer deleteFlag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean isBind;

}
