package com.example.controller;

import com.example.bean.AdminProject;
import com.example.bean.AdminStudent;
import com.example.service.AdminProjectService;
import com.example.service.impl.AdminProjectServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet(name = "AdminProjectServlet", value = "/adminProjectServlet")
public class AdminProjectServlet extends HttpServlet {
    AdminProjectService service = new AdminProjectServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        String method = request.getParameter("method");
        if(method.equals("selectByPage")){
            selectByPage(request,response);
        }else if(method.equals("selectByConditions")){
            selectByConditions(request,response);
        }


    }







    /*TODO:待实现*/
    private void selectByConditions(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        //1.获取对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        AdminProject project = new AdminProject();
        //封装对象
        //2.注册日期转换器方法
        dataConvert();
        //3.封装对象
        try {
            BeanUtils.populate(project,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        setParam(project);

        //4.调用业务层
        Page<AdminProject> page = service.selectByConditions(Integer.parseInt(currentPage), Integer.parseInt(pageSize), project);
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

    private void setParam(AdminProject project) {
        if (project.getId() == 0) {
            project.setId(null);
        }

        if (project.getName().equals("")) {
            project.setName(null);
        }
        if (project.getOrigin().equals("")) {
            project.setOrigin(null);
        }
        if (project.getType().equals("")) {
            project.setType(null);
        }
        if (project.getTeacherName().equals("")) {
            project.setTeacherName(null);
        }
        if (project.getGrade().equals("")) {
            project.setGrade(null);
        }
        if (project.getScale().equals("")) {
            project.setScale(null);
        }
    }


    /*TODO:待实现*/
    private void selectByPage(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        AdminProject project = new AdminProject();
        //1.调用业务层方法
        Page page = service.selectByConditions(Integer.parseInt(currentPage), Integer.parseInt(pageSize),project);
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
