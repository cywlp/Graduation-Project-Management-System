package com.example.service;

import com.example.bean.StudentApplication;
import com.github.pagehelper.Page;

public interface StudentApplicationService {
    Page<StudentApplication> selectByConditions(Integer currentPage, Integer pageSize, StudentApplication studentApplication);
}
