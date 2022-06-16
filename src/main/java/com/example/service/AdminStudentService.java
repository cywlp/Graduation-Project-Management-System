package com.example.service;

import com.example.bean.AdminStudent;
import com.example.bean.Student;
import com.github.pagehelper.Page;

import java.util.List;

public interface AdminStudentService {
    Page<AdminStudent> selectByConditions(Integer currentPage, Integer pageSize,AdminStudent adminstudent);

}
