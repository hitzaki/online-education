package com.git.hitzaki.education.api;

import org.springframework.web.bind.annotation.*;

/**
 * 测试controller
 * @author hitzaki
 */
@RestController
public class AuthApi {

    @RequestMapping("/login-success")
    public String loginSuccess() {
        return "登录成功";
    }

}
