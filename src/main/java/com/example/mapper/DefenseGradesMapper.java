package com.example.mapper;
import com.example.bean.DefenseGrades;
import com.example.bean.InstructorGrades;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;



public interface DefenseGradesMapper {
    @Select("select * from DefenseGrades where dg_id=#{dg_id}")
    List<DefenseGrades> selectBydg_id(DefenseGrades defenseGrades);

    @Insert("insert into DefenseGrades values (#{dg_id},#{dg_innovation}, #{dg_quality},#{dg_difficulty},#{dg_verbal},#{dg_defense},#{dg_comment},#{dg_date},#{dg_person},#{dg_sum})")
    void  insertDefenseGrades(DefenseGrades defenseGrades);

    @Update("update  DefenseGrades set dg_id=#{dg_id},dg_innovation=#{dg_innovation}, dg_quality=#{dg_quality},dg_difficulty=#{dg_difficulty},dg_verbal=#{dg_verbal},dg_defense=#{dg_defense},dg_comment=#{dg_comment},dg_date=#{dg_date},dg_person=#{dg_person},dg_sum=#{dg_sum} where dg_id =#{dg_id}")
    void updateDefenseGrades(DefenseGrades defenseGrades);

    @Delete("delete from DefenseGrades where dg_id=#{dg_id}")
    void  deleteDefenseGrades(DefenseGrades defenseGrades);

    @Select("select max(dg_id) from DefenseGrades")
    Integer getMaxId();

    @Select("select * from DefenseGrades  where dg_id in" +
            "(select dg_id from Student_Project where s_id in" +
            "(select s_id from  Student where s_number=#{s_number}))")
    DefenseGrades selectByS_number(String s_number);
}
