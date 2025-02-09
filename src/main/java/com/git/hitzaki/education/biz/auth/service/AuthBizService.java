package com.git.hitzaki.education.biz.auth.service;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.git.hitzaki.education.biz.auth.dao.IAdminAccountInfoService;
import com.git.hitzaki.education.biz.auth.dao.IUserAccountInfoService;
import com.git.hitzaki.education.biz.auth.dao.IUserInfoService;
import com.git.hitzaki.education.biz.auth.entity.AdminAccountInfoEntity;
import com.git.hitzaki.education.biz.auth.entity.UserAccountInfoEntity;
import com.git.hitzaki.education.biz.auth.entity.UserInfoEntity;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.enums.LoginTypeEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.service.IAuthBizService;
import com.git.hitzaki.education.common.utils.AuthInfoUtils;
import com.git.hitzaki.education.common.utils.SnowflakeIdUtil;
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

    @Autowired
    private IUserAccountInfoService userAccountInfoService;

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private SnowflakeIdUtil snowflakeIdUtil;


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

    @Override
    public Map<String, Object> phoneLogin(LoginParam loginParam) {
        UserAccountInfoEntity user = userAccountInfoService.getByPhone(loginParam.getPhone());
        // 1.手机号之前注册过, 微信号第一次绑定手机号
        if (Objects.nonNull(user) && StringUtils.isNotBlank(loginParam.getWxCode())){
            user.setWechatCode(loginParam.getWxCode());
            userAccountInfoService.updateById(user);
        }

        // 2.手机号没注册过, 可能跟微信一起注册
        if (Objects.isNull(user)){
            // 首次登录 自动注册
            user = new UserAccountInfoEntity();
            user.setId(snowflakeIdUtil.nextId());
            user.setPhone(loginParam.getPhone());
            // 账号密码目前没有登录方式, 暂时等于手机号
            user.setAccount(loginParam.getPhone());
            user.setPassword(loginParam.getPhone());

            // wx号+手机号绑定模式
            if (StringUtils.isNotBlank(loginParam.getWxCode())){
                // 校验此wxCode是否绑定过了
                UserAccountInfoEntity wxUser = userAccountInfoService.getByWxCode(loginParam.getWxCode());
                if (Objects.nonNull(wxUser)){
                    CommonBizException.throwError(ExceptionEnum.WX_BIND_ERROR);
                }
                user.setWechatCode(loginParam.getWxCode());
            }else {
                // wxCode没绑定之前暂时等于手机号
                user.setWechatCode(loginParam.getPhone());
            }
            userAccountInfoService.save(user);
        }

        // 3.登录
        StpUtil.login(AuthInfoUtils.buildLoginInfo(LoginTypeEnum.USER.getType(), user.getId()));
        Map<String, Object> result = new HashMap<>();
        result.put("token", StpUtil.getTokenValue());
        return result;
    }

    @Override
    public Map<String, Object> wxLogin(LoginParam loginParam) {
        UserAccountInfoEntity user = userAccountInfoService.getByWxCode(loginParam.getWxCode());
        if (Objects.isNull(user)){
            CommonBizException.throwError(ExceptionEnum.WX_BIND);
        }
        StpUtil.login(AuthInfoUtils.buildLoginInfo(LoginTypeEnum.USER.getType(), user.getId()));
        Map<String, Object> result = new HashMap<>();
        result.put("token", StpUtil.getTokenValue());
        return result;
    }

    @Override
    public Map<String, Object> userExtendInfo() {
        UserInfoEntity userEntity = userInfoService.getById(AuthInfoUtils.getLoginId());
        if (Objects.isNull(userEntity)){
            CommonBizException.throwError(ExceptionEnum.AUTH_ERROR);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("roles", AuthInfoUtils.getLoginType());
        // result.put("introduction", userEntity.get);
        result.put("avatar",userEntity.getAvatar());
        result.put("name", userEntity.getNickName());
        return result;
    }
}
