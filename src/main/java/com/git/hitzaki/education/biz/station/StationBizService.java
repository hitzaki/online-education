package com.git.hitzaki.education.biz.station;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.station.entity.StationEntity;
import com.git.hitzaki.education.biz.station.mapper.StationMapper;
import com.git.hitzaki.education.common.constant.RedisKeyConstant;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.IStationBizService;
import com.git.hitzaki.education.common.utils.RedisService;
import com.git.hitzaki.education.common.utils.SnowflakeIdUtil;
import com.git.hitzaki.education.model.station.condition.StationPageQueryCondition;
import com.git.hitzaki.education.model.station.param.HotStationSaveOrEditParam;
import com.git.hitzaki.education.model.station.vo.StationQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StationBizService implements IStationBizService {
    @Autowired
    private StationMapper stationMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public PageResult<StationQueryVo> stationPageQuery(StationPageQueryCondition condition) {
        IPage<StationQueryVo> page = new Page<>(condition.getPageNo(),condition.getPageSize());
        Page<StationQueryVo> res = stationMapper.stationPageQuery(page,condition);
        return PageResult.convert(res);
    }

    @Override
    public StationQueryVo queryStationDetailById(Long id) {
        StationEntity stationEntity = stationMapper.selectById(id);
        if(Objects.isNull(stationEntity) || stationEntity.getDeleteFlag()){
            throw new CommonBizException("未找到该岗位或已被删除 id="+id);
        }

        return buildVoByEntity(stationEntity);
    }

    @Override
    public List<StationQueryVo> queryHotAIStation() {
        Map<Object, Object> allStation = redisService.getAllHashFields(RedisKeyConstant.HOT_STATION);
        return allStation.values().stream().map(item-> (StationQueryVo)item).collect(Collectors.toList());
    }

    @Override
    public void saveOrEditHotAIStation(HotStationSaveOrEditParam param) {
        Long id = param.getId();
        if(Objects.isNull(id)){
            //新增
            id = SnowflakeIdUtil.getInstance().nextId();
            param.setId(id);
            redisService.setHashField(RedisKeyConstant.HOT_STATION,id.toString(),param);
        }else {
            //修改
            //TODO 锁
            Object station = redisService.getHashField(RedisKeyConstant.HOT_STATION, id.toString());
            if(Objects.isNull(station)){
                throw new CommonBizException("未找到对应岗位");
            }
            redisService.setHashField(RedisKeyConstant.HOT_STATION,id.toString(),param);
        }
    }

    @Override
    public void deleteHotAIStation(HotStationSaveOrEditParam param) {
        if(Objects.isNull(param.getId())){
            throw new CommonBizException("未找到对应岗位");
        }
        redisService.deleteHashFields(RedisKeyConstant.HOT_STATION,param.getId().toString());
    }

    private StationQueryVo buildVoByEntity(StationEntity stationEntity){
        StationQueryVo vo = new StationQueryVo();
        //TODO 高效率的bean拷贝
        vo.setId(stationEntity.getId());
        vo.setTitle(stationEntity.getTitle());
        vo.setProvince(stationEntity.getProvince());
        vo.setCity(stationEntity.getCity());
        vo.setRegion(stationEntity.getRegion());
        vo.setAddress(stationEntity.getAddress());
        vo.setMinSalary(stationEntity.getMinSalary());
        vo.setMaxSalary(stationEntity.getMaxSalary());
        vo.setMinYearLimit(stationEntity.getMinYearLimit());
        vo.setMaxYearLimit(stationEntity.getMaxYearLimit());
        vo.setSalaryStructure(stationEntity.getSalaryStructure());
        vo.setCompanyId(stationEntity.getCompanyId());
        vo.setDescription(stationEntity.getDescription());
        vo.setRequire(stationEntity.getRequire());
        vo.setAddressImage(stationEntity.getAddressImage());
        vo.setPathId(stationEntity.getPathId());
        return vo;

    }
}
