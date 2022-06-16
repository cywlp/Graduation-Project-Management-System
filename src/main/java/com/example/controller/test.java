package com.example.controller;

import com.example.bean.Instruction;
import com.example.bean.InstructionTwo;
import com.example.bean.Student;
import com.example.bean.Teacher;
import com.example.service.InstructionService;
import com.example.service.Instruction_StudentService;
import com.example.service.StudentService;
import com.example.service.TeacherService;
import com.example.service.impl.InstructionServiceImpl;
import com.example.service.impl.Instruction_StudentServiceIimpl;
import com.example.service.impl.StudentServiceImpl;
import com.example.service.impl.TeacherServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.junit.Test;

public class test {
    Instruction_StudentService instruction_studentService=new Instruction_StudentServiceIimpl();
    public static void main(String[] args) {
        Student student = new Student();
        StudentService studentService = new StudentServiceImpl();
        student.setS_number("20251111");
        student.setS_name("www");
        studentService.updateStudent(student);

    }
    @Test
    public void testUpdateTeacher(){
        TeacherService service = new TeacherServiceImpl();
        Teacher teacher = new Teacher();
        teacher.setT_number("11");
        Page<Teacher> teachers = service.selectByConditions(1, 1, teacher);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
        System.out.println(pageInfo.getList().get(0));
    }
    @Test
    public void testUpdateStu(){
        StudentService service = new StudentServiceImpl();
        Student student = new Student();
        student.setS_number("2019909999");
        student.setS_id(service.getMaxId());
        student.setS_name("wangjiab");
        service.addStudent(student);
    }
    @Test
    public void testInstruction(){
        InstructionTwo instructionTwo =new InstructionTwo();
        InstructionService service = new InstructionServiceImpl();

        instructionTwo.setTnumber("11");
        instructionTwo.setIsFinished(1);
        Page<InstructionTwo> page = service.selectInstructionTwo(1,10,instructionTwo);
        PageInfo<InstructionTwo> pageInfo = new PageInfo<>(page);
        System.out.println(pageInfo.getList().size());
        for (InstructionTwo instructionTwo1 :pageInfo.getList()){
            System.out.println(instructionTwo1);
        }

    }
    @Test
    public void Test3(){
        InstructionService service = new InstructionServiceImpl();
        Instruction instruction = new Instruction();
        instruction.setS_id(2);
        instruction.setT_id(3);
        instruction.setIs_finished(1);
        int i = service.updateInstructionFinish(instruction);
        System.out.println(i);
    }


}
