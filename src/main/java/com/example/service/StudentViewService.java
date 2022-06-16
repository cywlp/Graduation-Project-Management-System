package com.example.service;

import com.example.bean.Instruction_Student;
import com.example.bean.StudentView;
import com.github.pagehelper.Page;

import java.util.List;

public interface StudentViewService {
    Page<StudentView> selectByS_number(Integer currentPage, Integer pageSize,StudentView studentView);
}
