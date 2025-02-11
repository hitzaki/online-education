package com.git.hitzaki.education.model.auth.param;

import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.utils.validation.FormatValidationUtil;
import lombok.Data;

/**
 * 权限操作param
 * @author hitzaki
 */
@Data
public class PermissionOperateParam {
    private Long permissionId;

    public void checkInsert(){

    }

    public void checkDelete(){
        if (! FormatValidationUtil.isId(permissionId)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }
}
