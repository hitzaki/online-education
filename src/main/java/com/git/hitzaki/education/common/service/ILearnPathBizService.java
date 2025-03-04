package com.git.hitzaki.education.common.service;

import com.git.hitzaki.education.biz.learnpath.entity.PathDetailMappingEntity;
import com.git.hitzaki.education.biz.learnpath.entity.PathUserMappingEntity;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import com.git.hitzaki.education.model.course.vo.ProgressQueryVo;
import com.git.hitzaki.education.model.learnpath.param.PathProgressQueryParam;
import com.git.hitzaki.education.model.learnpath.vo.LearnPathDetailQueryVo;
import com.git.hitzaki.education.model.learnpath.vo.LearnPathQueryVo;
import com.git.hitzaki.education.model.learnpath.vo.PathProgressQueryVo;

import java.util.List;
import java.util.Map;

public interface ILearnPathBizService {
    LearnPathQueryVo queryById(Long id);

    Map<Long, List<Long>> queryCourseIdByDetailId(List<Long> detailIdList);

    PageResult<ProgressQueryVo> queryPathProgressPage(PathProgressQueryParam param);

    List<PathUserMappingEntity> queryUserPathByPathId(List<Long> pathId);

    Map<Long, String> queryPathNameById(List<Long> pathId);

    List<LearnPathDetailQueryVo> queryPathDetailById(List<Long> detailId);


    List<PathDetailMappingEntity> queryPathDetailCourseByDetailId(List<Long> detailId);
}
