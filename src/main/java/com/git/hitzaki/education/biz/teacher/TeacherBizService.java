package com.git.hitzaki.education.biz.teacher;

import com.git.hitzaki.education.biz.teacher.mapper.TeacherMapper;
import com.git.hitzaki.education.common.service.ITeacherBizService;
import com.git.hitzaki.education.model.teacher.vo.TeacherQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherBizService implements ITeacherBizService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public TeacherQueryVo queryTeacherById(Long teacher) {

        return teacherMapper.queryTeacherById(teacher);
    }
}
