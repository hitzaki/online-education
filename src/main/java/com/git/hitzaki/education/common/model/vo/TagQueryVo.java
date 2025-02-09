package com.git.hitzaki.education.common.model.vo;

import com.git.hitzaki.education.biz.tag.entity.CommonTagEntity;
import lombok.Data;

@Data
public class TagQueryVo {
    private Long id;
    private Long targetId;
    private String name;

}
