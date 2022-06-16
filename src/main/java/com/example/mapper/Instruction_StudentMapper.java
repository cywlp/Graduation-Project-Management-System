package com.example.mapper;

import com.example.bean.Instruction;
import com.example.bean.Instruction_Student;
import com.example.bean.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Instruction_StudentMapper {
//    @Insert("insert into Instruction_Student  values(#{Sid},#{content},#{time})")
//    void addInstruction(Instruction_Student instruction_student);
@Select("<script>"+
        " SELECT  * FROM  Instruction_Student"
        +" <where>"
        +" <if test=' Sid != null'> Sid = #{Sid}</if>"
        +" <if test=' content != null '> AND content=#{content}</if>"
        +" <if test='content!= null'>AND `content` LIKE '%${content}%'</if>"
        +" </where>"
        +" </script> ")
    List<Instruction_Student> selectInstructionByConditions(Instruction_Student instruction_student);

@Select("<script>"+
        " SELECT  * FROM  Instruction_Student"
        +" <where>"
        +" <if test=' Sid != null'> Sid = #{Sid}</if>"
        +" <if test='content!= null'>AND `content` LIKE '%${content}%'</if>"
        +" </where>"
        +" </script> ")
    List<Instruction_Student> selectInstructionByContent(Instruction_Student instruction_student);
}
