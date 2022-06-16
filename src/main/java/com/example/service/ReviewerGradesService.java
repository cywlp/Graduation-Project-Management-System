package com.example.service;

import com.example.bean.DefenseGrades;
import com.example.bean.ReviewerGrades;
import com.github.pagehelper.Page;

public interface ReviewerGradesService {
    boolean addReviewerGrades(ReviewerGrades reviewerGrades);

    boolean deleteReviewerGrades(ReviewerGrades reviewerGrades);

    boolean updateReviewerGrades(ReviewerGrades reviewerGrades);

    Page<ReviewerGrades> selectByConditions(Integer currentPage, Integer pageSize, ReviewerGrades reviewerGrades);

    Integer getMaxId();
    ReviewerGrades selectByS_number(String s_number);
}
