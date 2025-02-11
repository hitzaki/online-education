package com.git.hitzaki.education.bus.auth;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.IAuthManageBizService;
import com.git.hitzaki.education.common.utils.validation.FormatValidationUtil;
import com.git.hitzaki.education.model.auth.param.*;
import com.git.hitzaki.education.model.auth.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
        // TODO
    }

    public void permissionInsert(PermissionOperateParam operateParam) {
// TODO
    }

    public PageResult<RoleVo> rolePage(RoleQueryParam queryParam) {
        return authManageBizService.rolePage(queryParam);
    }

    public void roleDelete(RoleOperateParam operateParam) {
// TODO
    }

    public void roleInsert(RoleOperateParam operateParam) {
// TODO
    }

    public PageResult<PermissionVo> rolePermissionPage(PermissionQueryParam queryParam) {
        if (! FormatValidationUtil.isId(queryParam.getRoleId())){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
        return authManageBizService.rolePermissionPage(queryParam);
    }

    public void rolePermissionDelete(RolePermissionOperateParam operateParam) {
// TODO
    }

    public void rolePermissionInsert(RolePermissionOperateParam operateParam) {
// TODO
    }

    public PageResult<RoleVo> userRolePage(RoleQueryParam queryParam) {
        if (! FormatValidationUtil.isId(queryParam.getUserId())){
            CommonBizException.throwError(ExceptionEnum.PARAM_LACK);
        }
        return authManageBizService.userRolePage(queryParam);
    }

    public void userRoleInsert(UserRoleOperateParam operateParam) {
// TODO
    }

    public void userRoleDelete(UserRoleOperateParam operateParam) {
// TODO
    }

    public PageResult<UserVo> userPage(UserQueryParam queryParam) {
        return authManageBizService.userPage(queryParam);
    }

    public void userBan(UserOperateParam operateParam) {
// TODO
    }

    public void userUnban(UserOperateParam operateParam) {
// TODO
    }

    public PageResult<AdminVo> adminPage(AdminQueryParam queryParam) {
        return authManageBizService.adminPage(queryParam);
    }

    public void adminInsert(AdminOperateParam operateParam) {
// TODO
    }

    public void adminBan(AdminOperateParam operateParam) {
// TODO
    }


}
