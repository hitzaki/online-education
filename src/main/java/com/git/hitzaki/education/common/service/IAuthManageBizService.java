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
}
