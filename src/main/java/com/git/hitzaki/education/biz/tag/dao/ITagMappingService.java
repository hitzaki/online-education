package com.git.hitzaki.education.biz.tag.dao;


import com.baomidou.mybatisplus.extension.service.IService;
import com.git.hitzaki.education.biz.tag.entity.TagMappingEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 标签映射表 服务类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface ITagMappingService extends IService<TagMappingEntity> {

    List<TagMappingEntity> queryTagIdByTargetId(@Param("idList") List<Long> idList, @Param("type")Integer type);

}
