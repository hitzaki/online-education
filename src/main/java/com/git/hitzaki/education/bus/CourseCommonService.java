package com.git.hitzaki.education.bus;

import com.git.hitzaki.education.biz.company.CompanyBizService;
import com.git.hitzaki.education.biz.course.CourseBizService;
import com.git.hitzaki.education.biz.station.StationBizService;
import com.git.hitzaki.education.biz.tag.TagBizService;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.model.condition.CoursePageQueryCondition;
import com.git.hitzaki.education.common.model.condition.StationPageQueryCondition;
import com.git.hitzaki.education.common.model.constant.TagRankEnum;
import com.git.hitzaki.education.common.model.constant.TagTargetTypeEnum;
import com.git.hitzaki.education.common.model.param.CoursePageQueryParam;
import com.git.hitzaki.education.common.model.param.StationPageQueryParam;
import com.git.hitzaki.education.common.model.vo.CompanyQueryVo;
import com.git.hitzaki.education.common.model.vo.CourseQueryVo;
import com.git.hitzaki.education.common.model.vo.StationQueryVo;
import com.git.hitzaki.education.common.model.vo.TagQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
