package com.git.hitzaki.education.model.learnpath.vo;

import com.git.hitzaki.education.model.course.vo.ProgressQueryVo;
import lombok.Data;

import java.util.List;

@Data
public class PathProgressDetailItemQueryVo {
    private Long itemId;
    private String name;
    private List<ProgressQueryVo> courseProgress;
}
