package com.git.hitzaki.education.model.course.vo;

import com.git.hitzaki.education.biz.video.entity.VideoEntity;
import com.git.hitzaki.education.model.video.vo.VideoQueryVo;
import lombok.Data;

import java.util.List;

@Data
public class ChapterQueryVo {
    private Long id;

    /**
     * 课程ID
     */
    private Long courseId;



    /**
     * 章节名称
     */
    private String title;

    /**
     * 显示排序
     */
    private Integer sort;

    private List<VideoQueryVo> videoList;
}
