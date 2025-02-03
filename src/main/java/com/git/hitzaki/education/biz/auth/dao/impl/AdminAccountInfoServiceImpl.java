package com.git.hitzaki.education.biz.auth.dao.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.auth.entity.AdminAccountInfoEntity;
import com.git.hitzaki.education.biz.auth.mapper.AdminAccountInfoMapper;
import com.git.hitzaki.education.biz.auth.dao.IAdminAccountInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员账号表 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Service
public class AdminAccountInfoServiceImpl extends ServiceImpl<AdminAccountInfoMapper, AdminAccountInfoEntity> implements IAdminAccountInfoService {

}
