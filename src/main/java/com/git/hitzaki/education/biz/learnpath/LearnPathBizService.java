package com.git.hitzaki.education.biz.learnpath;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.learnpath.dao.IPathDetailMappingService;


import com.git.hitzaki.education.biz.learnpath.entity.LearnPathDetailEntity;
import com.git.hitzaki.education.biz.learnpath.entity.LearnPathEntity;
import com.git.hitzaki.education.biz.learnpath.entity.PathDetailMappingEntity;
import com.git.hitzaki.education.biz.learnpath.entity.PathUserMappingEntity;
import com.git.hitzaki.education.biz.learnpath.mapper.LearnPathDetailMapper;
import com.git.hitzaki.education.biz.learnpath.mapper.LearnPathMapper;
import com.git.hitzaki.education.biz.learnpath.mapper.PathUserMappingMapper;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.ILearnPathBizService;
import com.git.hitzaki.education.common.utils.AuthInfoUtils;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import com.git.hitzaki.education.model.course.vo.ProgressQueryVo;
import com.git.hitzaki.education.model.learnpath.param.PathProgressQueryParam;
import com.git.hitzaki.education.model.learnpath.vo.LearnPathDetailQueryVo;
import com.git.hitzaki.education.model.learnpath.vo.LearnPathQueryVo;
import com.git.hitzaki.education.model.learnpath.vo.PathProgressQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LearnPathBizService implements ILearnPathBizService {
    @Autowired
    private LearnPathMapper learnPathMapper;

    @Autowired
    private LearnPathDetailMapper learnPathDetailMapper;

    @Autowired
    private IPathDetailMappingService iPathDetailMappingService;

    @Autowired
    private PathUserMappingMapper pathUserMappingMapper;

    @Override
    public LearnPathQueryVo queryById(Long id) {
        //1 查询路线
        LearnPathQueryVo learnPathQueryVo = learnPathMapper.queryById(id);
        if(Objects.isNull(learnPathQueryVo)){
            throw new CommonBizException("未找到对应学习路线id="+id);
        }
        if(learnPathQueryVo.getDeleteFlag()){
            throw new CommonBizException("对应学习路线已被删除id="+id);
        }
        //2 查询明细
        List<LearnPathDetailQueryVo> detailList =  learnPathMapper.queryDetailByPathId(learnPathQueryVo.getId());

        learnPathQueryVo.setDetailList(detailList);
        //TODO 优惠规则

        return learnPathQueryVo;
    }

    @Override
    public Map<Long, List<Long>> queryCourseIdByDetailId(List<Long> detailIdList) {
        if(CollectionUtils.isEmpty(detailIdList)){
            return new HashMap<>();
        }
        List<PathDetailMappingEntity> detailMappingList =  iPathDetailMappingService.queryByDetailId(detailIdList);

        return detailMappingList.stream()
                .sorted(Comparator.comparingInt(PathDetailMappingEntity::getSort))
                .collect(Collectors.groupingBy(PathDetailMappingEntity::getId,
                        Collectors.mapping(PathDetailMappingEntity::getCourseId, Collectors.toList())));
    }

    @Override
    public PageResult<ProgressQueryVo> queryPathProgressPage(PathProgressQueryParam param) {
        Long user = AuthInfoUtils.getLoginId();
        Page<Long> page = new Page<>(param.getPageNo(),param.getPageSize());
        Page<Long> pageRes = pathUserMappingMapper.queryPathProgressIdPage(page,user);
        PageResult<Long> pathVoPage = PageResult.convert(pageRes);
        List<Long> items = pathVoPage.getItems();
        if(CollectionUtils.isEmpty(items)){
            return PageResult.empty();
        }
        return pathVoPage.convert(items.stream().map(item-> {
            ProgressQueryVo vo =new ProgressQueryVo();
            vo.setId(item);
            return vo;
        }).collect(Collectors.toList()));

    }

    @Override
    public List<PathUserMappingEntity> queryUserPathByPathId(List<Long> pathId) {
        if(CollectionUtils.isEmpty(pathId)){
            return new ArrayList<>();
        }
        Long user = AuthInfoUtils.getLoginId();
        return pathUserMappingMapper.queryPathProgressByPath(pathId,user);
    }

    @Override
    public Map<Long, String> queryPathNameById(List<Long> pathId) {
        if(CollectionUtils.isEmpty(pathId)){
            return new HashMap<>();
        }
        List<LearnPathEntity> learnPathEntities = learnPathMapper.selectBatchIds(pathId);
        return learnPathEntities.stream().collect(Collectors.toMap(LearnPathEntity::getId, LearnPathEntity::getTitle,(v1,v2)->v1));
    }

    @Override
    public List<LearnPathDetailQueryVo> queryPathDetailById(List<Long> detailId) {
        if(CollectionUtils.isEmpty(detailId)){
            return new ArrayList<>();
        }

        return learnPathDetailMapper.queryById(detailId).stream().map(LearnPathDetailQueryVo::buildVoByEntity).collect(Collectors.toList());

    }

    @Override
    public List<PathDetailMappingEntity> queryPathDetailCourseByDetailId(List<Long> detailId) {
        if(CollectionUtils.isEmpty(detailId)){
            return new ArrayList<>();
        }
        return   iPathDetailMappingService.queryByDetailId(detailId);

    }
}
