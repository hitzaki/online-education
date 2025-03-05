package com.git.hitzaki.education.model.video.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VideoQueryVo {
    private Long id;
    private String title;
    private String videoUrl;
    private String videoOriginalName;
    private String videoSourceId;
    private Long playCount;
    private Long size;
    private BigDecimal duration;
    private Integer status;
}
