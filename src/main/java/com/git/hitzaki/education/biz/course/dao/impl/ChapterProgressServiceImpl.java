package com.git.hitzaki.education.biz.course.dao.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.git.hitzaki.education.biz.course.dao.IChapterProgressService;
import com.git.hitzaki.education.biz.course.entity.ChapterProgressEntity;
import com.git.hitzaki.education.biz.course.mapper.ChapterProgressMapper;
import com.git.hitzaki.education.common.utils.AuthInfoUtils;
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
public class ChapterProgressServiceImpl extends ServiceImpl<ChapterProgressMapper, ChapterProgressEntity> implements IChapterProgressService {

    @Override
    public ChapterProgressEntity queryLastLearn(Long courseId,Long loginId) {
        LambdaQueryWrapper<ChapterProgressEntity> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(ChapterProgressEntity::getUserId,loginId);
        wrapper.eq(ChapterProgressEntity::getCourseId,courseId);
        return getOne(wrapper);
    }
}
