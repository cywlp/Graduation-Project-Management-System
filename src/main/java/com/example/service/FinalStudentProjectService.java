package com.example.service;

import com.example.bean.DefenseGrades;
import com.example.bean.FinalStudentProject;
import com.example.bean.StudentProject;
import com.github.pagehelper.Page;

import java.util.List;

public interface FinalStudentProjectService {
    Page<FinalStudentProject> selectBySp_id(Integer currentPage, Integer pageSize, FinalStudentProject finalStudentProject);

    FinalStudentProject selectByid(FinalStudentProject finalStudentProject);

    Page<FinalStudentProject> selectBynumber(Integer currentPage, Integer pageSize, FinalStudentProject finalStudentProject);

    void  insertFinalStudentProject(FinalStudentProject finalStudentProject);

    void updateFinalStudentProject(FinalStudentProject finalStudentProject);

    void  deleteFinalStudentProject(StudentProject studentProject);
}
