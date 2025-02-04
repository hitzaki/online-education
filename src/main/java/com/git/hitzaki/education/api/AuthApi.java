package com.git.hitzaki.education.api;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.*;

/**
 * 测试controller
 * @author hitzaki
 */
@RestController("/auth")
public class AuthApi {

    @RequestMapping("/testConnect")
    public String testConnect() {
        return "连接成功";
    }

    @RequestMapping("/logout")
    public String logout() {
        StpUtil.logout();
        return "退出登录成功";
    }

}
