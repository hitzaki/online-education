package com.git.hitzaki.education.biz.auth.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.auth.entity.AdminAccountInfoEntity;
import com.git.hitzaki.education.biz.auth.mapper.AdminAccountInfoMapper;
import com.git.hitzaki.education.biz.auth.dao.IAdminAccountInfoService;
import com.git.hitzaki.education.model.auth.enums.AdminStatusEnum;
import com.git.hitzaki.education.model.auth.param.LoginParam;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 管理员账号表 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Service
public class AdminAccountInfoServiceImpl extends ServiceImpl<AdminAccountInfoMapper, AdminAccountInfoEntity> implements IAdminAccountInfoService {

    @Override
    public AdminAccountInfoEntity selectByLoginParam(LoginParam loginParam) {
        LambdaQueryWrapper<AdminAccountInfoEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AdminAccountInfoEntity::getAccount, loginParam.getAccount())
                .eq(AdminAccountInfoEntity::getPassword, loginParam.getPassword())
                .eq(AdminAccountInfoEntity::getStatus, AdminStatusEnum.USE.getCode());
        List<AdminAccountInfoEntity> adminList = list(wrapper);
        if (CollectionUtils.isEmpty(adminList)){
            return null;
        }
        return adminList.get(0);
    }

    @Override
    public Long selectBySalesmanCode(String salesmanCode) {
        LambdaQueryWrapper<AdminAccountInfoEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AdminAccountInfoEntity::getSalesmanCode, salesmanCode)
                .eq(AdminAccountInfoEntity::getStatus, AdminStatusEnum.USE.getCode());
        List<AdminAccountInfoEntity> adminList = list(wrapper);
        if (CollectionUtils.isEmpty(adminList)){
            return null;
        }
        return adminList.get(0).getId();
    }
}
