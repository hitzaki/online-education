package com.git.hitzaki.education.bus;

import com.git.hitzaki.education.biz.course.CourseBizService;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.course.condition.CoursePageQueryCondition;
import com.git.hitzaki.education.model.course.param.CoursePageQueryParam;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CourseCommonService {
    @Autowired
    private CourseBizService courseBizService;


    public PageResult<CourseQueryVo> pageQueryMyCourse(CoursePageQueryParam param) {
        //TODO 需要提查询看最近学习课程的id列表
        CoursePageQueryCondition condition = new CoursePageQueryCondition();
        PageResult<CourseQueryVo> res = courseBizService.pageQueryCouser(condition);
        return null;
    }
}
