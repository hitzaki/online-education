package com.git.hitzaki.education.biz.company.dao;


import com.baomidou.mybatisplus.extension.service.IService;
import com.git.hitzaki.education.biz.company.entity.CompanyEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface ICompanyService extends IService<CompanyEntity> {

    List<CompanyEntity> getCompanyByName(String name);

    List<CompanyEntity> getCompanyById(List<Long> companyIdList);
}
