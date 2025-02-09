package com.git.hitzaki.education.api;


import com.git.hitzaki.education.bus.StationCommonService;
import com.git.hitzaki.education.common.model.BizResult;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.course.param.StationPageQueryParam;
import com.git.hitzaki.education.model.course.vo.StationQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/station/page/query")
    public BizResult<PageResult<StationQueryVo>> stationPageQuery(@RequestBody  StationPageQueryParam param) {

        return BizResult.success(stationCommonService.stationPageQuery(param));
    }
}
