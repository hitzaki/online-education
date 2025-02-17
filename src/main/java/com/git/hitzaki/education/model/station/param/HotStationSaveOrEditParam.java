package com.git.hitzaki.education.model.station.param;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class HotStationSaveOrEditParam {
    private Long id;

    /**
     * 岗位名
     */
    private String title;


    /**
     * 最小工资
     */
    private BigDecimal minSalary;

    /**
     * 最大工资
     */
    private BigDecimal maxSalary;

    /**
     * 学习路线
     * */
    private Long path_id;

    /**
     * 入门难度
     * */
    private String level;

    private List<String> tagList;
}
