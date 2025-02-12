package com.git.hitzaki.education.bus.auth;

import cn.dev33.satoken.stp.StpInterface;
import com.git.hitzaki.education.common.enums.LoginTypeEnum;
import com.git.hitzaki.education.common.service.IAuthBizService;
import com.git.hitzaki.education.common.utils.AuthInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * TODO
 * @author hitzaki
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private IAuthBizService authBizService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 用户类型
        String userType = AuthInfoUtils.getLoginType();

        if (LoginTypeEnum.ADMIN_TYPE.contains(userType)) {
            return Collections.singletonList(userType);
        }

        Long userId = AuthInfoUtils.getLoginId();
        // 获取权限列表
        return authBizService.getPermissionList(userId);
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 用户类型
        String userType = AuthInfoUtils.getLoginType();

        if (LoginTypeEnum.ADMIN_TYPE.contains(userType)) {
            return Collections.singletonList(userType);
        }

        Long userId = AuthInfoUtils.getLoginId();
        // 获取角色列表
        List<String> roleList = authBizService.getRoleList(userId);
        if (CollectionUtils.isEmpty(roleList)){
            return Collections.singletonList(userType);
        }
        roleList.add(userType);
        return roleList;
    }
}