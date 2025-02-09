package com.git.hitzaki.education.bus.auth;

import cn.dev33.satoken.stp.StpUtil;
import com.git.hitzaki.education.common.service.IAuthBizService;
import com.git.hitzaki.education.model.auth.param.LoginParam;
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
}
