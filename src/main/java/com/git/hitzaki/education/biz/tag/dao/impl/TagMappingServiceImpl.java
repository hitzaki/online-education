package com.git.hitzaki.education.biz.tag.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.tag.entity.TagMappingEntity;
import com.git.hitzaki.education.biz.tag.mapper.TagMappingMapper;
import com.git.hitzaki.education.biz.tag.dao.ITagMappingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 标签映射表 服务实现类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Service
public class TagMappingServiceImpl extends ServiceImpl<TagMappingMapper, TagMappingEntity> implements ITagMappingService {

    @Override
    public List<TagMappingEntity> queryTagIdByTargetId(List<Long> idList, Integer type) {
        LambdaQueryWrapper<TagMappingEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(TagMappingEntity::getTargetId,idList);
        wrapper.eq(TagMappingEntity::getTargetType,type);
        return list(wrapper);
    }
}
