package com.git.hitzaki.education.biz.auth.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.auth.entity.PermissionEntity;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.auth.param.PermissionQueryParam;
import com.git.hitzaki.education.model.auth.vo.PermissionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface PermissionMapper extends BaseMapper<PermissionEntity> {

    List<String> selectPermissionByUserId(Long userId);

    Page<PermissionVo> permissionPage(@Param("page") Page<PermissionVo> page,
                                            @Param("param") PermissionQueryParam queryParam);

    Page<PermissionVo> rolePermissionPage(@Param("page") Page<PermissionVo> page,
                                                @Param("param") PermissionQueryParam queryParam);
}
