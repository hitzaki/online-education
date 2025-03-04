package com.git.hitzaki.education.biz.course.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.git.hitzaki.education.biz.course.entity.CourseEntity;
import com.git.hitzaki.education.biz.course.model.bo.VideoCountBo;
import com.git.hitzaki.education.model.course.condition.CoursePageQueryCondition;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import com.git.hitzaki.education.model.course.vo.ProgressQueryVo;
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



    List<ProgressQueryVo> queryCourseProgressByCourse(@Param("courseIdList")List<Long> courseIdList, @Param("user")Long user);

    CourseQueryVo queryById(@Param("id")Long id);
}
