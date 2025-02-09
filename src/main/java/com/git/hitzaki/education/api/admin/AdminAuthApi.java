package com.git.hitzaki.education.api.admin;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.git.hitzaki.education.common.model.BizResult;
import com.git.hitzaki.education.common.service.IAuthBizService;
import com.git.hitzaki.education.model.auth.param.LoginParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 授权登录 权限控制
 * @author hitzaki
 */
@Api("管理员-认证授权接口")
@RestController("/admin/auth")
public class AdminAuthApi {

    @Autowired
    private IAuthBizService authBizService;

    /**
     * 管理员账号密码登录
     */
    @ApiOperation("管理员登录 返回token")
    @PostMapping("/adminLogin")
    public BizResult<String> adminLogin(@RequestBody LoginParam loginParam) {
        return BizResult.success(authBizService.adminLogin(loginParam));
    }

    // TODO 管理员拓展信息获取

    /**
     * 退出登录
     */
    @RequestMapping("/adminLogout")
    public BizResult logout() {
        StpUtil.logout();
        return BizResult.success();
    }

}
