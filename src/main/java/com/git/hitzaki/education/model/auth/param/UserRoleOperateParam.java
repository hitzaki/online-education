package com.git.hitzaki.education.model.auth.param;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.utils.validation.FormatValidationUtil;
import lombok.Data;

/**
 * 用户操作param
 * @author hitzaki
 */
@Data
public class UserRoleOperateParam {
    private Long userRoleId;

    private Long userId;

    private Long roleId;

    public void checkInsert(){
        if (!FormatValidationUtil.isId(userId) || !FormatValidationUtil.isId(roleId)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }

    public void checkDelete(){
        if (! FormatValidationUtil.isId(userRoleId)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }
}
