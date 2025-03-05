package com.git.hitzaki.education.api;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.git.hitzaki.education.bus.auth.AuthCommonService;
import com.git.hitzaki.education.common.model.BizResult;
import com.git.hitzaki.education.model.auth.param.LoginParam;
import com.git.hitzaki.education.model.auth.param.UserOperateParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 授权登录 权限控制
 * @author hitzaki
 */
@RestController
@RequestMapping("/auth")
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

    @ApiOperation("业务员绑定")
    @PostMapping("/salesmanBind")
    public BizResult<Void> salesmanBind(@RequestBody LoginParam loginParam) {
        authCommonService.salesmanBind(loginParam);
        return BizResult.success();
    }

    // TODO 微信登陆
    // todo 登录校验是否封禁
    @ApiOperation("用户微信登录")
    @PostMapping("/wxLogin")
    public BizResult<Map<String, Object>> wxLogin(@RequestBody LoginParam loginParam) {
        return BizResult.success(authCommonService.wxLogin(loginParam));
    }

    @ApiOperation("用户拓展信息获取")
    @PostMapping("/userExtendInfo")
    @SaCheckRole("user")
    public BizResult<Map<String, Object>> userExtendInfo() {
        return BizResult.success(authCommonService.userExtendInfo());
    }

    @ApiOperation("用户修改资料")
    @PostMapping("/updateUserInfo")
    @SaCheckRole("user")
    public BizResult<Void> updateUserInfo(@RequestBody UserOperateParam operateParam) {
        authCommonService.updateUserInfo(operateParam);
        return BizResult.success();
    }

    // TODO 用户改变头像

    @ApiOperation("用户退出登录")
    @PostMapping("/userLogout")
    @SaCheckRole("user")
    public BizResult<Void> userLogout() {
        authCommonService.userLogout();
        return BizResult.success();
    }

}
