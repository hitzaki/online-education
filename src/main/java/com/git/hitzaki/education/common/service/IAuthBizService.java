package com.git.hitzaki.education.common.service;

import com.git.hitzaki.education.model.auth.param.LoginParam;
import com.git.hitzaki.education.model.auth.param.UserOperateParam;

import java.util.List;
import java.util.Map;

/**
 * 通用auth业务service接口
 * biz负责提供此接口实现，bus通过此接口注入
 * @author lixuanchen
 * @version 1.0
 */
public interface IAuthBizService {
    Map<String, Object> adminLogin(LoginParam loginParam);

    Map<String, Object> adminExtendInfo();

    Map<String, Object> phoneLogin(LoginParam loginParam);

    Map<String, Object> wxLogin(LoginParam loginParam);

    Map<String, Object> userExtendInfo();

    List<String> getPermissionList(Long userId);

    List<String> getRoleList(Long userId);

    void updateUserInfo(UserOperateParam operateParam);
}
