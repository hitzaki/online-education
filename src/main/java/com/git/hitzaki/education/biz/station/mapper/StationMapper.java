package com.git.hitzaki.education.biz.station.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.station.entity.StationEntity;
import com.git.hitzaki.education.model.course.condition.StationPageQueryCondition;
import com.git.hitzaki.education.model.course.vo.StationQueryVo;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * 岗位 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface StationMapper extends BaseMapper<StationEntity> {

    Page<StationQueryVo> stationPageQuery(IPage<StationQueryVo> page, @Param("condition") StationPageQueryCondition condition);
}
