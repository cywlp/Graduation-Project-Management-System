package com.example.service;

import com.example.bean.TeacherApplication;
import com.github.pagehelper.Page;

public interface TeacherApplicationService {
    public Page<TeacherApplication> selectByConditions(Integer currentPage, Integer pageSize, TeacherApplication teacherApplication);
}
