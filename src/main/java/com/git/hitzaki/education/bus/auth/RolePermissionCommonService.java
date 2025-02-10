package com.git.hitzaki.education.bus.auth;

import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.IAuthBizService;
import com.git.hitzaki.education.model.auth.param.*;
import com.git.hitzaki.education.model.auth.vo.PermissionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 认证授权
 * @author hitzaki
 */
@Slf4j
@Service
public class RolePermissionCommonService {
    @Autowired
    private IAuthBizService authBizService;


    public PageResult<PermissionVo> permissionPage(PermissionQueryParam queryParam) {
        return null;
    }

    public void permissionDelete(PermissionOperateParam operateParam) {

    }

    public void permissionInsert(PermissionOperateParam operateParam) {

    }

    public PageResult<PermissionVo> rolePage(RoleQueryParam queryParam) {
        return null;
    }

    public void roleDelete(RoleOperateParam operateParam) {

    }

    public void roleInsert(RoleOperateParam operateParam) {

    }

    public PageResult<PermissionVo> rolePermissionPage(RolePermissionQueryParam queryParam) {
        return null;
    }

    public void rolePermissionDelete(RolePermissionOperateParam operateParam) {

    }

    public void rolePermissionInsert(RolePermissionOperateParam operateParam) {

    }

    public PageResult<PermissionVo> userPage(UserQueryParam queryParam) {
        return null;
    }

    public void userBan(UserOperateParam operateParam) {

    }

    public void userUnban(UserOperateParam operateParam) {

    }

    public PageResult<PermissionVo> adminPage(AdminQueryParam queryParam) {
        return null;
    }

    public void adminInsert(AdminOperateParam operateParam) {

    }

    public void adminBan(AdminOperateParam operateParam) {

    }
}
