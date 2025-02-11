package com.git.hitzaki.education.biz.auth.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.auth.entity.AdminAccountInfoEntity;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.auth.param.AdminQueryParam;
import com.git.hitzaki.education.model.auth.vo.AdminVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 管理员账号表 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface AdminAccountInfoMapper extends BaseMapper<AdminAccountInfoEntity> {

    PageResult<AdminVo> adminPage(@Param("page") Page<AdminVo> page,
                                  @Param("param") AdminQueryParam queryParam);
}
