package com.git.hitzaki.education.biz.learnpath.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.git.hitzaki.education.biz.learnpath.entity.LearnPathDetailEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 学习路线明细表 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface LearnPathDetailMapper extends BaseMapper<LearnPathDetailEntity> {

    List<LearnPathDetailEntity> queryById(@Param("detailId") List<Long> detailId);
}
