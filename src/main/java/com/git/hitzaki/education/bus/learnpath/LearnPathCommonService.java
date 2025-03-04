package com.git.hitzaki.education.bus.learnpath;

import com.git.hitzaki.education.biz.learnpath.entity.PathDetailMappingEntity;
import com.git.hitzaki.education.biz.learnpath.entity.PathUserMappingEntity;
import com.git.hitzaki.education.common.exception.CommonBizException;
import com.git.hitzaki.education.common.model.PageResult;
import com.git.hitzaki.education.common.service.ICourseBizService;
import com.git.hitzaki.education.common.service.ILearnPathBizService;
import com.git.hitzaki.education.common.service.ITagBizService;
import com.git.hitzaki.education.common.utils.ListUtil;
import com.git.hitzaki.education.model.course.vo.CourseQueryVo;
import com.git.hitzaki.education.model.course.vo.ProgressQueryVo;
import com.git.hitzaki.education.model.learnpath.param.LearnPathDetailQueryParam;
import com.git.hitzaki.education.model.learnpath.param.PathProgressQueryParam;
import com.git.hitzaki.education.model.learnpath.vo.*;
import com.git.hitzaki.education.model.tag.constant.TagTargetTypeEnum;
import com.git.hitzaki.education.model.tag.vo.TagQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.w3c.dom.ls.LSInput;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LearnPathCommonService {
    @Autowired
    private ILearnPathBizService iLearnPathBizService;

    @Autowired
    private ICourseBizService iCourseBizService;

    @Autowired
    private ITagBizService iTagBizService;

    public LearnPathQueryVo queryLearnPathDetail(LearnPathDetailQueryParam param) {
        //1 查询学习路线
        LearnPathQueryVo learnPathQueryVos = iLearnPathBizService.queryById(param.getId());

        //2 查询课程
        //明细id
        List<Long> detailIdList = learnPathQueryVos.getDetailList().stream().map(LearnPathDetailQueryVo::getId).collect(Collectors.toList());
        //查询明细关联的课程id
        Map<Long,List<Long>> courseIdMap = iLearnPathBizService.queryCourseIdByDetailId(detailIdList);
        List<Long> courseIdList = courseIdMap.values().stream()
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        List<CourseQueryVo> courseList = iCourseBizService.queryByIdList(courseIdList);

        //3 查询课程标签
        courseIdList = courseList.stream().map(CourseQueryVo::getId).collect(Collectors.toList());
        List<TagQueryVo> tagQueryVos = iTagBizService.queryTagByTargetId(courseIdList, TagTargetTypeEnum.COURSE.getK());

        //4 组装
        Map<Long, List<TagQueryVo>> tagMap = tagQueryVos.stream().collect(Collectors.groupingBy(TagQueryVo::getTargetId));
        //赋值标签信息
        courseList.forEach(item->tagMap.getOrDefault(item.getId(),new ArrayList<>()));
        //课程map
        Map<Long, CourseQueryVo> courseMap = courseList.stream().collect(Collectors.toMap(CourseQueryVo::getId, Function.identity(), (v1, v2) -> v1));
        //按照课程顺序为明细设置课程
        learnPathQueryVos.getDetailList().forEach(item->{
            List<Long> courses = courseIdMap.getOrDefault(item.getId(), new ArrayList<>());

            item.setCourseList(courses.stream().map(course->{
                CourseQueryVo courseQueryVo = courseMap.get(course);
                if(Objects.isNull(courseQueryVo)){
                    throw new CommonBizException("明细中存在不存在或者已被删除的课程");
                }
                return courseQueryVo;
            }).collect(Collectors.toList()));
        });

        return learnPathQueryVos;
    }

    public PageResult<ProgressQueryVo> queryPathProgressPage(PathProgressQueryParam param) {
        //1 分页查询用户购买的路线id
        PageResult<ProgressQueryVo> learnPathQueryVoPageResult = iLearnPathBizService.queryPathProgressPage(param);
        List<ProgressQueryVo> items = learnPathQueryVoPageResult.getItems();
        if(CollectionUtils.isEmpty(items)){
            return PageResult.empty();
        }
        //2 查询路线全部信息
        List<Long> pathId = items.stream().map(ProgressQueryVo::getId).collect(Collectors.toList());
        List<PathUserMappingEntity> pathUserMappingEntities = iLearnPathBizService.queryUserPathByPathId(pathId);
        Map<Long,String> nameName = iLearnPathBizService.queryPathNameById(pathId);
        //3 查询课程进度
        List<Long> courseId = pathUserMappingEntities.stream().map(PathUserMappingEntity::getCourseId).distinct().collect(Collectors.toList());
        Map<Long, ProgressQueryVo> longProgressQueryVoMap = iCourseBizService.queryCourseProgress(courseId);
        //4 组装数据
        Map<Long, List<PathUserMappingEntity>> pathMap = pathUserMappingEntities.stream().collect(Collectors.groupingBy(PathUserMappingEntity::getPathId));
        items.forEach(item->{
            item.setName(nameName.get(item.getId()));
            List<PathUserMappingEntity> detailList = pathMap.get(item.getId());
            if(CollectionUtils.isEmpty(detailList)){
                return;
            }
            ProgressQueryVo progressQueryVo = new ProgressQueryVo();
            detailList.forEach(detail->{
                ProgressQueryVo courseProgress = longProgressQueryVoMap.getOrDefault(detail.getCourseId(), new ProgressQueryVo());
                progressQueryVo.add(courseProgress);
            });
        });
        return learnPathQueryVoPageResult;
    }

    public PathProgressDetailQueryVo queryPathProgressDetail(PathProgressQueryParam param) {
        if(Objects.isNull(param.getId())){
            throw new CommonBizException("请选择路线");
        }
        //1 查询购买的路线、明细、课程
        List<PathUserMappingEntity> pathUserMappingEntities = iLearnPathBizService.queryUserPathByPathId(ListUtil.of(param.getId()));
        //2 查询购买路线下课程的进度
        List<Long> courseId = pathUserMappingEntities.stream().map(PathUserMappingEntity::getCourseId).distinct().collect(Collectors.toList());
        Map<Long, ProgressQueryVo> longProgressQueryVoMap = iCourseBizService.queryCourseProgress(courseId);
        //3 根据明细分组，组装明细下课程的进度

        //查询明细
        List<Long> detailId = pathUserMappingEntities.stream().map(PathUserMappingEntity::getPathDetailId).distinct().collect(Collectors.toList());
        List<LearnPathDetailQueryVo> details= iLearnPathBizService.queryPathDetailById(detailId);
        Map<Long, String> detailMap = details.stream().collect(Collectors.toMap(LearnPathDetailQueryVo::getId, LearnPathDetailQueryVo::getTitle, (v1, v2) -> v1));

        //4 主路线
        Map<Long, String> nameMap = iLearnPathBizService.queryPathNameById(ListUtil.of(param.getId()));

        //组装
        PathProgressDetailQueryVo res= new PathProgressDetailQueryVo();
        res.setPathId(param.getId());
        res.setPathName(nameMap.get(param.getId()));


        Map<Long, List<PathUserMappingEntity>> detailIdMap = pathUserMappingEntities.stream()
                .collect(Collectors.groupingBy(PathUserMappingEntity::getPathDetailId,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream().sorted(Comparator.comparingInt(PathUserMappingEntity::getCourseSort)).collect(Collectors.toList()))));

        Map<Long, List<ProgressQueryVo>> courseProgressMap=new HashMap<>();
        detailIdMap.forEach((key, value) -> courseProgressMap.put(key, value.stream().map(one -> longProgressQueryVoMap.get(one.getCourseId())).collect(Collectors.toList())));
        List<PathProgressDetailItemQueryVo> detailProgress = pathUserMappingEntities.stream()
                .collect(Collectors.toMap(PathUserMappingEntity::getPathDetailId,
                        Function.identity(),
                        (v1, v2) -> v1))
                .values()
                .stream()
                .sorted(Comparator.comparingInt(PathUserMappingEntity::getDetailSort))
                .map(item -> {
                    PathProgressDetailItemQueryVo vo = new PathProgressDetailItemQueryVo();
                    vo.setItemId(item.getPathDetailId());
                    vo.setName(detailMap.get(vo.getItemId()));
                    vo.setCourseProgress(courseProgressMap.get(vo.getItemId()));
                    return vo;
                }).collect(Collectors.toList());
        res.setDetail(detailProgress);

        return res;
    }
}
