package com.git.hitzaki.education.biz.course.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.git.hitzaki.education.biz.course.entity.CourseEntity;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface CourseMapper extends BaseMapper<CourseEntity> {

    List<CourseQueryVo> queryByIdList(@Param("idList") List<Long> courseIdList);
}
