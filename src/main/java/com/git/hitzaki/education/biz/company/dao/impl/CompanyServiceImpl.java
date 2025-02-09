package com.git.hitzaki.education.biz.company.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.company.entity.CompanyEntity;
import com.git.hitzaki.education.biz.company.mapper.CompanyMapper;
import com.git.hitzaki.education.biz.company.dao.ICompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, CompanyEntity> implements ICompanyService {

    @Override
    public List<CompanyEntity> getCompanyByName(String name) {
        LambdaQueryWrapper<CompanyEntity> wrapper =new LambdaQueryWrapper<>();
        wrapper.like(CompanyEntity::getName,name);
        return list(wrapper);
    }

    @Override
    public List<CompanyEntity> getCompanyById(List<Long> companyIdList) {
        return  listByIds(companyIdList);
    }
}
