package com.git.hitzaki.education.biz.tag.rankservice;

import com.git.hitzaki.education.common.model.constant.TagRankEnum;

import java.util.List;

/**
 *
 * */
public interface TagRankComputer {
    List<Long> getRank();
    TagRankEnum getKey();
}
