package com.git.hitzaki.education.model.auth.param;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import lombok.Data;

/**
 * 用户操作param
 * @author hitzaki
 */
@Data
public class UserRoleOperateParam {
    private String avatar;

    private String nickName;

    public void updateInfoCheck(){
        if (StringUtils.isBlank(avatar) && StringUtils.isBlank(nickName)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }
}
