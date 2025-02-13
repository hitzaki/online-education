package com.git.hitzaki.education.api.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.git.hitzaki.education.bus.auth.AuthCommonService;
import com.git.hitzaki.education.bus.auth.AuthManageCommonService;
import com.git.hitzaki.education.common.model.BizResult;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.auth.param.*;
import com.git.hitzaki.education.model.auth.vo.*;
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
@RestController
@RequestMapping("/adminAuth")
public class AdminAuthApi {

    @Autowired
    private AuthCommonService authCommonService;

    @Autowired
    private AuthManageCommonService authManageCommonService;

    // 停用的管理员不能登录
    @ApiOperation("管理员账号密码登录")
    @PostMapping("/adminLogin")
    public BizResult<Map<String, Object>> adminLogin(@RequestBody LoginParam loginParam) {
        return BizResult.success(authCommonService.adminLogin(loginParam));
    }

    @ApiOperation("管理员拓展信息获取")
    @PostMapping("/adminExtendInfo")
    @SaCheckRole(value = {"admin", "salesman"}, mode = SaMode.OR)
    public BizResult<Map<String, Object>> adminExtendInfo() {
        return BizResult.success(authCommonService.adminExtendInfo());
    }

    @ApiOperation("退出登录")
    @PostMapping("/adminLogout")
    @SaCheckRole(value = {"admin", "salesman"}, mode = SaMode.OR)
    public BizResult<Void> adminLogout() {
        authCommonService.adminLogout();
        return BizResult.success();
    }

    /**
     * 权限增删改查
     */
    @ApiOperation("权限-分页查询")
    @PostMapping("/permissionPage")
    @SaCheckRole("admin")
    public PageResult<PermissionVo> permissionPage(@RequestBody PermissionQueryParam queryParam) {
        return authManageCommonService.permissionPage(queryParam);
    }

    @ApiOperation("权限-删除")
    @PostMapping("/permissionDelete")
    @SaCheckRole("admin")
    public BizResult<Void> permissionDelete(@RequestBody PermissionOperateParam operateParam) {
        authManageCommonService.permissionDelete(operateParam);
        return BizResult.success();
    }

    @ApiOperation("权限-新增")
    @PostMapping("/permissionInsert")
    @SaCheckRole("admin")
    public BizResult<Void> permissionInsert(@RequestBody PermissionOperateParam operateParam) {
        authManageCommonService.permissionInsert(operateParam);
        return BizResult.success();
    }

    /**
     * 角色增删改查
     */
    @ApiOperation("角色-分页查询")
    @PostMapping("/rolePage")
    @SaCheckRole(value = {"admin", "salesman"}, mode = SaMode.OR)
    public PageResult<RoleVo> rolePage(@RequestBody RoleQueryParam queryParam) {
        return authManageCommonService.rolePage(queryParam);
    }

    @ApiOperation("角色-删除")
    @PostMapping("/roleDelete")
    @SaCheckRole("admin")
    public BizResult<Void> roleDelete(@RequestBody RoleOperateParam operateParam) {
        authManageCommonService.roleDelete(operateParam);
        return BizResult.success();
    }

    @ApiOperation("角色-新增")
    @PostMapping("/roleInsert")
    @SaCheckRole("admin")
    public BizResult<Void> roleInsert(@RequestBody RoleOperateParam operateParam) {
        authManageCommonService.roleInsert(operateParam);
        return BizResult.success();
    }

    /**
     * 角色权限增删改查
     */
    @ApiOperation("角色权限-分页查询")
    @PostMapping("/rolePermissionPage")
    @SaCheckRole("admin")
    public PageResult<PermissionVo> rolePermissionPage(@RequestBody PermissionQueryParam queryParam) {
        return authManageCommonService.rolePermissionPage(queryParam);
    }

    @ApiOperation("角色权限-删除")
    @PostMapping("/rolePermissionDelete")
    @SaCheckRole("admin")
    public BizResult<Void> rolePermissionDelete(@RequestBody RolePermissionOperateParam operateParam) {
        authManageCommonService.rolePermissionDelete(operateParam);
        return BizResult.success();
    }

    @ApiOperation("角色权限-新增")
    @PostMapping("/rolePermissionInsert")
    @SaCheckRole("admin")
    public BizResult<Void> rolePermissionInsert(@RequestBody RolePermissionOperateParam operateParam) {
        authManageCommonService.rolePermissionInsert(operateParam);
        return BizResult.success();
    }

    /**
     * 用户管理
     */
    @ApiOperation("用户-分页查询")
    @PostMapping("/userPage")
    @SaCheckRole("admin")
    public PageResult<UserVo> userPage(@RequestBody UserQueryParam queryParam) {
        return authManageCommonService.userPage(queryParam);
    }

    @ApiOperation("用户-封禁")
    @PostMapping("/userBan")
    @SaCheckRole("admin")
    public BizResult<Void> userBan(@RequestBody UserOperateParam operateParam) {
        authManageCommonService.userBan(operateParam);
        return BizResult.success();
    }

    @ApiOperation("用户-解除封禁")
    @PostMapping("/userUnban")
    @SaCheckRole("admin")
    public BizResult<Void> userUnban(@RequestBody UserOperateParam operateParam) {
        authManageCommonService.userUnban(operateParam);
        return BizResult.success();
    }

    /**
     * 用户角色管理
     */
    @ApiOperation("用户角色-分页查询")
    @PostMapping("/userRolePage")
    @SaCheckRole("admin")
    public PageResult<RoleVo> userRolePage(@RequestBody RoleQueryParam queryParam) {
        return authManageCommonService.userRolePage(queryParam);
    }

    @ApiOperation("用户角色-新增")
    @PostMapping("/userRoleInsert")
    @SaCheckRole("admin")
    public BizResult<Void> userRoleInsert(@RequestBody UserRoleOperateParam operateParam) {
        authManageCommonService.userRoleInsert(operateParam);
        return BizResult.success();
    }

    @ApiOperation("用户角色-删除")
    @PostMapping("/userRoleDelete")
    @SaCheckRole("admin")
    public BizResult<Void> userRoleDelete(@RequestBody UserRoleOperateParam operateParam) {
        authManageCommonService.userRoleDelete(operateParam);
        return BizResult.success();
    }

    /**
     * 管理员管理
     */
    @ApiOperation("管理员-分页查询")
    @PostMapping("/adminPage")
    @SaCheckRole("admin")
    public PageResult<AdminVo> adminPage(@RequestBody AdminQueryParam queryParam) {
        return authManageCommonService.adminPage(queryParam);
    }

    @ApiOperation("管理员-新增")
    @PostMapping("/adminInsert")
    @SaCheckRole("admin")
    public BizResult<Void> adminInsert(@RequestBody AdminOperateParam operateParam) {
        authManageCommonService.adminInsert(operateParam);
        return BizResult.success();
    }

    @ApiOperation("管理员-停用")
    @PostMapping("/adminBan")
    @SaCheckRole("admin")
    public BizResult<Void> adminBan(@RequestBody AdminOperateParam operateParam) {
        authManageCommonService.adminBan(operateParam);
        return BizResult.success();
    }

    @ApiOperation("业务员生成分享链接")
    @PostMapping("/salesmanLink")
    @SaCheckRole("salesman")
    public BizResult<String> salesmanLink() {
        return BizResult.success(authManageCommonService.salesmanLink());
    }
    // TODO 管理员改变资料
    // TODO 管理员改变头像

}
