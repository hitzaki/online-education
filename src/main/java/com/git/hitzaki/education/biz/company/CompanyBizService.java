package com.git.hitzaki.education.biz.company;

import com.git.hitzaki.education.biz.company.dao.ICompanyService;
import com.git.hitzaki.education.biz.company.entity.CompanyEntity;
import com.git.hitzaki.education.biz.company.mapper.CompanyMapper;
import com.git.hitzaki.education.common.model.vo.CompanyQueryVo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyBizService {
    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private ICompanyService iCompanyService;


    /**
     * 根据名称模糊匹配公司id
     * */
    public List<Long> getCompanyIdByName(String name) {
        if(Strings.isBlank(name)){
            return new ArrayList<>();
        }
        List<CompanyEntity> companyEntities =  iCompanyService.getCompanyByName(name);
        return companyEntities.stream().map(CompanyEntity::getId).collect(Collectors.toList());
    }


    /**
     * 根据id查询公司
     * */
    public List<CompanyQueryVo> getCompanyById(List<Long> companyIdList) {
        if(CollectionUtils.isEmpty(companyIdList)){
            return new ArrayList<>();
        }
        List<CompanyEntity> companyEntities =  iCompanyService.getCompanyById(companyIdList);

        return companyEntities.stream().map(CompanyQueryVo::of).collect(Collectors.toList());
    }
}
