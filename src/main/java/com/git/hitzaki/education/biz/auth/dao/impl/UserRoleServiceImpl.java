package com.git.hitzaki.education.biz.auth.dao.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.auth.entity.UserRoleEntity;
import com.git.hitzaki.education.biz.auth.mapper.UserRoleMapper;
import com.git.hitzaki.education.biz.auth.dao.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleEntity> implements IUserRoleService {

}
