package com.git.hitzaki.education.biz.auth.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.auth.entity.AdminAccountInfoEntity;
import com.git.hitzaki.education.biz.auth.entity.UserAccountInfoEntity;
import com.git.hitzaki.education.biz.auth.mapper.UserAccountInfoMapper;
import com.git.hitzaki.education.biz.auth.dao.IUserAccountInfoService;
import com.git.hitzaki.education.model.auth.enums.AdminStatusEnum;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 用户账号表 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Service
public class UserAccountInfoServiceImpl extends ServiceImpl<UserAccountInfoMapper, UserAccountInfoEntity> implements IUserAccountInfoService {

    @Override
    public UserAccountInfoEntity getByPhone(String phone) {
        LambdaQueryWrapper<UserAccountInfoEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserAccountInfoEntity::getPhone, phone);
        List<UserAccountInfoEntity> userList = list(wrapper);
        if (CollectionUtils.isEmpty(userList)){
            return null;
        }
        return userList.get(0);
    }

    @Override
    public UserAccountInfoEntity getByWxCode(String wxCode) {
        LambdaQueryWrapper<UserAccountInfoEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserAccountInfoEntity::getWechatCode, wxCode);
        List<UserAccountInfoEntity> userList = list(wrapper);
        if (CollectionUtils.isEmpty(userList)){
            return null;
        }
        return userList.get(0);
    }
}
