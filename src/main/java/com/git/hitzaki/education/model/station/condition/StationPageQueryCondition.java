package com.git.hitzaki.education.model.station.condition;

import com.git.hitzaki.education.common.model.PageParams;
import lombok.Data;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Data
public class StationPageQueryCondition extends PageParams {
    //由搜索框转换来的岗位名称
    private String stationName;
    //由搜索框转换来的公司id
    private List<Long> searchTextCompanyIdList;
    private List<Long> companyIdList;
    private Long tagId;
    //标签优先级
    private List<Long> priorityTagList;

    //课程id
    private List<Long> stationIdList;
    //排序字段
    private String sortStr;

    public boolean useSearchText(){
        return Strings.isNotBlank(stationName) || !CollectionUtils.isEmpty(searchTextCompanyIdList);
    }
}
