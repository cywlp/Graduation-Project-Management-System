package com.example.mapper;

import com.example.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from User_Admin where number=#{number} and pwd=#{pwd}")
    List<User> selectAllAdmin(User user);

    @Select("select * from User_Student where number=#{number} and pwd=#{pwd}")
    List<User> selectAllStudent(User user);

    @Select("select * from User_Teacher where number=#{number} and pwd=#{pwd}")
    List<User> selectAllTeacher(User user);
}
