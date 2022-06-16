package com.example.mapper;

import com.example.bean.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from Teacher ")
    List<Teacher> selectAll();

    @Select("select * from Teacher where t_id = #{t_id}")
    List<Teacher> selectByT_id(Teacher teacher);

    @Insert("insert into Teacher values(#{t_id},#{t_number},#{t_pwd},#{t_name},#{t_photo},#{t_telephone},#{t_nation},#{t_sex},#{t_email},#{t_origin},#{t_academy})")
    void addTeacher(Teacher teacher);

    @Delete("delete from Teacher where t_number = #{t_number}")
    void deleteTeacher(Teacher teacher);

    @Update("update Teacher set t_pwd=#{t_pwd},t_name=#{t_name},t_photo=#{t_photo},t_telephone=#{t_telephone},t_nation=#{t_nation},t_sex=#{t_sex},t_email=#{t_email},t_origin=#{t_origin},t_academy=#{t_academy} where t_number = #{t_number}")
    void updateTeacher(Teacher teacher);

    @Select("<script>"+
            " SELECT  * FROM  Teacher"
            +" <where>"
            +" <if test=' t_id != null'> t_id = #{t_id}</if>"
            +" <if test=' t_number != null '> AND t_number=#{t_number}</if>"
            +" <if test=' t_name != null '> AND t_name=#{t_name}</if>"
            +" <if test=' t_sex != null '> AND t_sex=#{t_sex}</if>"
            +" <if test=' t_academy != null '> AND t_academy=#{t_academy}</if>"
            +" </where>"
            +" </script> ")
    List<Teacher> selectByConditions(Teacher teacher);

    @Select("select max(t_id) from Teacher")
    Integer getMaxId();
}
