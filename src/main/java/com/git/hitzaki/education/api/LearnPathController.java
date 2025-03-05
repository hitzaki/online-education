package com.git.hitzaki.education.api;


import com.git.hitzaki.education.bus.learnpath.LearnPathCommonService;
import com.git.hitzaki.education.common.model.BizResult;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.course.vo.ProgressQueryVo;
import com.git.hitzaki.education.model.learnpath.param.LearnPathDetailQueryParam;
import com.git.hitzaki.education.model.learnpath.param.PathProgressQueryParam;
import com.git.hitzaki.education.model.learnpath.vo.LearnPathQueryVo;
import com.git.hitzaki.education.model.learnpath.vo.PathProgressDetailQueryVo;
import com.git.hitzaki.education.model.learnpath.vo.PathProgressQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 学习路线 前端控制器
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@RestController
@RequestMapping("/learnPath")
public class LearnPathController {

    @Autowired
    private LearnPathCommonService learnPathCommonService;

    /**
     * 学习路线详情
     */
    @PostMapping("/detail")
    public BizResult<LearnPathQueryVo> queryLearnPathDetail(@RequestBody LearnPathDetailQueryParam param) {
        return BizResult.success(learnPathCommonService.queryLearnPathDetail(param));
    }


    /**
     * 分页查询路线进度
     */
    @PostMapping("/path/progress")
    public BizResult<PageResult<ProgressQueryVo>> queryPathProgressPage(@RequestBody PathProgressQueryParam param) {
        return BizResult.success(learnPathCommonService.queryPathProgressPage(param));
    }

    /**
     * 分页查询路线进度
     */
    @PostMapping("/path/progress/detail")
    public BizResult<PathProgressDetailQueryVo> queryPathProgressDetail(@RequestBody PathProgressQueryParam param) {
        return BizResult.success(learnPathCommonService.queryPathProgressDetail(param));
    }
}
