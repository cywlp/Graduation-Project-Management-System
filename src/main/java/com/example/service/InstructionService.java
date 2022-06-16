package com.example.service;


import com.example.bean.Instruction;
import com.example.bean.InstructionTwo;
import com.github.pagehelper.Page;

public interface InstructionService {
    //Page<Instruction> addInstruction(Integer currentPage, Integer pageSize, Instruction instruction);
    void  addInstruction(Instruction instruction);
    //Page<Instruction> deleteInstruction(Integer currentPage, Integer pageSize,Instruction instruction);
    void deleteInstruction(Instruction instruction);
    //Page<Instruction> updateInstruction(Integer currentPage, Integer pageSize, Instruction instruction);
    void updateInstruction(Instruction instruction);

    Page<InstructionTwo> selectInstructionTwo( Integer currentPage, Integer pageSize,  InstructionTwo instructionTwo);

    int updateInstructionFinish(Instruction instruction);
}
