package com.example.service;

import com.example.bean.TeacherHistorySelect;
import com.github.pagehelper.Page;

public interface TeacherHistorySelectService {
    Page<TeacherHistorySelect> selectByConditions(Integer currentPage, Integer pageSize, TeacherHistorySelect teacherHistorySelect);
}
