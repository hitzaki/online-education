package com.git.hitzaki.education.common.service;

import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import com.git.hitzaki.education.model.learnpath.vo.LearnPathQueryVo;

import java.util.List;
import java.util.Map;

public interface ILearnPathBizService {
    LearnPathQueryVo queryById(Long id);

    Map<Long, List<Long>> queryCourseIdByDetailId(List<Long> detailIdList);
}
