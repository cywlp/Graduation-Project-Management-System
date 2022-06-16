package com.example.service;

import com.example.bean.Teacher_Project;

public interface Teacher_ProjectService {
    int addTeacher_Project(Teacher_Project teacher_project);

    int deleteTeacher_Project(Teacher_Project teacher_project);

    int updateTeacher_Project(Teacher_Project teacher_project);

    Teacher_Project selectByConditions(Teacher_Project teacher_project);
}
