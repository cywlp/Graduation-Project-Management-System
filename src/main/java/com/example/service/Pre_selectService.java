package com.example.service;

import com.example.bean.Pre_select;
import com.github.pagehelper.Page;

import java.util.List;

public interface Pre_selectService {
    int addPre_select(Pre_select pre_select);

    int deletePre_select(Pre_select pre_select);

    int updatePre_select(Pre_select pre_select);

    boolean agreeApply (Integer s_id,Integer p_id);

    Pre_select selectByConditions(Pre_select pre_select);

    Page<Pre_select> countselectByConditions (Integer currentPage, Integer pageSize,Pre_select pre_select);
}
