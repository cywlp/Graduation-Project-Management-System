package com.example.service;

import com.example.bean.AdminProject;
import com.github.pagehelper.Page;

public interface AdminProjectService {
    Page<AdminProject> selectByConditions(Integer currentPage, Integer pageSize, AdminProject adminProject);

    Page<AdminProject> queryAdminProject(Integer currentPage, Integer pageSize, AdminProject adminProject);

}
