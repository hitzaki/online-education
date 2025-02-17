package com.git.hitzaki.education.biz.learnpath.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.learnpath.dao.IPathDetailMappingService;

import com.git.hitzaki.education.biz.learnpath.entity.PathDetailMappingEntity;
import com.git.hitzaki.education.biz.learnpath.mapper.PathDetailMappingMapper;
import com.git.hitzaki.education.common.constant.DeleteFlagConstant;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ezreal
 * @since 2025-02-15
 */
@Service
public class PathDetailMappingServiceImpl extends ServiceImpl<PathDetailMappingMapper, PathDetailMappingEntity> implements IPathDetailMappingService {

    @Override
    public List<PathDetailMappingEntity> queryByDetailId(List<Long> detailIdList) {
        LambdaQueryWrapper<PathDetailMappingEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PathDetailMappingEntity::getDeleteFlag, DeleteFlagConstant.NO_DELETE);
        wrapper.in(PathDetailMappingEntity::getPathDetailId,detailIdList);
        return list(wrapper);
    }
}
