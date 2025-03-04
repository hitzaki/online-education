package com.git.hitzaki.education.biz.tag.rankservice.computer;

import com.git.hitzaki.education.biz.course.CourseBizService;
import com.git.hitzaki.education.biz.tag.rankservice.TagRankComputer;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.ICourseBizService;
import com.git.hitzaki.education.common.service.ITagBizService;
import com.git.hitzaki.education.model.course.condition.CoursePageQueryCondition;
import com.git.hitzaki.education.model.tag.constant.TagRankEnum;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import com.git.hitzaki.education.model.tag.constant.TagTargetTypeEnum;
import com.git.hitzaki.education.model.tag.vo.TagQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TagRankCourseComputer implements TagRankComputer {
    @Autowired
    private ICourseBizService courseBizService;

    @Autowired
    private ITagBizService iTagBizService;
    @Override
    public List<Long> getRank() {
        CoursePageQueryCondition condition =new CoursePageQueryCondition();
        PageResult<CourseQueryVo> courseQueryVoPageResult = courseBizService.pageQueryMyCouser(condition);
        List<CourseQueryVo> courseQueryVoList = courseQueryVoPageResult.getItems();
        if(CollectionUtils.isEmpty(courseQueryVoList)){
            return new ArrayList<>();
        }
        List<Long> tagIdList = iTagBizService.queryTagByTargetId(courseQueryVoList.stream()
                .map(CourseQueryVo::getId).collect(Collectors.toList()), TagTargetTypeEnum.COURSE.getK())
                .stream().map(TagQueryVo::getId).collect(Collectors.toList());

        Map<Long, Long> frequencyMap = tagIdList.stream()
                .collect(Collectors.groupingBy(id -> id, Collectors.counting()));

        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Long, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public TagRankEnum getKey() {
        return TagRankEnum.BY_MY_COURSE;
    }
}
