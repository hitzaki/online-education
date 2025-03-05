package com.git.hitzaki.education.biz.auth.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.auth.entity.RoleEntity;
import com.git.hitzaki.education.biz.auth.entity.UserRoleEntity;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.auth.param.RoleQueryParam;
import com.git.hitzaki.education.model.auth.vo.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface RoleMapper extends BaseMapper<RoleEntity> {

    List<String> selectRoleByUserId(@Param("userId") Long userId);

    Page<RoleVo> rolePage(@Param("page") Page<RoleVo> page,
                                @Param("param") RoleQueryParam queryParam);

    Page<RoleVo> userRolePage(@Param("page") Page<RoleVo> page,
                                @Param("param") RoleQueryParam queryParam);

    void insertOrUpdateUserRole(@Param("param") UserRoleEntity userRoleEntity);
}
