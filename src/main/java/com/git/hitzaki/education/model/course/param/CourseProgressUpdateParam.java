package com.git.hitzaki.education.model.course.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CourseProgressUpdateParam {
    @NotNull(message = "课程不能为空")
    @ApiModelProperty("课程id")
    private Long courseId;
    @NotNull(message = "章节不能为空")
    @ApiModelProperty("章节id")
    private Long chapterId;
    @NotNull(message = "视频i不能为空")
    @ApiModelProperty("视频id")
    private Long videoId;
    @ApiModelProperty("结束位置")
    private String progress;

}
