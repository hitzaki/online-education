package com.git.hitzaki.education.biz.auth.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.auth.entity.UserAccountInfo;
import com.git.hitzaki.education.biz.auth.mapper.UserAccountInfoMapper;
import com.git.hitzaki.education.biz.auth.service.IUserAccountInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账号表 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Service
public class UserAccountInfoServiceImpl extends ServiceImpl<UserAccountInfoMapper, UserAccountInfo> implements IUserAccountInfoService {

}
