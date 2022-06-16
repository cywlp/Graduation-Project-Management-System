package com.example.service;

import com.example.bean.Teacher;
import com.github.pagehelper.Page;

public interface TeacherService {
    /**
     * 1.查找
     */
    Page selectAll(Integer currentPage, Integer pageSize);

    /**
     * 根据t_id查找
     */
    Page<Teacher>  selectByT_id(Integer currentPage, Integer pageSize, Teacher teacher);


    /**
     * 增加学生
     */
    //:TODO:change
    boolean addTeacher(Teacher teacher);

    /**
     * 删除学生
     */
    void deleteTeacher(Teacher teacher);

    /**
     * 修改学生信息
     */
    void updateTeacher(Teacher teacher);
    /**
     * 条件查询
     */
    Page<Teacher> selectByConditions(Integer currentPage, Integer pageSize, Teacher teacher);



    Integer getMaxId();
}
