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
 * <p>
 * 角色权限
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Data
public class RolePermissionVo implements Serializable {

    private Long id;

    private Long roleId;

    private Long permissionId;

    private Integer deleteFlag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
