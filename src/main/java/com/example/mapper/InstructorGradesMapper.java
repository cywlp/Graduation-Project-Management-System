package com.example.mapper;

import com.example.bean.InstructorGrades;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface InstructorGradesMapper {
    @Insert("insert into InstructorGrades values(#{ig_id},#{ig_design},#{ig_innovation},#{ig_workload},#{ig_investigate},#{ig_information},#{ig_comprehension},#{ig_comment},#{ig_date},#{ig_sum},#{ig_agree},#{ig_person})")
    void addInstructorGrades(InstructorGrades instructorGrades);

    @Delete("delete from InstructorGrades where ig_id=#{ig_id} ")
    void deleteInstructorGrades(InstructorGrades instructorGrades);

    @Update("update InstructorGrades set ig_design=#{ig_design},ig_innovation=#{ig_innovation},ig_workload=#{ig_workload},ig_investigate=#{ig_investigate},ig_information=#{ig_information},ig_comprehension=#{ig_comprehension},ig_comment=#{ig_comment},ig_date=#{ig_date},ig_sum=#{ig_sum},ig_agree=#{ig_agree},ig_person=#{ig_person} where ig_id=#{ig_id}")
    void updateInstructorGrades(InstructorGrades instructorGrades);

    @Select({"<script>",
            " SELECT * FROM InstructorGrades"
                    +" <where>"
                    +" <if test=' ig_id != null'> ig_id = #{ig_id}</if>"
                    +"</where>"
                    + "</script>"})
    Page<InstructorGrades> selectByConditions( InstructorGrades instructorGrades);

    @Select("select max(ig_id) from InstructorGrades")
    Integer getMaxId();

    @Select("select * from InstructorGrades  where ig_id in" +
            "(select ig_id from Student_Project where s_id in" +
            "(select s_id from  Student where s_number=#{s_number}))")
    InstructorGrades selectByS_number(String s_number);
}
