package com.git.hitzaki.education.model.auth.param;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Objects;

/**
 * 登录param
 * @author hitzaki
 */
@Data
public class LoginParam {
    @ApiModelProperty("账号")
    private String account;
    @ApiModelProperty("密码 - 管理员登录使用")
    private String password;

    @ApiModelProperty("手机号 - 用户手机号登录使用")
    private String phone;
    @ApiModelProperty("验证码 - 用户手机号登录使用")
    private String verifyCode;

    @ApiModelProperty("微信code")
    private String wxCode;

    public void checkAdminLogin(){
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            throw new CommonBizException("账号密码不能为空");
        }
    }

    public void checkPhoneLogin(){
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(verifyCode)){
            throw new CommonBizException("手机号或验证码不能为空");
        }
    }

    public void checkWxLogin(){
        if (StringUtils.isBlank(wxCode)){
            CommonBizException.throwError(ExceptionEnum.COMMON_EXCEPTION);
        }
    }
}
