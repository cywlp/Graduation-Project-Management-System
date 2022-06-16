package com.example.mapper;

import com.example.bean.AdminTeacher;
import com.example.bean.StudentView;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentViewMapper {
    @Select({"<script>",
            " SELECT * FROM StudentView"
                    +" <where>"
                    +" <if test=' s_id != null'> s_id = #{s_id}</if>"
                    +" <if test=' t_id != null'> t_id = #{t_id}</if>"
                    +" <if test=' p_id != null'> p_id = #{p_id}</if>"
                    +" <if test='s_number!= null'>AND `s_number` LIKE '%${s_number}%'</if>"
                    +" <if test='t_number!= null'>AND `t_number` LIKE '%${t_number}%'</if>"
                    +" <if test='s_name!= null'>AND `s_name` LIKE '%${s_name}%'</if>"
                    +" <if test='p_name!= null'>AND `p_name` LIKE '%${p_name}%'</if>"
                    +" <if test='s_major!= null'>AND `s_major` LIKE '%${s_major}%'</if>"
                    +" </where>"
                    + "</script>"})
    List<StudentView> selectByS_number(StudentView studentView);
}
