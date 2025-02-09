package com.git.hitzaki.education.biz.station;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.station.mapper.StationMapper;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.model.condition.StationPageQueryCondition;
import com.git.hitzaki.education.common.model.vo.StationQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationBizService {
    @Autowired
    private StationMapper stationMapper;


    public PageResult<StationQueryVo> stationPageQuery(StationPageQueryCondition condition) {
        IPage<StationQueryVo> page = new Page<>(condition.getPageNo(),condition.getPageSize());
        Page<StationQueryVo> res = stationMapper.stationPageQuery(page,condition);
        return PageResult.convert(res);
    }
}
