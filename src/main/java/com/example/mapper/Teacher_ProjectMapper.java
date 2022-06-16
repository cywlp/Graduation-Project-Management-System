package com.example.mapper;

import com.example.bean.Teacher_Project;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Teacher_ProjectMapper {
    @Insert("insert into Teacher_Project  values(null,#{t_id},#{p_id},#{grade},#{scale})")
    int addTeacher_Project(Teacher_Project teacher_project);

    @Delete("delete from Teacher_Project where tp_id=#{tp_id}")
    int deleteTeacher_Project(Teacher_Project teacher_project);

    @Update("update Teacher_Project set t_id=#{t_id},p_id=#{p_id},grade=#{grade},scale=#{scale} where tp_id=#{tp_id}")
    int updateTeacher_Project(Teacher_Project teacher_project);

    @Select({"<script>",
            " SELECT * FROM Teacher_Project"
                    +" <where>"
                    +" <if test=' t_id != null'> t_id = #{t_id}</if>"
                    +" <if test=' p_id != null'> AND p_id = #{p_id}</if>"
                    +"</where>"
                    + "</script>"})
    Teacher_Project selectByConditions(Teacher_Project teacher_project);
}
