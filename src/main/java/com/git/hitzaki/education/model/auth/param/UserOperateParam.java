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
public class UserOperateParam {
    private Long userId;

    private String avatar;

    private String nickName;

    public void checkUpdateInfo(){
        if (StringUtils.isBlank(avatar) && StringUtils.isBlank(nickName)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }

    public void checkBan(){
        if (! FormatValidationUtil.isId(userId)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
    }
}
