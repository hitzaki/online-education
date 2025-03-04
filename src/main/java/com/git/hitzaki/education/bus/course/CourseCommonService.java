package com.git.hitzaki.education.bus.course;

import com.git.hitzaki.education.biz.course.CourseBizService;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.ICourseBizService;
import com.git.hitzaki.education.common.service.ITagBizService;
import com.git.hitzaki.education.common.service.ITeacherBizService;
import com.git.hitzaki.education.common.utils.AuthInfoUtils;
import com.git.hitzaki.education.common.utils.ListUtil;
import com.git.hitzaki.education.model.course.condition.CoursePageQueryCondition;
import com.git.hitzaki.education.model.course.param.CourseDetailQueryParam;
import com.git.hitzaki.education.model.course.param.CoursePageQueryParam;
import com.git.hitzaki.education.model.course.param.CourseProgressUpdateParam;
import com.git.hitzaki.education.model.course.vo.ChapterQueryVo;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import com.git.hitzaki.education.model.course.vo.ProgressQueryVo;
import com.git.hitzaki.education.model.tag.constant.TagTargetTypeEnum;
import com.git.hitzaki.education.model.tag.vo.TagQueryVo;
import com.git.hitzaki.education.model.teacher.vo.TeacherQueryVo;
import com.git.hitzaki.education.model.video.vo.VideoQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CourseCommonService {
    @Autowired
    private ICourseBizService courseBizService;
    @Autowired
    private Executor taskExecutor;
    @Autowired
    private ITagBizService iTagBizService;
    @Autowired
    private ITeacherBizService iTeacherBizService;


    public PageResult<CourseQueryVo> pageQueryMyCourse(CoursePageQueryParam param) {

        CoursePageQueryCondition condition = warpCoursePageQueryCondition(param);
        PageResult<CourseQueryVo> res = courseBizService.pageQueryMyCouser(condition);

        return res;
    }

    private CoursePageQueryCondition warpCoursePageQueryCondition(CoursePageQueryParam param) {
        Long user = AuthInfoUtils.getLoginId();

        CoursePageQueryCondition condition = new CoursePageQueryCondition();
        condition.setPageNo(param.getPageNo());
        condition.setPageSize(param.getPageSize());
        condition.setUserId(user);

        return condition;
    }

    public PageResult<CourseQueryVo> pageQueryCollectCourse(CoursePageQueryParam param) {
        return null;
    }

    public void updateCourseLastView(CourseProgressUpdateParam param) {
        if(StringUtils.isBlank(param.getProgress())){
            throw new CommonBizException("缺少进度");
        }
        courseBizService.updateCourseLastView(param);
    }

    public void updateCourseVideoFinish(CourseProgressUpdateParam param) {
        courseBizService.updateCourseVideoFinish(param);
    }

    public CourseQueryVo queryCourseDetail(CourseDetailQueryParam param) {
        //1 查询课程基础信息
        CourseQueryVo courseQueryVo=courseBizService.queryCourseById(param.getId());
        if(Objects.isNull(courseQueryVo)){
            throw new CommonBizException("未找到该课程或者已被删除");
        }
        Long id = courseQueryVo.getId();
        //2 查询标签信息
        CompletableFuture<List<TagQueryVo>> tagFuture = CompletableFuture.supplyAsync(() -> queryCourseTag(id),taskExecutor);
        //3 查询教师信息
        CompletableFuture<TeacherQueryVo> teacherFuture = CompletableFuture.supplyAsync(() -> queryCourseTeacher(courseQueryVo.getTeacherId()),taskExecutor);
        //4 查询进度
        CompletableFuture<ProgressQueryVo> progressFuture = CompletableFuture.supplyAsync(() -> queryCourseProgress(id),taskExecutor);
        //5 查询章节
        CompletableFuture<List<ChapterQueryVo>> chapterFuture = CompletableFuture.supplyAsync(() -> queryCourseChapter(id),taskExecutor);
        //6 查询是否购买
        CompletableFuture<Boolean> buyFuture = CompletableFuture.supplyAsync(() -> checkCourseBuy(id),taskExecutor);
        //7 查询上次学习
        CompletableFuture<String> lastLearnFuture = CompletableFuture.supplyAsync(() -> queryCourseLastLearn(id),taskExecutor);
        CompletableFuture<Void> combinedFuture  = CompletableFuture.allOf(tagFuture, teacherFuture, progressFuture, chapterFuture, buyFuture, lastLearnFuture);
        try {
            combinedFuture.get();
            //组装数据
            List<TagQueryVo> tagList = tagFuture.join();
            TeacherQueryVo teacher = teacherFuture.join();
            ProgressQueryVo progress = progressFuture.join();
            List<ChapterQueryVo> chapterList = chapterFuture.join();
            Boolean isBuy = buyFuture.join();
            String lastLearn = lastLearnFuture.join();
            courseQueryVo.setTagList(tagList);
            courseQueryVo.setTeacherInfo(teacher);
            courseQueryVo.setProgress(progress);
            courseQueryVo.setChapterList(chapterList);
            courseQueryVo.setHasBuy(isBuy);
            courseQueryVo.setLastLearn(lastLearn);
            return courseQueryVo;
        } catch (Exception e) {
            e.printStackTrace();
        }

       throw new CommonBizException("课程查询异常");
    }


    private String queryCourseLastLearn(Long courseId) {
        return null;
    }

    private Boolean checkCourseBuy(Long courseId) {
        return null;
    }

    public List<TagQueryVo> queryCourseTag(Long courseId) {
        return iTagBizService.queryTagByTargetId(ListUtil.of(courseId), TagTargetTypeEnum.COURSE.getK());
    }

    public TeacherQueryVo queryCourseTeacher(Long teacher) {
        return iTeacherBizService.queryTeacherById(teacher);
    }
    public ProgressQueryVo queryCourseProgress(Long courseId) {
        Map<Long, ProgressQueryVo> longProgressQueryVoMap = courseBizService.queryCourseProgress(ListUtil.of(courseId));
        return longProgressQueryVoMap.get(courseId);
    }
    public List<ChapterQueryVo> queryCourseChapter(Long courseId) {
        List<ChapterQueryVo> chapterQueryVos = courseBizService.queryCourseChapter(courseId);
        List<Long> chapterIdList = chapterQueryVos.stream().map(ChapterQueryVo::getId).collect(Collectors.toList());
        Map<Long,List<Long>> videoIdMap=courseBizService.queryChapterVideoId(chapterIdList);

        //todo 视频
        List<VideoQueryVo> videoList = new ArrayList<>();
        Map<Long, VideoQueryVo> videoMap = videoList.stream().collect(Collectors.toMap(VideoQueryVo::getId, Function.identity(), (v1, v2) -> v1));

        chapterQueryVos.forEach(item->{
            List<Long> videoIdList = videoIdMap.getOrDefault(item.getCourseId(),new ArrayList<>());
            List<VideoQueryVo> videoQueryVos = videoIdList.stream().map(video -> {
                VideoQueryVo videoQueryVo = videoMap.get(video);
                if (Objects.isNull(video)) {
                    throw new CommonBizException("查询为查询到视频的章节");
                }
                return videoQueryVo;
            }).collect(Collectors.toList());
            item.setVideoList(videoQueryVos);
        });
        return chapterQueryVos;
    }
}
