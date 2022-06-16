package com.example.mapper;

import com.example.bean.Instruction;
import com.example.bean.InstructionTwo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface InstructionMapper {
    @Insert("insert into Instruction  values(#{t_id},#{s_id},#{is_id},#{content},#{time},#{is_finished})")
    void addInstruction(Instruction instruction);
    //List<Instruction> addInstruction(Instruction instruction);


    @Delete("delete from Instruction where is_id = #{is_id}")
    void deleteInstruction(Instruction instruction);
    //List<Instruction> deleteInstruction(Instruction instruction);

    @Update("update Instruction set t_id=#{t_id},s_id=#{s_id},content=#{content},time=#{time},is_finished=#{is_finished} where is_id = #{is_id}")
    void updateInstruction(Instruction instruction);
    //List<Instruction> updateInstruction(Instruction instruction);

    @Update("update Instruction set is_finished=#{is_finished} where is_id=#{is_id}")
    int updateInstructionFinish(Instruction instruction);

    @Select({"<script>",
            " SELECT * FROM InstructionTwo"
                    +" <where>"
                    +" <if test=' tnumber != null'> tnumber = #{tnumber}</if>"
                    +" <if test='snumber!= null'>AND `snumber` LIKE '%${snumber}%'</if>"
                    +" <if test='time!= null'>AND `time` LIKE '%${time}%'</if>"
                    +" <if test='isFinished!= null'>AND isFinished = #{isFinished}</if>"
                    +" </where>"
                    + "</script>"})
    Page<InstructionTwo> selectInstructionTwo(InstructionTwo instructionTwo);
}
