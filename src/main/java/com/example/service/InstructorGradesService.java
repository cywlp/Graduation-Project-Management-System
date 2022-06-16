package com.example.service;

import com.example.bean.InstructorGrades;
import com.github.pagehelper.Page;

public interface InstructorGradesService {
    boolean addInstructorGrades(InstructorGrades instructorGrades);

    boolean deleteInstructorGrades(InstructorGrades instructorGrades);

    boolean updateInstructorGrades(InstructorGrades instructorGrades);

    Page<InstructorGrades> selectByConditions(Integer currentPage, Integer pageSize, InstructorGrades instructorGrades);

    Integer getMaxId();

    InstructorGrades selectByS_number(String s_number);
}
