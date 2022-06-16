package com.example.mapper;

import com.example.bean.Pre_select;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface Pre_selectServiceMapper {
    @Insert("insert into Pre_select  values(null,#{s_id},#{p_id},#{pre_pri},#{pre_success})")
    int addPre_select(Pre_select pre_select);

    @Delete("delete from Pre_select where pre_id=#{pre_id}")
    int deletePre_select(Pre_select pre_select);

    @Update("update Pre_select set s_id=#{s_id},p_id=#{p_id},pre_pri=#{pre_pri},pre_success=#{pre_success} where pre_id=#{pre_id}")
    int updatePre_select(Pre_select pre_select);

    @Update("update Pre_select set pre_success=#{pre_success} where s_id=#{s_id} and p_id=#{p_id}")
    int updatePre_Success(Pre_select pre_select);

    @Select({"<script>",
            " SELECT * FROM Pre_select"
                    +" <where>"
                    +" <if test=' s_id != null'> s_id = #{s_id}</if>"
                    +" <if test=' p_id != null'> AND p_id = #{p_id}</if>"
                    +"</where>"
                    + "</script>"})
    Pre_select selectByConditions(Pre_select pre_select);

    @Update("update Pre_select set pre_success=#{pre_success} where s_id=#{s_id} ")
    int updatePre_SuccessByS_id(Pre_select pre_select);

    @Update("update Pre_select set pre_success=#{pre_success} where p_id=#{p_id} ")
    int updatePre_SuccessByP_id(Pre_select pre_select);

    @Select({"<script>",
            " SELECT * FROM Pre_select"
                    +" <where>"
                    +" <if test=' s_id != null'> s_id = #{s_id}</if>"
                    +" <if test=' p_id != null'> AND p_id = #{p_id}</if>"
                    +"</where>"
                    + "</script>"})
    Page<Pre_select> countselectByConditions (Pre_select pre_select);
}
