package com.git.hitzaki.education.model.auth.param;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.utils.AuthInfoUtils;
import com.git.hitzaki.education.common.utils.validation.FormatValidationUtil;
import lombok.Data;

import java.util.Objects;

/**
 * 管理员操作param
 * @author hitzaki
 */
@Data
public class AdminOperateParam {
    private Long adminId;

    /**
     * 类型 0 管理员 1 业务员
     */
    private Integer type;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 二次输入密码
     */
    private String comparePassword;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    public void checkInsert(){
        if (Objects.isNull(type) || StringUtils.isBlank(account)
                || StringUtils.isBlank(password) || StringUtils.isBlank(comparePassword)
                || StringUtils.isBlank(nickName) || StringUtils.isBlank(avatar)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
        if (!password.equals(comparePassword)){
            CommonBizException.throwError("两次密码输入不一致, 请检查");
        }
    }

    public void checkBan(){
        if (! FormatValidationUtil.isId(adminId)){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
        if (AuthInfoUtils.getLoginId().equals(adminId)){
            CommonBizException.throwError("不能停用自己的账号");
        }
    }
}
