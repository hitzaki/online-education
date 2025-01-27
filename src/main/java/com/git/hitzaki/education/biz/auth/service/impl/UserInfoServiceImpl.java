package com.git.hitzaki.education.biz.auth.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.auth.entity.UserInfo;
import com.git.hitzaki.education.biz.auth.mapper.UserInfoMapper;
import com.git.hitzaki.education.biz.auth.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户个人信息表 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
