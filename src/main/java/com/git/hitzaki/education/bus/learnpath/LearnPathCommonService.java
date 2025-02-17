package com.git.hitzaki.education.bus.learnpath;

import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.service.ICourseBizService;
import com.git.hitzaki.education.common.service.ILearnPathBizService;
import com.git.hitzaki.education.common.service.ITagBizService;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import com.git.hitzaki.education.model.learnpath.param.LearnPathDetailQueryParam;
import com.git.hitzaki.education.model.learnpath.vo.LearnPathDetailQueryVo;
import com.git.hitzaki.education.model.learnpath.vo.LearnPathQueryVo;
import com.git.hitzaki.education.model.tag.constant.TagTargetTypeEnum;
import com.git.hitzaki.education.model.tag.vo.TagQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LearnPathCommonService {
    @Autowired
    private ILearnPathBizService iLearnPathBizService;

    @Autowired
    private ICourseBizService iCourseBizService;

    @Autowired
    private ITagBizService iTagBizService;

    public LearnPathQueryVo queryLearnPathDetail(LearnPathDetailQueryParam param) {
        //1 查询学习路线
        LearnPathQueryVo learnPathQueryVos = iLearnPathBizService.queryById(param.getId());

        //2 查询课程
        //明细id
        List<Long> detailIdList = learnPathQueryVos.getDetailList().stream().map(LearnPathDetailQueryVo::getId).collect(Collectors.toList());
        //查询明细关联的课程id
        Map<Long,List<Long>> courseIdMap = iLearnPathBizService.queryCourseIdByDetailId(detailIdList);
        List<Long> courseIdList = courseIdMap.values().stream()
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        List<CourseQueryVo> courseList = iCourseBizService.queryByIdList(courseIdList);

        //3 查询课程标签
        courseIdList = courseList.stream().map(CourseQueryVo::getId).collect(Collectors.toList());
        List<TagQueryVo> tagQueryVos = iTagBizService.queryTagByTargetId(courseIdList, TagTargetTypeEnum.COURSE.getK());

        //4 组装
        Map<Long, List<TagQueryVo>> tagMap = tagQueryVos.stream().collect(Collectors.groupingBy(TagQueryVo::getTargetId));
        //赋值标签信息
        courseList.forEach(item->tagMap.getOrDefault(item.getId(),new ArrayList<>()));
        //课程map
        Map<Long, CourseQueryVo> courseMap = courseList.stream().collect(Collectors.toMap(CourseQueryVo::getId, Function.identity(), (v1, v2) -> v1));
        //按照课程顺序为明细设置课程
        learnPathQueryVos.getDetailList().forEach(item->{
            List<Long> courses = courseIdMap.getOrDefault(item.getId(), new ArrayList<>());

            item.setCourseList(courses.stream().map(course->{
                CourseQueryVo courseQueryVo = courseMap.get(course);
                if(Objects.isNull(courseQueryVo)){
                    throw new CommonBizException("明细中存在不存在或者已被删除的课程");
                }
                return courseQueryVo;
            }).collect(Collectors.toList()));
        });

        return learnPathQueryVos;
    }
}
