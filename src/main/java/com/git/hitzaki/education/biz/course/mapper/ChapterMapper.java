package com.git.hitzaki.education.biz.course.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.git.hitzaki.education.biz.course.entity.ChapterEntity;
import com.git.hitzaki.education.model.course.vo.ChapterQueryVo;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 课程章节/小节 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2025-01-26
 */
public interface ChapterMapper extends BaseMapper<ChapterEntity> {

    List<ChapterQueryVo> queryCourseChapter(@Param("id") Long id);
}
