package com.git.hitzaki.education.biz.learnpath;


import com.git.hitzaki.education.biz.learnpath.dao.IPathDetailMappingService;


import com.git.hitzaki.education.biz.learnpath.entity.PathDetailMappingEntity;
import com.git.hitzaki.education.biz.learnpath.mapper.LearnPathMapper;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.service.ILearnPathBizService;
import com.git.hitzaki.education.model.learnpath.vo.LearnPathDetailQueryVo;
import com.git.hitzaki.education.model.learnpath.vo.LearnPathQueryVo;
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
    private IPathDetailMappingService iPathDetailMappingService;

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
}
