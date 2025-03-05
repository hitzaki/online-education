package com.git.hitzaki.education.common.service;

import com.git.hitzaki.education.biz.course.entity.ChapterVideoMappingEntity;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.model.course.condition.CoursePageQueryCondition;
import com.git.hitzaki.education.model.course.param.CourseProgressUpdateParam;
import com.git.hitzaki.education.model.course.vo.ChapterQueryVo;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import com.git.hitzaki.education.model.course.vo.LastLearnQueryVo;
import com.git.hitzaki.education.model.course.vo.ProgressQueryVo;

import java.util.List;
import java.util.Map;

public interface ICourseBizService {

    PageResult<CourseQueryVo> pageQueryCouser(CoursePageQueryCondition condition);

    List<CourseQueryVo> queryByIdList(List<Long> courseIdList);

    /**
     * 获取上次观看的课程
     * */
    CourseQueryVo queryRecently(Long user);

    PageResult<CourseQueryVo> pageQueryMyCouser(CoursePageQueryCondition condition);

    /**
     * 查询课程进度
     * */
    Map<Long, ProgressQueryVo> queryCourseProgress(List<Long>  courseIdList);


    /**
     * 更新课程上次观看
     * */
    void updateCourseLastView(CourseProgressUpdateParam param);

    /**
     * 更新课程视频完成度
     * */
    void updateCourseVideoFinish(CourseProgressUpdateParam param);

    /**
     * 根据id查询课程
     * */
    CourseQueryVo queryCourseById(Long id);

    /**
     * 根据id查询课程章节
     * */
    List<ChapterQueryVo> queryCourseChapter(Long courseId);

    /**
     * 根据id查询课程章节视频
     * */
    Map<Long, List<ChapterVideoMappingEntity>> queryChapterVideoId(List<Long> chapterIdList);

    /**
     * 检查课程是否购买
     * */
    Boolean checkCourseBuy(Long courseId);

    /**
     * 检查课程上次观看
     * */
    LastLearnQueryVo queryCourseLastLearn(Long courseId);
}
