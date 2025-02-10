package com.git.hitzaki.education.bus.auth;

import cn.dev33.satoken.stp.StpUtil;
import com.git.hitzaki.education.common.enums.ExceptionEnum;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.IAuthBizService;
import com.git.hitzaki.education.common.utils.validation.FormatValidationUtil;
import com.git.hitzaki.education.model.auth.param.LoginParam;
import com.git.hitzaki.education.model.auth.param.PermissionOperateParam;
import com.git.hitzaki.education.model.auth.param.RoleOperateParam;
import com.git.hitzaki.education.model.auth.param.RolePermissionOperateParam;
import com.git.hitzaki.education.model.auth.vo.PermissionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 认证授权
 * @author hitzaki
 */
@Slf4j
@Service
public class RolePermissionCommonService {
    @Autowired
    private IAuthBizService authBizService;


    public PageResult<PermissionVo> permissionPage() {
        return null;
    }

    public void permissionDelete(PermissionOperateParam operateParam) {

    }

    public void permissionInsert(PermissionOperateParam operateParam) {

    }

    public PageResult<PermissionVo> rolePage() {
        return null;
    }

    public void roleDelete(RoleOperateParam operateParam) {

    }

    public void roleInsert(RoleOperateParam operateParam) {

    }

    public PageResult<PermissionVo> rolePermissionPage() {
        return null;
    }

    public void rolePermissionDelete(RolePermissionOperateParam operateParam) {

    }

    public void rolePermissionInsert(RolePermissionOperateParam operateParam) {

    }
}
