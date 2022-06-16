package com.example.service;

import com.example.bean.StudentProject;

public interface StudentProjectService {
    StudentProject selectBysp_id(StudentProject studentProject);

    StudentProject selectByid(StudentProject studentProject);

    int insertStudentProject( StudentProject studentProject);

    int deleteStudentProject(StudentProject studentProject);

    int updateStudentProject(StudentProject studentProject);
}
