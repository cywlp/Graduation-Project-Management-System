package com.example.service;

import com.example.bean.Student;
import com.github.pagehelper.Page;

import java.util.List;

public interface StudentService {
    /**
     * 1.查找
     */
    Page selectAll(Integer currentPage, Integer pageSize);

    /**
     * 根据s_id查找
     */
    List<Student> selectByS_id(Student student);

    /**
     * 增加学生
     */
//    void addStudent(Student student);

    /**
     * 增加学生
     */
    boolean addStudent(Student student);

    /**
     * 删除学生
     */
    void deleteStudent(Student student);

    /**
     * 修改学生信息
     */
    void updateStudent(Student student);
    /**
     * 条件查询
     */
    Page<Student> selectByConditions(Integer currentPage, Integer pageSize,Student student);

    Integer getMaxId();
}
