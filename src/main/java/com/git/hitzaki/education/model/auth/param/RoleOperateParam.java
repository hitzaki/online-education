package com.git.hitzaki.education.model.auth.param;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.utils.validation.FormatValidationUtil;
import lombok.Data;

/**
 * 角色操作param
 * @author hitzaki
 */
@Data
public class RoleOperateParam {
    private Long roleId;

    /**
     * 名称
     */
    private String name;

    /**
     * code
     */
    private String code;

    public void checkInsert(){
        if (StringUtils.isBlank(name) || StringUtils.isBlank(code)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }

    public void checkDelete(){
        if (! FormatValidationUtil.isId(roleId)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }
}
