package com.example.mapper;

import com.example.bean.FinalStudentProject;
import com.example.bean.StudentProject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FinalStudentProjectMapper {
    @Select("select * from  FinalStudentProject where projectId=#{projectId} and id=#{id}")
    List<FinalStudentProject> selectBySpid(FinalStudentProject finalStudentProject);

    @Select("select * from  FinalStudentProject where  id=#{id}")
    FinalStudentProject selectByid(FinalStudentProject finalStudentProject);

    @Select({"<script>",
            " SELECT * FROM  FinalStudentProject"
                    +" <where>"
                    +" <if test=' id != null'> id = #{id}</if>"
                    +" <if test=' t_id != null'>AND t_id = #{t_id}</if>"
                    +" <if test=' projectId != null'>AND projectId = #{projectId}</if>"
                    +" <if test='number!= null'>AND `number` LIKE '%${number}%'</if>"
                    +" <if test='t_number!= null'>AND `t_number` LIKE '%${t_number}%'</if>"
                    +" <if test='name!= null'>AND `name` LIKE '%${name}%'</if>"
                    +" <if test='major!= null'>AND `major` LIKE '%${major}%'</if>"
                    +" </where>"
                    + "</script>"})
    List<FinalStudentProject> selectBynumber(FinalStudentProject finalStudentProject);

    @Insert("insert into FinalStudentProject values (#{projectId},#{id}, #{t_id},#{t_number},#{number},#{name},#{major},#{projectName},#{ig_id},#{dg_id},#{rg_id})")
    void  insertFinalStudentProject(FinalStudentProject finalStudentProject);

    @Update("update  FinalStudentProject set rg_id=#{rg_id}, t_id=#{t_id},t_number=#{t_number},number=#{number},name=#{name},major=#{major},projectName=#{projectName},ig_id=#{ig_id},dg_id=#{dg_id},rg_id=#{rg_id} where projectId=#{projectId} and id=#{id}")
    void updateFinalStudentProject(FinalStudentProject finalStudentProject);

    @Delete("delete from Student_Project where p_id=#{p_id} and s_id=#{s_id}")
    void  deleteFinalStudentProject(StudentProject studentProject);

}
