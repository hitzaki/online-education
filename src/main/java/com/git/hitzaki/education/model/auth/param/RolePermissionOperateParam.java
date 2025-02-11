package com.git.hitzaki.education.model.auth.param;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.utils.validation.FormatValidationUtil;
import lombok.Data;

/**
 * 角色权限操作param
 * @author hitzaki
 */
@Data
public class RolePermissionOperateParam {
    private Long rolePermissionId;

    private Long roleId;

    private Long permissionId;

    public void checkInsert(){
        if (!FormatValidationUtil.isId(roleId) || !FormatValidationUtil.isId(permissionId)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }

    public void checkDelete(){
        if (! FormatValidationUtil.isId(rolePermissionId)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }
}
