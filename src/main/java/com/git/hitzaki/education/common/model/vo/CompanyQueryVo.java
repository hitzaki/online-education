package com.git.hitzaki.education.common.model.vo;

import com.git.hitzaki.education.biz.company.entity.CompanyEntity;
import lombok.Data;

@Data
public class CompanyQueryVo {
    private Long id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 公司logo
     */
    private String logo;

    /**
     * 最小规模
     */
    private Integer minScale;

    /**
     * 最大规模
     */
    private Integer maxScale;

    /**
     * 公司类型
     */
    private Long subjectId;

    /**
     * 公司上市阶段
     */
    private Integer stage;

    public static CompanyQueryVo  of(CompanyEntity companyEntity) {
        CompanyQueryVo vo =new CompanyQueryVo();
        vo.setId(companyEntity.getId());
        vo.setLogo(companyEntity.getLogo());
        vo.setMaxScale(companyEntity.getMaxScale());
        vo.setMinScale(companyEntity.getMinScale());
        vo.setName(companyEntity.getName());
        vo.setSubjectId(companyEntity.getSubjectId());
        vo.setStage(companyEntity.getStage());
        return vo;
    }
}
