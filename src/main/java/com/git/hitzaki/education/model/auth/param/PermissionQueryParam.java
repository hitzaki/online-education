package com.git.hitzaki.education.model.auth.param;

import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.model.PageParams;
import com.git.hitzaki.education.common.utils.validation.FormatValidationUtil;
import lombok.Data;

/**
 * 权限查询param
 * @author hitzaki
 */
@Data
public class PermissionQueryParam extends PageParams {

    private String name;

    private String code;

    private Long roleId;

    public void checkRolePermissionPage(){
        if (! FormatValidationUtil.isId(roleId)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }
}
