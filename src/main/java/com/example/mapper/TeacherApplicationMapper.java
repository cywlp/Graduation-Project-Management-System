package com.example.mapper;

import com.example.bean.TeacherApplication;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;

public interface TeacherApplicationMapper {
    @Select({"<script>",
            " SELECT * FROM TeacherApplication"
                    +" <where>"
                    +" <if test=' t_id != null'> t_id = #{t_id}</if>"
                    +" <if test=' t_number != null'>AND t_number = #{t_number}</if>"
                    +" <if test=' id != null'>AND id = #{id}</if>"
                    +" <if test=' number != null'>AND number = #{number}</if>"
                    +" <if test='name!= null'>AND `name` LIKE '%${name}%'</if>"
                    +" <if test='major!= null'>AND `major` LIKE '%${major}%'</if>"
                    +" <if test='projectId!= null'>AND `projectId` LIKE '%${projectId}%'</if>"
                    +" <if test='projectName!= null'>AND `projectName` LIKE '%${projectName}%'</if>"
                    +" <if test=' status != null'>AND status = #{status}</if>"
                    +" </where>"
                    + "</script>"})
    Page<TeacherApplication> selectByConditions(TeacherApplication teacherApplication);
}
