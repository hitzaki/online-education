package com.git.hitzaki.education.common.service;

import com.git.hitzaki.education.model.tag.constant.TagRankEnum;
import com.git.hitzaki.education.model.tag.vo.TagQueryVo;

import java.util.List;

public interface ITagBizService {

    /**
     * 获取标签排行列表
     */
    List<Long> computeRankList(TagRankEnum type);

    /**
     * 获取标签
     */
    List<TagQueryVo> queryTagByTargetId(List<Long> idList, Integer type);
}
