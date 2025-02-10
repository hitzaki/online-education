package com.git.hitzaki.education.api.admin;

import com.git.hitzaki.education.bus.auth.AuthCommonService;
import com.git.hitzaki.education.bus.auth.RolePermissionCommonService;
import com.git.hitzaki.education.common.model.BizResult;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.auth.param.*;
import com.git.hitzaki.education.model.auth.vo.PermissionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 授权登录 权限控制
 * @author hitzaki
 */
@Api("管理员-认证授权接口")
@RestController("/adminAuth")
public class AdminAuthApi {

    @Autowired
    private AuthCommonService authCommonService;

    @Autowired
    private RolePermissionCommonService rolePermissionCommonService;

    @ApiOperation("管理员账号密码登录")
    @PostMapping("/adminLogin")
    public BizResult<Map<String, Object>> adminLogin(@RequestBody LoginParam loginParam) {
        return BizResult.success(authCommonService.adminLogin(loginParam));
    }

    @ApiOperation("管理员拓展信息获取")
    @PostMapping("/adminExtendInfo")
    public BizResult<Map<String, Object>> adminExtendInfo() {
        return BizResult.success(authCommonService.adminExtendInfo());
    }

    @ApiOperation("退出登录")
    @PostMapping("/adminLogout")
    public BizResult<Void> adminLogout() {
        authCommonService.adminLogout();
        return BizResult.success();
    }

    /**
     * 权限增删改查
     */
    @ApiOperation("权限-分页查询")
    @PostMapping("/permissionPage")
    public PageResult<PermissionVo> permissionPage(PermissionQueryParam queryParam) {
        return rolePermissionCommonService.permissionPage(queryParam);
    }

    @ApiOperation("权限-删除")
    @PostMapping("/permissionDelete")
    public BizResult<Void> permissionDelete(PermissionOperateParam operateParam) {
        rolePermissionCommonService.permissionDelete(operateParam);
        return BizResult.success();
    }

    @ApiOperation("权限-新增")
    @PostMapping("/permissionInsert")
    public BizResult<Void> permissionInsert(PermissionOperateParam operateParam) {
        rolePermissionCommonService.permissionInsert(operateParam);
        return BizResult.success();
    }

    /**
     * 角色增删改查
     */
    @ApiOperation("角色-分页查询")
    @PostMapping("/rolePage")
    public PageResult<PermissionVo> rolePage(RoleQueryParam queryParam) {
        return rolePermissionCommonService.rolePage(queryParam);
    }

    @ApiOperation("角色-删除")
    @PostMapping("/roleDelete")
    public BizResult<Void> roleDelete(RoleOperateParam operateParam) {
        rolePermissionCommonService.roleDelete(operateParam);
        return BizResult.success();
    }

    @ApiOperation("角色-新增")
    @PostMapping("/roleInsert")
    public BizResult<Void> roleInsert(RoleOperateParam operateParam) {
        rolePermissionCommonService.roleInsert(operateParam);
        return BizResult.success();
    }

    /**
     * 角色权限增删改查
     */
    @ApiOperation("权限-分页查询")
    @PostMapping("/rolePermissionPage")
    public PageResult<PermissionVo> rolePermissionPage(RolePermissionQueryParam queryParam) {
        return rolePermissionCommonService.rolePermissionPage(queryParam);
    }

    @ApiOperation("权限-删除")
    @PostMapping("/rolePermissionDelete")
    public BizResult<Void> rolePermissionDelete(RolePermissionOperateParam operateParam) {
        rolePermissionCommonService.rolePermissionDelete(operateParam);
        return BizResult.success();
    }

    @ApiOperation("权限-新增")
    @PostMapping("/rolePermissionInsert")
    public BizResult<Void> rolePermissionInsert(RolePermissionOperateParam operateParam) {
        rolePermissionCommonService.rolePermissionInsert(operateParam);
        return BizResult.success();
    }

    /**
     * 用户管理
     */
    @ApiOperation("用户-分页查询")
    @PostMapping("/userPage")
    public PageResult<PermissionVo> userPage(UserQueryParam queryParam) {
        return rolePermissionCommonService.userPage(queryParam);
    }

    @ApiOperation("权限-封禁")
    @PostMapping("/userBan")
    public BizResult<Void> userBan(UserOperateParam operateParam) {
        rolePermissionCommonService.userBan(operateParam);
        return BizResult.success();
    }

    @ApiOperation("权限-解除封禁")
    @PostMapping("/userUnban")
    public BizResult<Void> userUnban(UserOperateParam operateParam) {
        rolePermissionCommonService.userUnban(operateParam);
        return BizResult.success();
    }

    /**
     * 管理员管理
     */
    @ApiOperation("管理员-分页查询")
    @PostMapping("/adminPage")
    public PageResult<PermissionVo> adminPage(AdminQueryParam queryParam) {
        return rolePermissionCommonService.adminPage(queryParam);
    }

    @ApiOperation("管理员-新增")
    @PostMapping("/adminInsert")
    public BizResult<Void> adminInsert(AdminOperateParam operateParam) {
        rolePermissionCommonService.adminInsert(operateParam);
        return BizResult.success();
    }

    @ApiOperation("管理员-停用")
    @PostMapping("/adminBan")
    public BizResult<Void> adminBan(AdminOperateParam operateParam) {
        rolePermissionCommonService.adminBan(operateParam);
        return BizResult.success();
    }

    // TODO 操作权限注解
    // TODO 管理员改变头像
    // TODO 管理员改变资料
    // TODO 业务员分页查看自己对应的用户列表
    // TODO 业务员生成分享链接

}
