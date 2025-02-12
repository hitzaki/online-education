package com.git.hitzaki.education.biz.auth.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.auth.dao.*;
import com.git.hitzaki.education.biz.auth.entity.*;
import com.git.hitzaki.education.biz.auth.mapper.AdminAccountInfoMapper;
import com.git.hitzaki.education.biz.auth.mapper.PermissionMapper;
import com.git.hitzaki.education.biz.auth.mapper.RoleMapper;
import com.git.hitzaki.education.biz.auth.mapper.UserInfoMapper;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.IAuthManageBizService;
import com.git.hitzaki.education.common.utils.IdGenerator;
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
    private IPermissionService permissionService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IRolePermissionService rolePermissionService;

    @Autowired
    private IUserRoleService userRoleService;

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
        permissionService.removeById(operateParam.getPermissionId());
    }

    @Override
    public void permissionInsert(PermissionOperateParam operateParam) {
        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.setId(IdGenerator.generateId());
        permissionEntity.setCode(operateParam.getCode());
        permissionEntity.setName(operateParam.getName());
        try {
            permissionService.save(permissionEntity);
        }catch (Exception e){
            throw new CommonBizException("code或名称重复");
        }
    }

    @Override
    public void roleDelete(RoleOperateParam operateParam) {
        roleService.removeById(operateParam.getRoleId());
    }

    @Override
    public void roleInsert(RoleOperateParam operateParam) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(IdGenerator.generateId());
        roleEntity.setRoleCode(operateParam.getCode());
        roleEntity.setRoleName(operateParam.getName());
        try {
            roleService.save(roleEntity);
        }catch (Exception e){
            throw new CommonBizException("code或名称重复");
        }
    }

    @Override
    public void rolePermissionDelete(RolePermissionOperateParam operateParam) {
        rolePermissionService.removeById(operateParam.getRolePermissionId());
    }

    @Override
    public void rolePermissionInsert(RolePermissionOperateParam operateParam) {
        RolePermissionEntity rolePermissionEntity = new RolePermissionEntity();
        rolePermissionEntity.setId(IdGenerator.generateId());
        rolePermissionEntity.setPermissionId(operateParam.getPermissionId());
        rolePermissionEntity.setRoleId(operateParam.getRoleId());
        rolePermissionService.save(rolePermissionEntity);
    }

    @Override
    public void userRoleDelete(UserRoleOperateParam operateParam) {
        userRoleService.removeById(operateParam.getUserRoleId());
    }

    @Override
    public void userRoleInsert(UserRoleOperateParam operateParam) {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setId(IdGenerator.generateId());
        userRoleEntity.setUserId(operateParam.getUserId());
        userRoleEntity.setRoleId(operateParam.getRoleId());
        userRoleService.save(userRoleEntity);
    }

    @Override
    public void userBan(UserOperateParam operateParam) {
        UserAccountInfoEntity user = new UserAccountInfoEntity();
        user.setId(operateParam.getUserId());
        // TODO 枚举抽取
        user.setStatus(1);
        userAccountInfoService.updateById(user);
    }

    @Override
    public void userUnban(UserOperateParam operateParam) {
        UserAccountInfoEntity user = new UserAccountInfoEntity();
        user.setId(operateParam.getUserId());
        user.setStatus(0);
        userAccountInfoService.updateById(user);
    }

    @Override
    public void adminBan(AdminOperateParam operateParam) {
        AdminAccountInfoEntity admin = new AdminAccountInfoEntity();
        admin.setId(operateParam.getAdminId());
        admin.setStatus(1);
        adminAccountInfoService.updateById(admin);
    }

    @Override
    public void adminInsert(AdminOperateParam operateParam) {
        AdminAccountInfoEntity admin = new AdminAccountInfoEntity();
        admin.setId(IdGenerator.generateId());
        admin.setAccount(operateParam.getAccount());
        admin.setPassword(operateParam.getPassword());
        admin.setAvatar(operateParam.getAvatar());
        admin.setNickName(operateParam.getNickName());
        admin.setType(operateParam.getType());
        try {
            adminAccountInfoService.save(admin);
        }catch (Exception e){
            throw new CommonBizException("账号重复");
        }
    }

}
