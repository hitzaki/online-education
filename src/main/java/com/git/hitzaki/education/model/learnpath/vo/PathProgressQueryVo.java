package com.git.hitzaki.education.model.learnpath.vo;

import com.git.hitzaki.education.model.course.vo.ProgressQueryVo;
import lombok.Data;

@Data
public class PathProgressQueryVo {
    private Long pathId;
    private String pathName;
    private ProgressQueryVo progress;
}
