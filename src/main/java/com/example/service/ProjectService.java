package com.example.service;

import com.example.bean.Project;
import com.github.pagehelper.Page;

public interface ProjectService {
    /**
     * 1.查找
     */
    Page selectAll(Integer currentPage, Integer pageSize);

    /**
     * 根据p_id查找
     */
    Page<Project> selectByP_id(Integer currentPage, Integer pageSize, Project project);

    /**
     * 增加题目
     */
    int addProject(Project project);

    /**
     * 删除题目
     */
    int deleteProject(Project project);

    /**
     * 修改题目
     */
    int updateProject(Project project);
    /**
     * 条件查询
     */
    Page<Project> selectByConditions(Integer currentPage, Integer pageSize,Project project);

    Integer getMaxId();
}
