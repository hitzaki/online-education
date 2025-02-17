package com.git.hitzaki.education.biz.tag.rankservice;

import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.model.tag.constant.TagRankEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class TagRankDispatcher {
    private Map<TagRankEnum,TagRankComputer> computerMap;
    @Autowired
    public TagRankDispatcher(List<TagRankComputer> computers){
        computerMap = new HashMap<>();
        computers.forEach(computer-> computerMap.put(computer.getKey(),computer));
    }

    //TODO 增加未登录状态下的查询
    public List<Long> getTagRank(TagRankEnum type){
        TagRankComputer tagRankComputer = computerMap.get(type);
        if(Objects.isNull(tagRankComputer)){
            throw new CommonBizException("获取tag排行类错误");
        }
        return tagRankComputer.getRank();
    };
}
