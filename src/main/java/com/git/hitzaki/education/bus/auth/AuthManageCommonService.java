package com.git.hitzaki.education.bus.auth;

import com.git.hitzaki.education.common.enums.LoginTypeEnum;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.IAuthManageBizService;
import com.git.hitzaki.education.common.utils.AuthInfoUtils;
import com.git.hitzaki.education.model.auth.param.*;
import com.git.hitzaki.education.model.auth.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 认证授权
 * @author hitzaki
 */
@Slf4j
@Service
public class AuthManageCommonService {
    @Autowired
    private IAuthManageBizService authManageBizService;


    public PageResult<PermissionVo> permissionPage(PermissionQueryParam queryParam) {
        return authManageBizService.permissionPage(queryParam);
    }

    public void permissionDelete(PermissionOperateParam operateParam) {
        operateParam.checkDelete();
        authManageBizService.permissionDelete(operateParam);
    }

    public void permissionInsert(PermissionOperateParam operateParam) {
        operateParam.checkInsert();
        authManageBizService.permissionInsert(operateParam);
    }

    public PageResult<RoleVo> rolePage(RoleQueryParam queryParam) {
        return authManageBizService.rolePage(queryParam);
    }

    public void roleDelete(RoleOperateParam operateParam) {
        operateParam.checkDelete();
        authManageBizService.roleDelete(operateParam);
    }

    public void roleInsert(RoleOperateParam operateParam) {
        operateParam.checkInsert();
        authManageBizService.roleInsert(operateParam);
    }

    public PageResult<PermissionVo> rolePermissionPage(PermissionQueryParam queryParam) {
        queryParam.checkRolePermissionPage();
        return authManageBizService.rolePermissionPage(queryParam);
    }

    public void rolePermissionDelete(RolePermissionOperateParam operateParam) {
        operateParam.checkDelete();
        authManageBizService.rolePermissionDelete(operateParam);
    }

    public void rolePermissionInsert(RolePermissionOperateParam operateParam) {
        operateParam.checkInsert();
        authManageBizService.rolePermissionInsert(operateParam);
    }

    public PageResult<RoleVo> userRolePage(RoleQueryParam queryParam) {
        queryParam.checkUserRolePage();
        return authManageBizService.userRolePage(queryParam);
    }

    public void userRoleInsert(UserRoleOperateParam operateParam) {
        operateParam.checkInsert();
        authManageBizService.userRoleInsert(operateParam);
    }

    public void userRoleDelete(UserRoleOperateParam operateParam) {
        operateParam.checkDelete();
        authManageBizService.userRoleDelete(operateParam);
    }

    public PageResult<UserVo> userPage(UserQueryParam queryParam) {
        if (LoginTypeEnum.SALESMAN.getType().equals(AuthInfoUtils.getLoginType())){
            queryParam.setSalesmanId(AuthInfoUtils.getLoginId());
        }
        return authManageBizService.userPage(queryParam);
    }

    public void userBan(UserOperateParam operateParam) {
        operateParam.checkBan();
        authManageBizService.userBan(operateParam);
    }

    public void userUnban(UserOperateParam operateParam) {
        operateParam.checkBan();
        authManageBizService.userUnban(operateParam);
    }

    public PageResult<AdminVo> adminPage(AdminQueryParam queryParam) {
        return authManageBizService.adminPage(queryParam);
    }

    public void adminBan(AdminOperateParam operateParam) {
        operateParam.checkBan();
        authManageBizService.adminBan(operateParam);
    }

    public void adminInsert(AdminOperateParam operateParam) {
        operateParam.checkInsert();
        authManageBizService.adminInsert(operateParam);
    }

}
