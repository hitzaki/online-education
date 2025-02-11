package com.git.hitzaki.education.biz.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.auth.dao.IAdminAccountInfoService;
import com.git.hitzaki.education.biz.auth.dao.IUserAccountInfoService;
import com.git.hitzaki.education.biz.auth.dao.IUserInfoService;
import com.git.hitzaki.education.biz.auth.mapper.AdminAccountInfoMapper;
import com.git.hitzaki.education.biz.auth.mapper.PermissionMapper;
import com.git.hitzaki.education.biz.auth.mapper.RoleMapper;
import com.git.hitzaki.education.biz.auth.mapper.UserInfoMapper;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.IAuthManageBizService;
import com.git.hitzaki.education.model.auth.param.*;
import com.git.hitzaki.education.model.auth.vo.AdminVo;
import com.git.hitzaki.education.model.auth.vo.PermissionVo;
import com.git.hitzaki.education.model.auth.vo.RoleVo;
import com.git.hitzaki.education.model.auth.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务操作接口实现
 * @author lixuanchen
 * @version 1.0
 */
@Service
public class AuthManageBizService implements IAuthManageBizService {
    @Autowired
    private IAdminAccountInfoService adminAccountInfoService;

    @Autowired
    private IUserAccountInfoService userAccountInfoService;

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private AdminAccountInfoMapper adminAccountInfoMapper;


    @Override
    public PageResult<PermissionVo> permissionPage(PermissionQueryParam queryParam) {
        Page<PermissionVo> page = new Page<>(queryParam.getPageNo(), queryParam.getPageSize());
        return permissionMapper.permissionPage(page, queryParam);
    }

    @Override
    public PageResult<RoleVo> rolePage(RoleQueryParam queryParam) {
        Page<RoleVo> page = new Page<>(queryParam.getPageNo(), queryParam.getPageSize());
        return roleMapper.rolePage(page, queryParam);
    }

    @Override
    public PageResult<PermissionVo> rolePermissionPage(PermissionQueryParam queryParam) {
        Page<PermissionVo> page = new Page<>(queryParam.getPageNo(), queryParam.getPageSize());
        return permissionMapper.rolePermissionPage(page, queryParam);
    }

    @Override
    public PageResult<RoleVo> userRolePage(RoleQueryParam queryParam) {
        Page<RoleVo> page = new Page<>(queryParam.getPageNo(), queryParam.getPageSize());
        return roleMapper.userRolePage(page, queryParam);
    }

    @Override
    public PageResult<UserVo> userPage(UserQueryParam queryParam) {
        Page<UserVo> page = new Page<>(queryParam.getPageNo(), queryParam.getPageSize());
        return userInfoMapper.userPage(page, queryParam);
    }

    @Override
    public PageResult<AdminVo> adminPage(AdminQueryParam queryParam) {
        Page<AdminVo> page = new Page<>(queryParam.getPageNo(), queryParam.getPageSize());
        return adminAccountInfoMapper.adminPage(page, queryParam);
    }

    @Override
    public void permissionDelete(PermissionOperateParam operateParam) {

    }
}
