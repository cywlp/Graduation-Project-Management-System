package com.example.service;

import com.example.bean.User;

import java.util.List;

public interface UserService {
    /**
     * 用户登录
     * @param number
     * @param pwd
     * @return
     */
    List<User> login_Admin(String number,String pwd);
    List<User> login_Student(String number,String pwd);
    List<User> login_Teacher(String number,String pwd);
}
