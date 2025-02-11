package com.git.hitzaki.education.model.auth.param;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
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

    /**
     * 名称
     */
    private String name;

    /**
     * 名称code
     */
    private String code;

    public void checkInsert(){
        if (StringUtils.isBlank(name) || StringUtils.isBlank(code)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }

    public void checkDelete(){
        if (! FormatValidationUtil.isId(permissionId)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }
}
