package com.git.hitzaki.education.api.admin;

import com.git.hitzaki.education.bus.auth.AuthCommonService;
import com.git.hitzaki.education.common.model.BizResult;
import com.git.hitzaki.education.model.auth.param.LoginParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 授权登录 权限控制
 * @author hitzaki
 */
@Api("管理员-认证授权接口")
@RestController("/admin/auth")
public class AdminAuthApi {

    @Autowired
    private AuthCommonService authCommonService;

    @ApiOperation("管理员账号密码登录")
    @PostMapping("/adminLogin")
    public BizResult<Map<String, Object>> adminLogin(@RequestBody LoginParam loginParam) {
        return BizResult.success(authCommonService.adminLogin(loginParam));
    }

    @ApiOperation("管理员拓展信息获取")
    @PostMapping("/adminExtendInfo")
    public BizResult<Map<String, Object>> adminExtendInfo() {
        return BizResult.success(authCommonService.adminExtendInfo());
    }

    @ApiOperation("退出登录")
    @PostMapping("/adminLogout")
    public BizResult<Void> adminLogout() {
        authCommonService.adminLogout();
        return BizResult.success();
    }

}
