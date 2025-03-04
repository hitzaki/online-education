package com.git.hitzaki.education.biz.course.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.git.hitzaki.education.biz.course.entity.ChapterFinishEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ezreal
 * @since 2025-02-22
 */
public interface ChapterFinishMapper extends BaseMapper<ChapterFinishEntity> {

    List<ChapterFinishEntity> queryFinishedVideoByCourse(@Param("courseIdList") List<Long> courseIdList,@Param("user")Long user);
}
