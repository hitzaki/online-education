package com.git.hitzaki.education.biz.learnpath.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.learnpath.entity.PathUserMappingEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ezreal
 * @since 2025-02-24
 */
public interface PathUserMappingMapper extends BaseMapper<PathUserMappingEntity> {

    Page<Long> queryPathProgressIdPage(@Param("page") Page<Long> page,@Param("user")  Long user);

    List<PathUserMappingEntity> queryPathProgressByPath(@Param("pathIdList")List<Long> pathIdList, @Param("user")Long user);

}
