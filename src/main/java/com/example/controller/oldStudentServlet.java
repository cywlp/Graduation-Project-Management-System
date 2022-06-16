package com.example.controller;

import com.example.bean.Student;
import com.example.service.StudentService;
import com.example.service.impl.StudentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "oldStudentServlet", value = "/oldStudentServlet")
public class oldStudentServlet extends HttpServlet {
    StudentService service = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取参数
        String method = request.getParameter("method");
        if(method.equals("selectByPage")){
            selectByPage(request,response);
        }
        else if(method.equals("addStu")){
            addStu(request,response);
        }else if(method.equals("updateStu")){
            updateStu(request,response);
        }else if(method.equals("deleteStu")){
            deleteStu(request,response);
        }



    }

    private void deleteStu(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        //1.获取对象
        String number = request.getParameter("number");
        //2.调用业务层
//        service.deleteStu(number);
        //3.重定向到分页
        try {
            response.sendRedirect(request.getContextPath()+"/studentServlet?method=selectByPage&currentPage="+
                    currentPage+"&pageSize="+pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateStu(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        //1.获取对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        Student student = new Student();
        System.out.println(student);//test
        //2.注册日期转换器方法
        dataConvert();
        //3.封装对象
        try {
            BeanUtils.populate(student,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用业务层
//        service.updateStu(student);
        //5.重定向到分页
        try {
            response.sendRedirect(request.getContextPath()+"/studentServlet?method=selectByPage&currentPage="+
                    currentPage+"&pageSize="+pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addStu(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        //1.获取对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        Student student = new Student();
        System.out.println(student);//test
        //2.注册日期转换器方法
        dataConvert();
        //3.封装对象
        try {
            BeanUtils.populate(student,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用业务层
//        service.addStu(student);
        //5.重定向到分页
        try {
            response.sendRedirect(request.getContextPath()+"/studentServlet?method=selectByPage&currentPage="+
                    currentPage+"&pageSize="+pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectByPage(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        //1.调用业务层方法
        Page page = service.selectAll(Integer.parseInt(currentPage), Integer.parseInt(pageSize));
        //2.封装PageInfo
        PageInfo pageInfo = new PageInfo(page);
        //3.info=>json
        try {
            String string = new ObjectMapper().writeValueAsString(pageInfo);
            response.getWriter().write(string);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 日期转换
     */
    private void dataConvert(){
        ConvertUtils.register(new Converter() {
            public Object convert(Class type,Object value){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return simpleDateFormat.parse(value.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }, Date.class);
    }
}
