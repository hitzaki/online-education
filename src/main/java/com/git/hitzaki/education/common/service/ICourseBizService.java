package com.git.hitzaki.education.common.service;

import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.course.condition.CoursePageQueryCondition;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;

import java.util.List;

public interface ICourseBizService {

    PageResult<CourseQueryVo> pageQueryCouser(CoursePageQueryCondition condition);

    List<CourseQueryVo> queryByIdList(List<Long> courseIdList);

    /**
     * 获取上次观看的课程
     * */
    CourseQueryVo queryRecently(Long user);
}
