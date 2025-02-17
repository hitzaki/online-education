package com.git.hitzaki.education.bus.course;

import com.git.hitzaki.education.biz.company.CompanyBizService;
import com.git.hitzaki.education.biz.course.CourseBizService;
import com.git.hitzaki.education.biz.station.StationBizService;
import com.git.hitzaki.education.biz.tag.TagBizService;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.IStationBizService;
import com.git.hitzaki.education.common.utils.ListUtil;
import com.git.hitzaki.education.model.station.condition.StationPageQueryCondition;
import com.git.hitzaki.education.model.station.param.HotStationSaveOrEditParam;
import com.git.hitzaki.education.model.station.param.StationDetailQueryParam;
import com.git.hitzaki.education.model.station.param.StationSaveOrEditParam;
import com.git.hitzaki.education.model.tag.constant.TagRankEnum;
import com.git.hitzaki.education.model.tag.constant.TagTargetTypeEnum;
import com.git.hitzaki.education.model.station.param.StationPageQueryParam;
import com.git.hitzaki.education.model.course.vo.CompanyQueryVo;
import com.git.hitzaki.education.model.station.vo.StationQueryVo;
import com.git.hitzaki.education.model.tag.vo.TagQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StationCommonService {
    @Autowired
    private CourseBizService courseBizService;

    @Autowired
    private IStationBizService stationBizService;

    @Autowired
    private CompanyBizService companyBizService;

    @Autowired
    private TagBizService tagBizService;


    public PageResult<StationQueryVo> stationPageQuery(StationPageQueryParam param) {
        StationPageQueryCondition condition =  warpStationPageCondition(param);
        PageResult<StationQueryVo> stationQueryVoPageResult = stationBizService.stationPageQuery(condition);
        loadStationOtherInfo(stationQueryVoPageResult.getItems());
        return stationQueryVoPageResult;

    }


    private void loadStationOtherInfo(List<StationQueryVo> items) {
        if(CollectionUtils.isEmpty(items)){
            return;
        }
        //公司信息
        List<Long> companyIdList = items.stream().map(StationQueryVo::getCompanyId).collect(Collectors.toList());
        List<CompanyQueryVo> companyQueryVos = companyBizService.getCompanyById(companyIdList);
        Map<Long, CompanyQueryVo> companyMap = companyQueryVos.stream().collect(Collectors.toMap(CompanyQueryVo::getId, Function.identity(), (v1, v2) -> v1));
        //标签信息
        List<Long> idList = items.stream().map(StationQueryVo::getId).collect(Collectors.toList());
        List<TagQueryVo> tagList  = tagBizService.queryTagByTargetId(idList, TagTargetTypeEnum.STATION.getK());
        Map<Long, List<TagQueryVo>> tagMap = tagList.stream().collect(Collectors.groupingBy(TagQueryVo::getTargetId));

        items.forEach(item->{
            item.setCompanyQueryInfo(companyMap.get(item.getCompanyId()));
            item.setTagList(tagMap.get(item.getId()));
        });
    }

    private StationPageQueryCondition warpStationPageCondition(StationPageQueryParam param) {
        StationPageQueryCondition condition = new StationPageQueryCondition();
        condition.setTagId(param.getTagId());
        condition.setPageNo(param.getPageNo());
        condition.setPageSize(param.getPageSize());
        //处理搜索框内容
        if(Strings.isNotBlank(param.getSearchText())){
            condition.setStationName(param.getSearchText());
            List<Long> companyIdList =  companyBizService.getCompanyIdByName(param.getSearchText());
            condition.setSearchTextCompanyIdList(companyIdList);
        }
        //处理优先级
        List<Long> tagIdList = tagBizService.computeRankList(TagRankEnum.BY_MY_COURSE);
        condition.setPriorityTagList(tagIdList);
        return condition;
    }

    public List<StationQueryVo> queryHotAIStation() {

        return stationBizService.queryHotAIStation();
    }

    public StationQueryVo queryStationDetail(StationDetailQueryParam param) {
        if (Objects.isNull(param.getId())) {
            throw new CommonBizException("--");
        }
        //1 查询岗位原始信息
        StationQueryVo stationQueryVo = stationBizService.queryStationDetailById(param.getId());
        //2 标签信息
        List<TagQueryVo> tagQueryVos = tagBizService.queryTagByTargetId(ListUtil.of(stationQueryVo.getId()), TagTargetTypeEnum.STATION.getK());
        stationQueryVo.setTagList(tagQueryVos);
        //3 公司信息
        List<CompanyQueryVo> companyList = companyBizService.getCompanyById(ListUtil.of(stationQueryVo.getCompanyId()));
        stationQueryVo.setCompanyQueryInfo(CollectionUtils.isEmpty(companyList) ? null : companyList.get(0));
        return stationQueryVo;
    }


    public void saveOrEditHotAIStation(HotStationSaveOrEditParam param) {
        stationBizService.saveOrEditHotAIStation(param);
    }

    public void deleteHotAIStation(HotStationSaveOrEditParam param) {
        stationBizService.deleteHotAIStation(param);
    }
}
