package com.git.hitzaki.education.model.learnpath.vo;

import com.git.hitzaki.education.model.course.vo.ProgressQueryVo;
import lombok.Data;

import java.util.List;

@Data
public class PathProgressDetailQueryVo {
    private Long pathId;
    private String pathName;
    private List<PathProgressDetailItemQueryVo> detail;
}
