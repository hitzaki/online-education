package com.git.hitzaki.education.api.admin;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.git.hitzaki.education.common.model.BizResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 授权登录 权限控制
 * @author hitzaki
 */
@RestController("/admin/auth")
public class AdminAuthApi {

    /**
     * 管理员账号密码登录
     */
    @RequestMapping("/login")
    public BizResult<SaTokenInfo> adminLogin() {

        return BizResult.success(StpUtil.getTokenInfo());
    }

    // TODO 管理员拓展信息获取

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public BizResult logout() {
        StpUtil.logout();
        return BizResult.success();
    }

}
