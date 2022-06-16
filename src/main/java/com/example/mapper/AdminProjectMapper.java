package com.example.mapper;

import com.example.bean.AdminProject;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminProjectMapper {
    @Select("<script>"+
            " SELECT  * FROM  AdminProject"
            +" <where>"
            +" <if test=' id != null'> id = #{id}</if>"
            +" <if test=' name != null '> AND name=#{name}</if>"
            +" <if test=' type!= null '> AND type=#{type}</if>"
            +" <if test=' teacherName!= null '> AND teacherName=#{teacherName}</if>"
            +" <if test=' grade!= null '> AND grade=#{grade}</if>"
            +" <if test=' scale!= null '> AND scale=#{scale}</if>"
            +" </where>"
            +" </script> ")
    List<AdminProject> selectByConditions(AdminProject adminProject);

    @Select({"<script>",
            " SELECT * FROM AdminProject"
                    +" <where>"
                    +" <if test='id!= null'>AND `id` LIKE '${id}%'</if>"
                    +" <if test='name!= null'>AND `name` LIKE '%${name}%'</if>"
                    +" <if test='type!= null'>AND `type` LIKE '%${type}%'</if>"
                    +" <if test='teacherName!= null'>AND `teacherName` LIKE '%${teacherName}%'</if>"
                    +" <if test='grade!= null'>AND `grade` LIKE '%${grade}%'</if>"
                    +" <if test='scale!= null'>AND `scale` LIKE '%${scale}%'</if>"
                    +" </where>"
                    + "</script>"})
    List<AdminProject> queryAdminProject(AdminProject adminProject);
}
