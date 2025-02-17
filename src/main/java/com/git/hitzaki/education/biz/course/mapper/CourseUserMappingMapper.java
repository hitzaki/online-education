package com.git.hitzaki.education.biz.course.mapper;

import com.git.hitzaki.education.biz.course.entity.CourseUserMappingEntity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ezreal
 * @since 2025-02-17
 */
public interface CourseUserMappingMapper extends BaseMapper<CourseUserMappingEntity> {

    Long queryRecentlyCourseId(Long user);
}
