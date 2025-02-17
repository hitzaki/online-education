package com.git.hitzaki.education.bus.course;

import com.git.hitzaki.education.biz.course.CourseBizService;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.ICourseBizService;
import com.git.hitzaki.education.model.course.condition.CoursePageQueryCondition;
import com.git.hitzaki.education.model.course.param.CoursePageQueryParam;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class CourseCommonService {
    @Autowired
    private ICourseBizService courseBizService;


    public PageResult<CourseQueryVo> pageQueryMyCourse(CoursePageQueryParam param) {

        CoursePageQueryCondition condition = warpCoursePageQueryCondition(param);
        PageResult<CourseQueryVo> res = courseBizService.pageQueryCouser(condition);
        return null;
    }

    private CoursePageQueryCondition warpCoursePageQueryCondition(CoursePageQueryParam param) {
        //TODO 当前登录用户
        Long user = 0L;

        CourseQueryVo courseQueryVo =  courseBizService.queryRecently(user);
        CoursePageQueryCondition condition = new CoursePageQueryCondition();
        condition.setPageNo(param.getPageNo());
        condition.setPageSize(param.getPageSize());
        condition.setUserId(user);
        if(!Objects.isNull(courseQueryVo)){
            condition.setRecentlyId(courseQueryVo.getId());
        }

        return condition;
    }

    public PageResult<CourseQueryVo> pageQueryCollectCourse(CoursePageQueryParam param) {
        return null;
    }
}
