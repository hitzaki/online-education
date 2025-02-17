package com.git.hitzaki.education.biz.course;

import com.git.hitzaki.education.biz.course.dao.ICourseService;
import com.git.hitzaki.education.biz.course.mapper.CourseMapper;
import com.git.hitzaki.education.biz.course.mapper.CourseUserMappingMapper;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.ICourseBizService;
import com.git.hitzaki.education.common.utils.ListUtil;
import com.git.hitzaki.education.model.course.condition.CoursePageQueryCondition;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseBizService implements ICourseBizService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseUserMappingMapper courseUserMappingMapper;

    @Override
    public PageResult<CourseQueryVo> pageQueryCouser(CoursePageQueryCondition condition) {

        return null;
    }

    @Override
    public List<CourseQueryVo> queryByIdList(List<Long> courseIdList) {
        if(CollectionUtils.isEmpty(courseIdList)){
            return new ArrayList<>();
        }
        return courseMapper.queryByIdList(courseIdList);
    }

    @Override
    public CourseQueryVo queryRecently(Long user) {
        Long id = courseUserMappingMapper.queryRecentlyCourseId(user);
        List<CourseQueryVo> courseQueryVos = queryByIdList(ListUtil.of(id));
        return CollectionUtils.isEmpty(courseQueryVos) ? null : courseQueryVos.get(0);
    }
}
