package com.git.hitzaki.education.biz.tag.rankservice.computer;

import com.git.hitzaki.education.biz.course.CourseBizService;
import com.git.hitzaki.education.biz.tag.rankservice.TagRankComputer;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.model.condition.CoursePageQueryCondition;
import com.git.hitzaki.education.common.model.constant.TagRankEnum;
import com.git.hitzaki.education.common.model.param.CoursePageQueryParam;
import com.git.hitzaki.education.common.model.vo.CourseQueryVo;
import com.git.hitzaki.education.common.model.vo.TagQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TagRankCourseComputer implements TagRankComputer {
    @Autowired
    private CourseBizService courseBizService;
    @Override
    public List<Long> getRank() {
        CoursePageQueryCondition condition =new CoursePageQueryCondition();
        PageResult<CourseQueryVo> courseQueryVoPageResult = courseBizService.pageQueryCouser(condition);
        List<CourseQueryVo> courseQueryVoList = courseQueryVoPageResult.getItems();

        Map<Long, Long> frequencyMap = courseQueryVoList.stream()
                .flatMap(user -> user.getTagList().stream().map(TagQueryVo::getId))
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
