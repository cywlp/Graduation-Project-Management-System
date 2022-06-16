package com.example.mapper;

import com.example.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
    @Select("select * from Student ")
    List<Student> selectAll();
    @Select("select * from Student where s_id = #{s_id}")
    List<Student> selectByS_id(Student student);

    @Insert("insert into Student values(#{s_id},#{s_number},#{s_pwd},#{s_name},#{s_photo},#{s_major},#{s_telephone},#{s_grade},#{s_class},#{s_nation},#{s_sex},#{s_email},#{s_origin},#{s_academy},#{s_status})")
    void addStudent(Student student);

    @Delete("delete from Student where  s_number = #{s_number}")
    void deleteStudent(Student student);

    @Update("update Student set s_pwd=#{s_pwd},s_name=#{s_name},s_photo=#{s_photo},s_major=#{s_major},s_telephone=#{s_telephone},s_grade=#{s_grade},s_class=#{s_class},s_nation=#{s_nation},s_sex=#{s_sex},s_email=#{s_email},s_origin=#{s_origin},s_academy=#{s_academy},s_status=#{s_status} where  s_number = #{s_number}")
    void updateStudent(Student student);

    @Select("<script>"+
            " SELECT  * FROM  Student"
            +" <where>"
            +" <if test=' s_id != null'> s_id = #{s_id}</if>"
            +" <if test=' s_number != null '> AND s_number=#{s_number}</if>"
            +" <if test=' s_name != null '> AND s_name=#{s_name}</if>"
            +" <if test=' s_major != null '> AND s_major=#{s_major}</if>"
            +" <if test=' s_grade != null '> AND s_grade=#{s_grade}</if>"
            +" <if test=' s_class != null '> AND s_class=#{s_class}</if>"
            +" <if test=' s_sex != null '> AND s_sex=#{s_sex}</if>"
            +" <if test=' s_academy != null '> AND s_academy=#{s_academy}</if>"
            +" <if test=' s_status != null '> AND s_status=#{s_status}</if>"
            +" </where>"
            +" </script> ")
    List<Student> selectByConditions(Student student);

    @Select("select max(s_id) from Student")
    Integer getMaxId();
}
