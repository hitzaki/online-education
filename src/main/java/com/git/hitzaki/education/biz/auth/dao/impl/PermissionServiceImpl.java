package com.git.hitzaki.education.biz.auth.dao.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.auth.entity.PermissionEntity;
import com.git.hitzaki.education.biz.auth.mapper.PermissionMapper;
import com.git.hitzaki.education.biz.auth.dao.IPermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, PermissionEntity> implements IPermissionService {

}
