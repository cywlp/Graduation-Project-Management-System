package com.example.mapper;

import com.example.bean.Project;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProjectMapper {
    @Select("select * from Project ")
    List<Project> selectAll();
    @Select("select * from Project where p_id = #{p_id}")
    List<Project> selectByP_id(Project project);

    @Insert("insert into Project values(#{p_id},#{p_name},#{p_origin},#{p_type},#{p_content})")
    int addProject(Project project);

    @Delete("delete from Project where p_id = #{p_id}")
    int deleteProject(Project project);

    @Update("update Project set p_name=#{p_name},p_origin=#{p_origin},p_type=#{p_type},p_content=#{p_content} where p_id = #{p_id}")
    int updateProject(Project project);

    @Select("<script>"+
            " SELECT  * FROM  Project"
            +" <where>"
            +" <if test=' p_id != null'> p_id = #{p_id}</if>"
            +" <if test=' p_name != null '> AND p_name=#{p_name}</if>"
            +" <if test=' p_type != null '> AND p_type=#{p_type}</if>"
            +" </where>"
            +" </script> ")
    List<Project> selectByConditions(Project project);

    @Select("select max(p_id) from Project")
    Integer getMaxId();

}
