package com.git.hitzaki.education.biz.learnpath.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.git.hitzaki.education.biz.learnpath.entity.LearnPathEntity;
import com.git.hitzaki.education.model.learnpath.vo.LearnPathDetailQueryVo;
import com.git.hitzaki.education.model.learnpath.vo.LearnPathQueryVo;

import java.util.List;

/**
 * <p>
 * 学习路线 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface LearnPathMapper extends BaseMapper<LearnPathEntity> {

    LearnPathQueryVo queryById(Long id);

    List<LearnPathDetailQueryVo> queryDetailByPathId(Long id);
}
