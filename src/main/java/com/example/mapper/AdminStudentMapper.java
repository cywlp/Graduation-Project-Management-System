package com.example.mapper;

import com.example.bean.AdminStudent;
import com.example.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminStudentMapper {
    @Select("<script>"+
            " SELECT  * FROM  AdminStudent"
            +" <where>"
            +" <if test=' id != null'> id = #{id}</if>"
            +" <if test=' number != null '> AND number=#{number}</if>"
            +" <if test=' name != null '> AND name=#{name}</if>"
            +" <if test=' major != null '> AND major=#{major}</if>"
            +" <if test=' grade != null '> AND grade=#{grade}</if>"
            +" <if test=' a_class != null '> AND a_class=#{a_class}</if>"
            +" <if test=' sex != null '> AND sex=#{sex}</if>"
            +" <if test=' academy != null '> AND academy=#{academy}</if>"
            +" <if test=' status != null '> AND status=#{status}</if>"
            +" </where>"
            +" </script> ")
    List<AdminStudent > selectByConditions(AdminStudent adminstudent);

    @Select({"<script>",
            " SELECT * FROM AdminStudent"
                    +" <where>"
                    +" <if test='id!= null'>AND `id` LIKE '${id}%'</if>"
                    +" <if test='number!= null'>AND `number` LIKE '${number}%'</if>"
                    +" <if test='name!= null'>AND `name` LIKE '%${name}%'</if>"
                    +" <if test='major!= null'>AND `major` LIKE '%${major}%'</if>"
                    +" <if test='academy!= null'>AND `academy` LIKE '%${academy}%'</if>"
                    +" <if test='a_class!= null'>AND `a_class` LIKE '%${a_class}%'</if>"
                    +" </where>"
                    + "</script>"})
    List<AdminStudent> selectByConditionsPlus(AdminStudent adminstudent);
}
