package com.git.hitzaki.education.biz.teacher.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.git.hitzaki.education.biz.teacher.entity.TeacherEntity;
import com.git.hitzaki.education.model.teacher.vo.TeacherQueryVo;
import org.springframework.data.repository.query.Param;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface TeacherMapper extends BaseMapper<TeacherEntity> {

    TeacherQueryVo queryTeacherById(@Param("id") Long id);
}
