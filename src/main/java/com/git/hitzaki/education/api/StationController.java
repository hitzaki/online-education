package com.git.hitzaki.education.api;


import com.git.hitzaki.education.bus.course.StationCommonService;
import com.git.hitzaki.education.common.model.BizResult;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.station.param.HotStationSaveOrEditParam;
import com.git.hitzaki.education.model.station.param.StationDetailQueryParam;
import com.git.hitzaki.education.model.station.param.StationPageQueryParam;
import com.git.hitzaki.education.model.station.param.StationSaveOrEditParam;
import com.git.hitzaki.education.model.station.vo.StationQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 岗位 前端控制器
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@RestController
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationCommonService stationCommonService;

    /**
     * 首页岗位列表
     */
    @PostMapping("/page/query")
    public BizResult<PageResult<StationQueryVo>> stationPageQuery(@RequestBody  StationPageQueryParam param) {

        return BizResult.success(stationCommonService.stationPageQuery(param));
    }

    /**
     * 首页热门ai岗位
     */
    @PostMapping("/hot")
    public BizResult<List<StationQueryVo>> hotAIStation() {

        return BizResult.success(stationCommonService.queryHotAIStation());
    }

    /**
     * 编辑热门ai岗位
     */
    @PostMapping("saveOrEdit/hot")
    public BizResult<?> saveOrEditHotAIStation(@RequestBody HotStationSaveOrEditParam param) {
        stationCommonService.saveOrEditHotAIStation(param);
        return BizResult.success();
    }

    /**
     * 删除热门ai岗位
     */
    @PostMapping("delete/hot")
    public BizResult<?> deleteHotAIStation(@RequestBody HotStationSaveOrEditParam param) {
        stationCommonService.deleteHotAIStation(param);
        return BizResult.success();
    }

    /**
     * 岗位详情
     */
    @PostMapping("/detail")
    public BizResult<StationQueryVo> queryStationDetail(@RequestBody StationDetailQueryParam param) {
        return BizResult.success(stationCommonService.queryStationDetail(param));
    }
}
