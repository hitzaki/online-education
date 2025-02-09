package com.git.hitzaki.education.biz.auth.service;

import com.git.hitzaki.education.biz.auth.dao.IAdminAccountInfoService;
import com.git.hitzaki.education.biz.auth.entity.AdminAccountInfoEntity;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.service.IAuthBizService;
import com.git.hitzaki.education.model.auth.param.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String adminLogin(LoginParam loginParam) {
        loginParam.checkAdminLogin();

        // 存在性校验
        AdminAccountInfoEntity adminEntity = adminAccountInfoService.selectByLoginParam(loginParam);
        if (Objects.isNull(adminEntity)){
            throw new CommonBizException("");
        }

        // TODO 登录
        Map<String, Object> extraData = new HashMap<>();
//        StpUtil.login(adminId,
//                new SaLoginModel()
//                        .setDevice("app") // 设备标识（可选）
//                        .setExtraData(extraData) // 写入扩展数据
//        );
//        StpUtil.login(saBaseLoginUser.getId(), new SaLoginModel().setDevice().setExtra("name", saBaseLoginUser.getName()));

        return "";
    }
}
