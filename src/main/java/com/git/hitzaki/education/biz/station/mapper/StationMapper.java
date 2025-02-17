package com.git.hitzaki.education.biz.station.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.station.entity.StationEntity;
import com.git.hitzaki.education.model.station.condition.StationPageQueryCondition;
import com.git.hitzaki.education.model.station.vo.StationQueryVo;
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

    //TODO 优化优先级排序，考虑使用课程id进行排序 考虑去掉连表将tag拆分
    Page<StationQueryVo> stationPageQuery(IPage<StationQueryVo> page, @Param("condition") StationPageQueryCondition condition);
}
