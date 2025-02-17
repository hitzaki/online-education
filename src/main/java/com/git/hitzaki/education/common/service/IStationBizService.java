package com.git.hitzaki.education.common.service;

import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.station.condition.StationPageQueryCondition;
import com.git.hitzaki.education.model.station.param.HotStationSaveOrEditParam;
import com.git.hitzaki.education.model.station.vo.StationQueryVo;

import java.util.List;

public interface IStationBizService {

    PageResult<StationQueryVo> stationPageQuery(StationPageQueryCondition condition);
    StationQueryVo queryStationDetailById(Long id);

    List<StationQueryVo> queryHotAIStation();

    void saveOrEditHotAIStation(HotStationSaveOrEditParam param);

    void deleteHotAIStation(HotStationSaveOrEditParam param);
}
