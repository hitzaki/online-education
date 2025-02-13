package com.git.hitzaki.education.biz.auth.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.auth.entity.UserInfoEntity;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.auth.param.UserQueryParam;
import com.git.hitzaki.education.model.auth.vo.UserVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户个人信息表 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface UserInfoMapper extends BaseMapper<UserInfoEntity> {

    Page<UserVo> userPage(@Param("page") Page<UserVo> page,
                                @Param("param") UserQueryParam queryParam);
}
