package com.git.hitzaki.education.common.service;

import com.git.hitzaki.education.model.teacher.vo.TeacherQueryVo;

public interface ITeacherBizService {
    TeacherQueryVo queryTeacherById(Long teacher);
}
