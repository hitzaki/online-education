package com.git.hitzaki.education.api;


import com.git.hitzaki.education.bus.CourseCommonService;
import com.git.hitzaki.education.common.model.BizResult;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.course.param.CoursePageQueryParam;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseCommonService courseCommonService;

    /**
     * 我的课程分页查询
     */
    @RequestMapping("/my/course/page/query")
    public BizResult<PageResult<CourseQueryVo>> pageQueryMyCourse(@RequestBody CoursePageQueryParam param) {

        return BizResult.success(courseCommonService.pageQueryMyCourse(param));
    }



    //TODO 课程详情

    //TODO 课程修改、新增

    //TODO 课程...

}
