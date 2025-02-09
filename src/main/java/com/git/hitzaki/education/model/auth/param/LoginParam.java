package com.git.hitzaki.education.model.auth.param;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
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

    public void checkAdminLogin(){
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            throw new CommonBizException("账号密码不能为空");
        }
    }
}
