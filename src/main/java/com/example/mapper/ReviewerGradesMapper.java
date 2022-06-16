package com.example.mapper;

import com.example.bean.InstructorGrades;
import com.example.bean.ReviewerGrades;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ReviewerGradesMapper {
    @Insert("insert into ReviewerGrades values(#{rg_id},#{rg_investigate},#{rg_completion},#{rg_translation},#{rg_comprehension},#{rg_innovation},#{rg_design},#{rg_comment},#{rg_date},#{rg_sum},#{rg_person})")
    void addReviewerGrades(ReviewerGrades reviewerGrades);

    @Delete("delete from ReviewerGrades where rg_id = #{rg_id}")
    void deleteReviewerGrades(ReviewerGrades reviewerGrades);

    @Update("update ReviewerGrades set  rg_investigate=#{rg_investigate},rg_completion=#{rg_completion},rg_translation=#{rg_translation},rg_comprehension=#{rg_comprehension},rg_innovation=#{rg_innovation},rg_design=#{rg_design},rg_comment=#{rg_comment},rg_date=#{rg_date},rg_sum=#{rg_sum},rg_person=#{rg_person} where rg_id=#{rg_id}")
    void updateReviewerGrades(ReviewerGrades reviewerGrades);

    @Select({"<script>",
            " SELECT * FROM ReviewerGrades"
                    +" <where>"
                    +" <if test=' rg_id != null'> rg_id = #{rg_id}</if>"
                    +"</where>"
                    + "</script>"})
    Page<ReviewerGrades> selectByConditions(ReviewerGrades reviewerGrades);

    @Select("select max(rg_id) from ReviewerGrades")
    Integer getMaxId();

    @Select("select * from  ReviewerGrades where rg_id in" +
            "(select rg_id from Student_Project where s_id in" +
            "(select s_id from  Student where s_number=#{s_number}))")
    ReviewerGrades selectByS_number(String s_number);
}
