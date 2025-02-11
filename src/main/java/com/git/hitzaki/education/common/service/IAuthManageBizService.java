package com.git.hitzaki.education.common.service;

import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.auth.param.*;
import com.git.hitzaki.education.model.auth.vo.AdminVo;
import com.git.hitzaki.education.model.auth.vo.PermissionVo;
import com.git.hitzaki.education.model.auth.vo.RoleVo;
import com.git.hitzaki.education.model.auth.vo.UserVo;

/**
 * 认证授权管理 接口定义
 * @author lixuanchen
 * @version 1.0
 */
public interface IAuthManageBizService {

    PageResult<PermissionVo> permissionPage(PermissionQueryParam queryParam);

    PageResult<RoleVo> rolePage(RoleQueryParam queryParam);


    PageResult<PermissionVo> rolePermissionPage(PermissionQueryParam queryParam);

    PageResult<RoleVo> userRolePage(RoleQueryParam queryParam);

    PageResult<UserVo> userPage(UserQueryParam queryParam);

    PageResult<AdminVo> adminPage(AdminQueryParam queryParam);

    void permissionDelete(PermissionOperateParam operateParam);

    void permissionInsert(PermissionOperateParam operateParam);

    void roleDelete(RoleOperateParam operateParam);

    void roleInsert(RoleOperateParam operateParam);

    void rolePermissionDelete(RolePermissionOperateParam operateParam);

    void rolePermissionInsert(RolePermissionOperateParam operateParam);

    void userRoleInsert(UserRoleOperateParam operateParam);

    void userRoleDelete(UserRoleOperateParam operateParam);

    void userBan(UserOperateParam operateParam);

    void userUnban(UserOperateParam operateParam);

    void adminBan(AdminOperateParam operateParam);

    void adminInsert(AdminOperateParam operateParam);

}
