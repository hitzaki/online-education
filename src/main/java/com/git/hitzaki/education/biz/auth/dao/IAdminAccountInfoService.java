package com.git.hitzaki.education.biz.auth.dao;


import com.baomidou.mybatisplus.extension.service.IService;
import com.git.hitzaki.education.biz.auth.entity.AdminAccountInfoEntity;
import com.git.hitzaki.education.model.auth.param.LoginParam;

/**
 * <p>
 * 管理员账号表 服务类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface IAdminAccountInfoService extends IService<AdminAccountInfoEntity> {

    AdminAccountInfoEntity selectByLoginParam(LoginParam loginParam);

    Long selectBySalesmanCode(String salesmanCode);
}
