package com.git.hitzaki.education.biz.course.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.course.dao.IChapterFinishService;
import com.git.hitzaki.education.biz.course.entity.ChapterFinishEntity;
import com.git.hitzaki.education.biz.course.mapper.ChapterFinishMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ezreal
 * @since 2025-02-22
 */
@Service
public class ChapterFinishServiceImpl extends ServiceImpl<ChapterFinishMapper, ChapterFinishEntity> implements IChapterFinishService {

    @Override
    public ChapterFinishEntity getOneByEntity(ChapterFinishEntity entity) {
        LambdaQueryWrapper<ChapterFinishEntity> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(ChapterFinishEntity::getUserId,entity.getUserId());
        wrapper.eq(ChapterFinishEntity::getCourseId,entity.getCourseId());
        wrapper.eq(ChapterFinishEntity::getChapterId, entity.getChapterId());
        wrapper.eq(ChapterFinishEntity::getVideoId,entity.getVideoId());
        return getOne(wrapper);
    }
}
