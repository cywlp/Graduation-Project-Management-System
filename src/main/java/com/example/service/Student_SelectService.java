package com.example.service;

import com.example.bean.Pre_select;
import com.example.bean.Student_Select;
import com.github.pagehelper.Page;

import java.util.List;

public interface Student_SelectService {
    Page<Student_Select> selectByConditions(Integer currentPage, Integer pageSize,Student_Select  student_select);

    Page<Student_Select> unSelect(Integer currentPage, Integer pageSize,Student_Select  student_select);
}
