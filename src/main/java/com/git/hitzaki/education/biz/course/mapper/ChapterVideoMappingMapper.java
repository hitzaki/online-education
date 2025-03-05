package com.git.hitzaki.education.biz.course.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.git.hitzaki.education.biz.course.entity.ChapterVideoMappingEntity;
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
public interface ChapterVideoMappingMapper extends BaseMapper<ChapterVideoMappingEntity> {

    List<ChapterVideoMappingEntity> queryByChapter(@Param("chapterIdList") List<Long> chapterIdList);

    String getChapterVideoName(@Param("course")Long course, @Param("chapter")Long chapter,@Param("video") Long video);
}
