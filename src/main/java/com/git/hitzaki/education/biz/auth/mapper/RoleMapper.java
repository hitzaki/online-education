package com.git.hitzaki.education.biz.auth.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.git.hitzaki.education.biz.auth.entity.RoleEntity;
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
}
