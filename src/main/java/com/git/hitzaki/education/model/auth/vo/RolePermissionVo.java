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
 * 角色权限Vo
 * @author hitzaki
 */
@Data
public class RolePermissionVo implements Serializable {

    private Long id;

    /**
     * 所属上级
     */
    private Long parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 名称code
     */
    private String code;

    /**
     * 对应的页面唯一码, 可以没有
     */
    private String viewCode;

    /**
     * 类型(1:菜单,2:按钮)
     */
    private Integer type;

    /**
     * 状态(0:禁止,1:正常)
     */
    private Integer status;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;


}
