package com.git.hitzaki.education.model.auth.param;

import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.model.PageParams;
import com.git.hitzaki.education.common.utils.validation.FormatValidationUtil;
import lombok.Data;

/**
 * 角色查询param
 * @author hitzaki
 */
@Data
public class RoleQueryParam extends PageParams {
    private String name;

    private String code;

    private Long userId;

    public void checkUserRolePage() {
        if (! FormatValidationUtil.isId(userId)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }
}
