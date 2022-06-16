package com.example.mapper;

import com.example.bean.AdminTeacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminTeacherMapper {
    @Select("<script>"+
            " SELECT  * FROM  AdminTeacher"
            +" <where>"
            +" <if test=' id != null'> id = #{id}</if>"
            +" <if test=' number != null '> AND number=#{number}</if>"
            +" <if test=' name != null '> AND name=#{name}</if>"
            +" <if test=' sex != null '> AND sex=#{sex}</if>"
            +" <if test=' academy != null '> AND academy=#{academy}</if>"
            +" </where>"
            +" </script> ")
    List<AdminTeacher> selectByConditions(AdminTeacher adminTeacher);

    @Select({"<script>",
            " SELECT * FROM AdminTeacher"
                    +" <where>"
                    +" <if test='id!= null'>AND `id` LIKE '${id}%'</if>"
                    +" <if test='number!= null'>AND `number` LIKE '%${number}%'</if>"
                    +" <if test='name!= null'>AND `name` LIKE '%${name}%'</if>"
                    +" <if test='academy!= null'>AND `academy` LIKE '%${academy}%'</if>"
                    +" </where>"
                    + "</script>"})
    List<AdminTeacher> queryAdminTeacher(AdminTeacher adminTeacher);
}
