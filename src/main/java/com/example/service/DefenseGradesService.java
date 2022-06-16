package com.example.service;

import com.example.bean.DefenseGrades;
import com.github.pagehelper.Page;

public interface DefenseGradesService {
    Page<DefenseGrades> selectBydg_id(Integer currentPage, Integer pageSize,DefenseGrades defenseGrades);

    void insertDefensGrades(DefenseGrades defenseGrades);

    void deleteDefensGrades(DefenseGrades defenseGrades);

    void updateDefensGrades(DefenseGrades defenseGrades);

    Integer getMaxId();

    DefenseGrades selectByS_number(String s_number);

}
