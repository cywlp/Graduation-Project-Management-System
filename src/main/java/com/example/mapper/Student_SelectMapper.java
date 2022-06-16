package com.example.mapper;

import com.example.bean.Student_Select;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Student_SelectMapper {

    @Select({"<script>",
            " SELECT * FROM Student_Select"
                    +" <where>"
                    +" <if test='number!= null'>AND `number` LIKE '${number}%'</if>"
                    +" <if test=' id != null'> id = #{id}</if>"
                    +" <if test='name!= null'>AND `name` LIKE '%${name}%'</if>"
                    +" <if test='teacherName!= null'>AND `teacherName` LIKE '%${teacherName}%'</if>"
                    +" <if test='origin!= null'>AND `origin` LIKE '%${origin}%'</if>"
                    +" <if test='type!= null'>AND `type` LIKE '%${type}%'</if>"
                    +" </where>"
                    + "</script>"})
    Page<Student_Select> selectByConditions(Student_Select  student_select);

    @Select(" select * from Student_Select" +
            "    where number = #{number} and id not  in\n" +
            "            (select p_id from Pre_select where Pre_select.s_id =(select s_id from Student where Student_Select.number=Student.s_number))")
    Page<Student_Select> unSelect(Student_Select  student_select);

}
