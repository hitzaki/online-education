package com.git.hitzaki.education.biz.tag;

import com.git.hitzaki.education.biz.tag.dao.ICommonTagService;
import com.git.hitzaki.education.biz.tag.dao.ITagMappingService;
import com.git.hitzaki.education.biz.tag.entity.CommonTagEntity;
import com.git.hitzaki.education.biz.tag.entity.TagMappingEntity;
import com.git.hitzaki.education.biz.tag.mapper.CommonTagMapper;
import com.git.hitzaki.education.biz.tag.mapper.TagMappingMapper;
import com.git.hitzaki.education.biz.tag.rankservice.TagRankDispatcher;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.service.ITagBizService;
import com.git.hitzaki.education.model.tag.constant.TagRankEnum;
import com.git.hitzaki.education.model.tag.vo.TagQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TagBizService implements ITagBizService {
    @Autowired
    private TagRankDispatcher tagRankDispatcher;
    @Autowired
    private CommonTagMapper commonTagMapper;

    @Autowired
    private TagMappingMapper tagMappingMapper;

    @Autowired
    private ITagMappingService iTagMappingService;

    @Autowired
    private ICommonTagService iCommonTagService;

    @Override
    public List<Long> computeRankList(TagRankEnum type) {
        return tagRankDispatcher.getTagRank(type);
    }


    @Override
    public List<TagQueryVo> queryTagByTargetId(List<Long> idList, Integer type) {
        if(CollectionUtils.isEmpty(idList)){
            return new ArrayList<>();
        }
        if(Objects.isNull(type)){
            throw  new CommonBizException("查询标签类型为空");
        }

        List<TagMappingEntity> mappingEntities = iTagMappingService.queryTagIdByTargetId(idList,type);
        if(CollectionUtils.isEmpty(mappingEntities)){
            return new ArrayList<>();
        }
        List<CommonTagEntity> commonTagEntities = iCommonTagService.listByIds(mappingEntities.stream().map(TagMappingEntity::getTagId).collect(Collectors.toList()));
        Map<Long, String> tagMap = commonTagEntities.stream().collect(Collectors.toMap(CommonTagEntity::getId, CommonTagEntity::getTitle, (v1, v2) -> v1));

        return mappingEntities.stream().map(tag -> {
            TagQueryVo vo =new TagQueryVo();
            vo.setId(tag.getTagId());
            vo.setTargetId(tag.getTargetId());
            vo.setName(tagMap.get(vo.getId()));
            return vo;
        }).collect(Collectors.toList());

    }
}
