package com.git.hitzaki.education.bus.auth;

import cn.dev33.satoken.stp.StpUtil;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.service.IAuthBizService;
import com.git.hitzaki.education.common.utils.validation.FormatValidationUtil;
import com.git.hitzaki.education.model.auth.param.LoginParam;
import com.git.hitzaki.education.model.auth.param.UserOperateParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 认证授权
 * @author hitzaki
 */
@Slf4j
@Service
public class AuthCommonService {
    @Autowired
    private IAuthBizService authBizService;

    /**
     * 管理员登录
     */
    public Map<String, Object> adminLogin(LoginParam loginParam) {
        loginParam.checkAdminLogin();
        return authBizService.adminLogin(loginParam);
    }

    /**
     * 管理员获取拓展信息
     */
    public Map<String, Object> adminExtendInfo() {
        return authBizService.adminExtendInfo();
    }

    /**
     * 管理员退出登录
     */
    public void adminLogout() {
        StpUtil.logout();
    }

    public void sendPhoneMsg(String phone) {
        if (!FormatValidationUtil.isPhoneCode(phone)){
            CommonBizException.throwError(ExceptionEnum.PHONE_FORMAT);
        }
        // TODO 同一个ip地址60s限流
        // TODO 发送短信验证码
    }

    public Map<String, Object> phoneLogin(LoginParam loginParam) {
        loginParam.checkPhoneLogin();
        // TODO 校验验证码是否正确
        if (!"666666".equals(loginParam.getVerifyCode())){
            CommonBizException.throwError(ExceptionEnum.VERIFY_CODE_ERROR);
        }
        return authBizService.phoneLogin(loginParam);
    }

    public Map<String, Object> wxLogin(LoginParam loginParam) {
        loginParam.checkWxLogin();
        return authBizService.wxLogin(loginParam);
    }

    public void userLogout() {
        StpUtil.logout();
    }

    public Map<String, Object> userExtendInfo() {
        return authBizService.userExtendInfo();
    }

    public void updateUserInfo(UserOperateParam operateParam) {
        operateParam.checkUpdateInfo();
        authBizService.updateUserInfo(operateParam);
    }

    public void salesmanBind(LoginParam loginParam) {
        loginParam.checkSalesmanBind();
        authBizService.salesmanBind(loginParam.getSalesmanCode());
    }
}
