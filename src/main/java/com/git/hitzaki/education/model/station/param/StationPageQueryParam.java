package com.git.hitzaki.education.model.station.param;

import com.git.hitzaki.education.common.model.PageParams;
import lombok.Data;

@Data
public class StationPageQueryParam extends PageParams {
    //搜索框内容
    private String searchText;
    //tagId
    private Long tagId;
}
