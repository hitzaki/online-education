package com.git.hitzaki.education.biz.course.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.course.entity.CourseUserMappingEntity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.git.hitzaki.education.model.course.condition.CoursePageQueryCondition;
import org.springframework.data.repository.query.Param;

import java.util.List;

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


    Page<CourseUserMappingEntity> pageQueryMyCouser(@Param("page") Page<CourseUserMappingEntity> page, @Param("condition")CoursePageQueryCondition condition);

    CourseUserMappingEntity queryBuyCourseById(@Param("courseId")Long courseId, @Param("user")Long user);
}
