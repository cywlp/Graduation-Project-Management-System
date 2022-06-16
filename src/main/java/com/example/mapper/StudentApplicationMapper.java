package com.example.mapper;

import com.example.bean.StudentApplication;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;

public interface StudentApplicationMapper {
    @Select({"<script>",
            " SELECT * FROM StudentApplication"
                    +" <where>"
                    +" <if test=' number != null'> number = #{number}</if>"
                    +" <if test=' projectId != null'> AND projectId = #{projectId}</if>"
                    +" <if test=' status != null'> AND status = #{status}</if>"
                    +" <if test='projectName!= null'>AND `projectName` LIKE '%${projectName}%'</if>"
                    +"</where>"
                    + "</script>"})
    Page<StudentApplication> selectByConditions(StudentApplication studentApplication);
}
