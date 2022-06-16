package com.example.mapper;

import com.example.bean.TeacherHistorySelect;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;

public interface TeacherHistorySelectMapper {
    @Select({"<script>",
                    " SELECT * FROM TeacherHistorySelect"
                            +" <where>"
                            +" <if test=' number != null'> number = #{number}</if>"
                            +" <if test='name!= null'>AND `name` LIKE '%${name}%'</if>"
                            +" <if test='type!= null'>AND `type` LIKE '%${type}%'</if>"
                            +" <if test='grade!= null'>AND `grade` LIKE '%${grade}%'</if>"
                            +" <if test='scale!= null'>AND `scale` LIKE '%${scale}%'</if>"
                            +" </where>"
                            + "</script>"})
    Page<TeacherHistorySelect> selectByConditions( TeacherHistorySelect teacherHistorySelect);
}
