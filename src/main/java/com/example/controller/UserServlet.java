package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/userServlet")
public class UserServlet extends HttpServlet {
    UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    /**
     * session域存储数值
     * 1.power:用户标识
     *      0-未注册用户
     *      1-学生
     *      2-老师
     *      3-管理员
     * 2.number:用户学号/工号
     *      后期根据number进行查找修改
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //1.获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        request.getSession().setAttribute("power",0);
        request.getSession().setAttribute("number","");

        //查看是否为学生

        List<User> listStudent = service.login_Student(username,password);

        //4.判读结果
        if(listStudent.size()!=0){
            //将用户名存入会话域
            request.getSession().setAttribute("power",1);
            request.getSession().setAttribute("number",username);
            //响应客户端true
            response.getWriter().write("1");
            return;
        }

        //查看是否为老师
        List<User> listTeacher = service.login_Teacher(username,password);

        //4.判读结果
        if(listTeacher.size()!=0){
            //将用户名存入会话域
            request.getSession().setAttribute("power",2);
            request.getSession().setAttribute("number",username);
            //响应客户端true
            response.getWriter().write("2");
            return;
        }

        //查看是否是是管理员

        //3.调用业务层方法
        List<User> listAdmin = service.login_Admin(username,password);

        //4.判读结果
        if(listAdmin.size()!=0){
            //将用户名存入会话域
            request.getSession().setAttribute("power",3);
            request.getSession().setAttribute("number",username);
            //响应客户端true
            response.getWriter().write("3");
            return;
        }


        response.getWriter().write("0");


    }
}
