package com.git.hitzaki.education.model.course.condition;

import com.git.hitzaki.education.common.model.PageParams;
import lombok.Data;

import java.util.List;

@Data
public class CoursePageQueryCondition extends PageParams {

    private Long userId;

    private Long recentlyId;

}
