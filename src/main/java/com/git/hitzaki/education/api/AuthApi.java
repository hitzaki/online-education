package com.git.hitzaki.education.api;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.git.hitzaki.education.common.model.BizResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 授权登录 权限控制
 * @author hitzaki
 */
@RestController("/auth")
public class AuthApi {

    /**
     * 测试连接
     */
    @RequestMapping("/testConnect")
    public BizResult testConnect() {
        return BizResult.success();
    }

    /**
     * 短信验证码
     */
    @RequestMapping("/sendPhoneMsg")
    public BizResult sendPhoneMsg() {
        // TODO 同一个ip地址60s限流
        // TODO 发送短信验证码
        return BizResult.successByMsg("发送成功");
    }

    /**
     * 管理员账号密码登录
     */
    @RequestMapping("/adminLogin")
    public BizResult<SaTokenInfo> adminLogin() {
        // TODO 登录校验

        Long adminId = 1001l;
        // TODO 登录
        Map<String, Object> extraData = new HashMap<>();
//        StpUtil.login(adminId,
//                new SaLoginModel()
//                        .setDevice("app") // 设备标识（可选）
//                        .setExtraData(extraData) // 写入扩展数据
//        );
//        StpUtil.login(saBaseLoginUser.getId(), new SaLoginModel().setDevice().setExtra("name", saBaseLoginUser.getName()));

        return BizResult.success(StpUtil.getTokenInfo());
    }

    // TODO 管理员拓展信息获取


    // TODO 用户手机号登录

    // TODO 微信登陆

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public BizResult logout() {
        StpUtil.logout();
        return BizResult.success();
    }

}
