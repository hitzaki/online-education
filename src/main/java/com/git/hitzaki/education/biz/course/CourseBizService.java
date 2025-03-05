package com.git.hitzaki.education.biz.course;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.git.hitzaki.education.biz.course.dao.IChapterFinishService;
import com.git.hitzaki.education.biz.course.dao.IChapterProgressService;
import com.git.hitzaki.education.biz.course.dao.impl.ChapterProgressServiceImpl;
import com.git.hitzaki.education.biz.course.entity.*;
import com.git.hitzaki.education.biz.course.mapper.*;
import com.git.hitzaki.education.biz.course.model.bo.VideoCountBo;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.ICourseBizService;
import com.git.hitzaki.education.common.utils.AuthInfoUtils;
import com.git.hitzaki.education.common.utils.IdGenerator;
import com.git.hitzaki.education.common.utils.ListUtil;
import com.git.hitzaki.education.model.course.condition.CoursePageQueryCondition;
import com.git.hitzaki.education.model.course.param.CourseProgressUpdateParam;
import com.git.hitzaki.education.model.course.vo.ChapterQueryVo;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import com.git.hitzaki.education.model.course.vo.LastLearnQueryVo;
import com.git.hitzaki.education.model.course.vo.ProgressQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CourseBizService implements ICourseBizService {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseUserMappingMapper courseUserMappingMapper;

    @Autowired
    private ChapterFinishMapper chapterFinishMapper;

    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private IChapterProgressService iChapterProgressService;

    @Autowired
    private IChapterFinishService iChapterFinishService;

    @Autowired
    private ChapterVideoMappingMapper chapterVideoMappingMapper;

    @Override
    public PageResult<CourseQueryVo> pageQueryCouser(CoursePageQueryCondition condition) {

        return null;
    }

    @Override
    public List<CourseQueryVo> queryByIdList(List<Long> courseIdList) {
        if(CollectionUtils.isEmpty(courseIdList)){
            return new ArrayList<>();
        }
        return courseMapper.queryByIdList(courseIdList);
    }

    @Override
    public CourseQueryVo queryRecently(Long user) {
        Long id = courseUserMappingMapper.queryRecentlyCourseId(user);
        List<CourseQueryVo> courseQueryVos = queryByIdList(ListUtil.of(id));
        return CollectionUtils.isEmpty(courseQueryVos) ? null : courseQueryVos.get(0);
    }

    @Override
    public PageResult<CourseQueryVo> pageQueryMyCouser(CoursePageQueryCondition condition) {
        Page<CourseUserMappingEntity> page =new Page<>(condition.getPageNo(),condition.getPageSize());
        Page<CourseUserMappingEntity> courseUserMappingEntities = courseUserMappingMapper.pageQueryMyCouser(page, condition);
        List<CourseUserMappingEntity> records = courseUserMappingEntities.getRecords();
        List<Long> courseIdList = records.stream().map(CourseUserMappingEntity::getCourseId).collect(Collectors.toList());
        List<CourseQueryVo> courseQueryVos = courseMapper.queryByIdList(courseIdList);
        return new PageResult<>(courseQueryVos,courseUserMappingEntities.getTotal(),courseUserMappingEntities.getCurrent(),courseUserMappingEntities.getSize());
    }

    @Override
    public Map<Long, ProgressQueryVo> queryCourseProgress(List<Long> courseIdList) {
        if(CollectionUtils.isEmpty(courseIdList)){
            return new HashMap<>();
        }
        if(!AuthInfoUtils.isLogin()){
            return new HashMap<>();
        }
        Long user = AuthInfoUtils.getLoginId();

        List<ProgressQueryVo> countBos = courseMapper.queryCourseProgressByCourse(courseIdList,user);
        return countBos.stream().collect(Collectors.toMap(ProgressQueryVo::getId, Function.identity(),(v1,v2)->v1));
    }

    @Override
    public void updateCourseLastView(CourseProgressUpdateParam param) {
        ChapterProgressEntity entity = new ChapterProgressEntity();
        entity.setId(IdGenerator.generateId());
        entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());
        entity.setCourseId(param.getCourseId());
        entity.setUserId(AuthInfoUtils.getLoginId());
        entity.setVideoId(param.getVideoId());
        entity.setChapterId(param.getChapterId());
        entity.setProgress(param.getProgress());
        iChapterProgressService.saveOrUpdate(entity);

    }

    @Override
    public void updateCourseVideoFinish(CourseProgressUpdateParam param) {
        ChapterFinishEntity entity = new ChapterFinishEntity();
        entity.setCourseId(param.getCourseId());
        entity.setUserId(AuthInfoUtils.getLoginId());
        entity.setVideoId(param.getVideoId());
        entity.setChapterId(param.getChapterId());
        ChapterFinishEntity one= iChapterFinishService.getOneByEntity(entity);
        if(Objects.nonNull(one)){
            return;
        }
        entity.setId(IdGenerator.generateId());
        entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());
        iChapterFinishService.save(entity);

    }

    @Override
    public CourseQueryVo queryCourseById(Long id) {

        return courseMapper.queryById(id);
    }

    @Override
    public List<ChapterQueryVo> queryCourseChapter(Long courseId) {
        return chapterMapper.queryCourseChapter(courseId);

    }

    @Override
    public Map<Long, List<ChapterVideoMappingEntity>> queryChapterVideoId(List<Long> chapterIdList) {
        if(CollectionUtils.isEmpty(chapterIdList)){
            return new HashMap<>();
        }
        List<ChapterVideoMappingEntity> chapterVideoMappings = chapterVideoMappingMapper.queryByChapter(chapterIdList);

        return chapterVideoMappings.stream()
                .collect(Collectors.groupingBy(ChapterVideoMappingEntity::getChapterId)) // 根据id分组
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .sorted(Comparator.comparing(ChapterVideoMappingEntity::getSort)) // 对每组根据sort排序
                                .collect(Collectors.toList())
                ));
    }

    @Override
    public Boolean checkCourseBuy(Long courseId) {
        if(!AuthInfoUtils.isLogin()){
            return false;
        }
        Long loginId = AuthInfoUtils.getLoginId();
        CourseUserMappingEntity entity= courseUserMappingMapper.queryBuyCourseById(courseId,loginId);
        return Objects.nonNull(entity);
    }

    @Override
    public LastLearnQueryVo queryCourseLastLearn(Long courseId) {
        if(!AuthInfoUtils.isLogin()){
            return new LastLearnQueryVo();
        }
        ChapterProgressEntity entity= iChapterProgressService.queryLastLearn(courseId,AuthInfoUtils.getLoginId());
        if(Objects.isNull(entity)){
            return new LastLearnQueryVo();
        }
        Long courseId1 = entity.getCourseId();
        Long chapterId = entity.getChapterId();
        Long videoId = entity.getVideoId();
        String chapterVideoName = getChapterVideoName(courseId1, chapterId, videoId);

        LastLearnQueryVo vo =new LastLearnQueryVo();
        vo.setTitle(chapterVideoName);
        vo.setChapterId(chapterId);
        vo.setVideoId(videoId);
        return vo;
    }

    public String getChapterVideoName(Long course,Long chapter,Long video){
        return chapterVideoMappingMapper.getChapterVideoName(course,chapter,video);
    }
}
