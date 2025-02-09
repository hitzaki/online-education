package com.git.hitzaki.education.biz.auth.service;

import cn.dev33.satoken.stp.StpUtil;
import com.git.hitzaki.education.biz.auth.dao.IAdminAccountInfoService;
import com.git.hitzaki.education.biz.auth.entity.AdminAccountInfoEntity;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.enums.LoginTypeEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.service.IAuthBizService;
import com.git.hitzaki.education.common.utils.AuthInfoUtils;
import com.git.hitzaki.education.model.auth.param.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 业务操作接口实现
 * @author lixuanchen
 * @version 1.0
 */
@Service
public class AuthBizService implements IAuthBizService {
    @Autowired
    private IAdminAccountInfoService adminAccountInfoService;


    @Override
    public Map<String, Object> adminLogin(LoginParam loginParam) {
        // 存在性校验
        AdminAccountInfoEntity adminEntity = adminAccountInfoService.selectByLoginParam(loginParam);
        if (Objects.isNull(adminEntity)){
            CommonBizException.throwError(ExceptionEnum.ADMIN_LOGIN_ERROR);
        }
        String loginType = LoginTypeEnum.getLoginType(adminEntity.getType());
        StpUtil.login(AuthInfoUtils.buildLoginInfo(loginType, adminEntity.getId()));

        Map<String, Object> result = new HashMap<>();
        result.put("token", StpUtil.getTokenValue());
        return result;
    }

    @Override
    public Map<String, Object> adminExtendInfo() {
        AdminAccountInfoEntity adminEntity = adminAccountInfoService.getById(AuthInfoUtils.getLoginId());
        if (Objects.isNull(adminEntity)){
            CommonBizException.throwError(ExceptionEnum.AUTH_ERROR);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("roles", AuthInfoUtils.getLoginType());
        // result.put("introduction", adminEntity.get);
        result.put("avatar",adminEntity.getAvatar());
        result.put("name", adminEntity.getNickName());
        return result;
    }
}
