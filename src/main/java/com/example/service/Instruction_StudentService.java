package com.example.service;

import com.example.bean.Instruction_Student;
import com.github.pagehelper.Page;

public interface Instruction_StudentService {
//    void addInstruction(Instruction_Student instruction_student);
    Page<Instruction_Student> selectInstructionByContent(Integer currentPage, Integer pageSize,Instruction_Student instruction_student);
    Page<Instruction_Student> selectInstructionByConditions(Integer currentPage, Integer pageSize,Instruction_Student instruction_student);
}
