package com.example.mapper;

import com.example.bean.StudentProject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudentProjectMapper {
    @Select("select * from Student_Project where sp_id = #{sp_id} ")
    StudentProject selectBysp_id(StudentProject studentProject);

    @Select("select * from Student_Project where s_id=#{s_id} and p_id=#{p_id} ")
    StudentProject selectByid(StudentProject studentProject);

    @Insert("insert into  Student_Project values(null,#{s_id},#{p_id},#{rg_id},#{ig_id},#{dg_id})")
    int insertStudentProject( StudentProject studentProject);

    @Delete("delete from Student_Project where sp_id = #{sp_id}")
    int deleteStudentProject(StudentProject studentProject);

    @Update("update Student_Project set s_id=#{s_id},p_id=#{p_id},rg_id=#{rg_id},ig_id=#{ig_id},dg_id=#{dg_id} where sp_id = #{sp_id}")
    int updateStudentProject(StudentProject studentProject);
}
