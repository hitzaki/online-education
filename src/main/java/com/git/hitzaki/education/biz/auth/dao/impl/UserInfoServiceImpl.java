package com.git.hitzaki.education.biz.auth.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.auth.entity.UserAccountInfoEntity;
import com.git.hitzaki.education.biz.auth.entity.UserInfoEntity;
import com.git.hitzaki.education.biz.auth.mapper.UserInfoMapper;
import com.git.hitzaki.education.biz.auth.dao.IUserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 用户个人信息表 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoEntity> implements IUserInfoService {

    @Override
    public UserInfoEntity getByUserId(Long loginId) {
        LambdaQueryWrapper<UserInfoEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfoEntity::getUserId, loginId);
        List<UserInfoEntity> userList = list(wrapper);
        if (CollectionUtils.isEmpty(userList)){
            return null;
        }
        return userList.get(0);
    }
}
