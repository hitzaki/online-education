package com.git.hitzaki.education.biz.tag.rankservice;

import com.git.hitzaki.education.model.tag.constant.TagRankEnum;

import java.util.List;

/**
 *
 * */
public interface TagRankComputer {
    List<Long> getRank();
    TagRankEnum getKey();
}
