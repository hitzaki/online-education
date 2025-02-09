package com.git.hitzaki.education.api;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.git.hitzaki.education.bus.auth.AuthCommonService;
import com.git.hitzaki.education.common.model.BizResult;
import com.git.hitzaki.education.model.auth.param.LoginParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 授权登录 权限控制
 * @author hitzaki
 */
@RestController("/auth")
public class AuthApi {

    @Autowired
    private AuthCommonService authCommonService;

    /**
     * 测试连接
     */
    @ApiOperation("测试后端连接")
    @PostMapping("/testConnect")
    public BizResult<Void> testConnect() {
        return BizResult.success();
    }

    @ApiOperation("发送短信验证码")
    @PostMapping("/sendPhoneMsg")
    public BizResult<Void> sendPhoneMsg(@RequestBody String phone) {
        authCommonService.sendPhoneMsg(phone);
        return BizResult.successByMsg("发送成功");
    }

    @ApiOperation("用户手机号登录")
    @PostMapping("/phoneLogin")
    public BizResult<Map<String, Object>> phoneLogin(@RequestBody LoginParam loginParam) {
        return BizResult.success(authCommonService.phoneLogin(loginParam));
    }

    // TODO 微信登陆
    @ApiOperation("用户微信登录")
    @PostMapping("/wxLogin")
    public BizResult<Map<String, Object>> wxLogin(@RequestBody LoginParam loginParam) {
        return BizResult.success(authCommonService.wxLogin(loginParam));
    }

    @ApiOperation("用户拓展信息获取")
    @PostMapping("/userExtendInfo")
    public BizResult<Map<String, Object>> userExtendInfo() {
        return BizResult.success(authCommonService.userExtendInfo());
    }

    @ApiOperation("用户退出登录")
    @PostMapping("/userLogout")
    public BizResult<Void> userLogout() {
        authCommonService.userLogout();
        return BizResult.success();
    }

}
