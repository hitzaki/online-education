package com.git.hitzaki.education.biz.course.dao;


import com.baomidou.mybatisplus.extension.service.IService;
import com.git.hitzaki.education.biz.course.entity.ChapterFinishEntity;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ezreal
 * @since 2025-02-22
 */
public interface IChapterFinishService extends IService<ChapterFinishEntity> {

    ChapterFinishEntity getOneByEntity(ChapterFinishEntity entity);
}
