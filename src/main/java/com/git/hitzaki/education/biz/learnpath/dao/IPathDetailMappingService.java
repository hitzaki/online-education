package com.git.hitzaki.education.biz.learnpath.dao;


import com.baomidou.mybatisplus.extension.service.IService;
import com.git.hitzaki.education.biz.learnpath.entity.PathDetailMappingEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ezreal
 * @since 2025-02-15
 */
public interface IPathDetailMappingService extends IService<PathDetailMappingEntity> {

    List<PathDetailMappingEntity> queryByDetailId(List<Long> detailIdList);
}
