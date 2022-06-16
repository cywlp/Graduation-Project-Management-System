package com.example.service;

import com.example.bean.AdminTeacher;
import com.github.pagehelper.Page;

public interface AdminTeacherService {

    Page<AdminTeacher> selectByConditions(Integer currentPage, Integer pageSize, AdminTeacher adminTeacher);

    Page<AdminTeacher> queryAdminTeacher(Integer currentPage, Integer pageSize,AdminTeacher adminTeacher);

}
