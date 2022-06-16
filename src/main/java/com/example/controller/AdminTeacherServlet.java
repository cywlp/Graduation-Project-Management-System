package com.example.controller;

import com.example.bean.AdminTeacher;
import com.example.bean.Teacher;
import com.example.service.AdminTeacherService;
import com.example.service.TeacherService;
import com.example.service.impl.AdminTeacherServiceImpl;
import com.example.service.impl.TeacherServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.annotation.Resource;
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

@WebServlet(name = "AdminTeacherServlet", value = "/adminTeacherServlet")
public class AdminTeacherServlet extends HttpServlet {

    private AdminTeacherService adminTeacherService = new AdminTeacherServiceImpl();

    private TeacherService teacherService = new TeacherServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        String method = request.getParameter("method");
        if(method.equals("addTeacher")){
            addTeacher(request,response);
        }else if(method.equals("deleteTeacher")){
            deleteTeacher(request,response);
        }else if(method.equals("updateTeacher")){
            updateTeacher(request,response);
        }else if(method.equals("selectByPage")){
            selectByPage(request,response);
        }else if(method.equals("selectByConditions")){
            selectByConditions(request,response);
        }


    }


    private void updateTeacher(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        Teacher teacher = new Teacher();
        teacher.setT_id(null);
        teacher.setT_number(request.getParameter("number"));
        teacher.setT_pwd(request.getParameter("pwd"));
        teacher.setT_name(request.getParameter("name"));
        teacher.setT_major(request.getParameter("major"));
        teacher.setT_telephone(request.getParameter("telephone"));
        teacher.setT_grade(request.getParameter("grade"));
        teacher.setT_nation(request.getParameter("nation"));
        teacher.setT_sex(request.getParameter("sex"));
        teacher.setT_email(request.getParameter("email"));
        teacher.setT_origin(request.getParameter("origin"));
        teacher.setT_academy(request.getParameter("academy"));

        //调用业务层
        teacherService.updateTeacher(teacher);
        //3.重定向到分页
        try {
            response.sendRedirect(request.getContextPath()+"/adminTeacherServlet?method=selectByPage&currentPage="+
                    currentPage+"&pageSize="+pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO:删除
    private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        //1.获取对象
        String number = request.getParameter("number");
        Teacher teacher = new Teacher();
        teacher.setT_number(number);
        //2.调用业务层
        teacherService.deleteTeacher(teacher);
        //3.重定向到分页
        try {
            response.sendRedirect(request.getContextPath()+"/adminTeacherServlet?method=selectByPage&currentPage="+
                    currentPage+"&pageSize="+pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addTeacher(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        Teacher teacher = new Teacher();
        teacher.setT_id(teacherService.getMaxId());
        teacher.setT_number(request.getParameter("number"));
        teacher.setT_pwd(request.getParameter("pwd"));
        teacher.setT_name(request.getParameter("name"));
        teacher.setT_major(request.getParameter("major"));
        teacher.setT_telephone(request.getParameter("telephone"));
        teacher.setT_grade(request.getParameter("grade"));
        teacher.setT_nation(request.getParameter("nation"));
        teacher.setT_sex(request.getParameter("sex"));
        teacher.setT_email(request.getParameter("email"));
        teacher.setT_origin(request.getParameter("origin"));
        teacher.setT_academy(request.getParameter("academy"));

        //调用业务层
        teacherService.addTeacher(teacher);
        //3.重定向到分页
        try {
            response.sendRedirect(request.getContextPath()+"/adminTeacherServlet?method=selectByPage&currentPage="+
                    currentPage+"&pageSize="+pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void selectByConditions(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        //1.获取对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        AdminTeacher teacher = new AdminTeacher();
        //封装对象
        //2.注册日期转换器方法
        dataConvert();
        //3.封装对象
        try {
            BeanUtils.populate(teacher,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        setParam(teacher);

        //4.调用业务层
        Page<AdminTeacher> page = adminTeacherService.selectByConditions(Integer.parseInt(currentPage), Integer.parseInt(pageSize), teacher);
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



    private void selectByPage(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        AdminTeacher teacher = new AdminTeacher();
        //1.调用业务层方法
        Page page = adminTeacherService.selectByConditions(Integer.parseInt(currentPage), Integer.parseInt(pageSize),teacher);
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
            @Override
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
    private void setParam(AdminTeacher teacher) {
        if(teacher.getId()==0){
            teacher.setId(null);
        }
        if(teacher.getNumber().equals("")){
            teacher.setNumber(null);
        }
        if(teacher.getPwd().equals("")){
            teacher.setPwd(null);
        }
        if(teacher.getName().equals("")){
            teacher.setName(null);
        }

        if(teacher.getTelephone().equals("")){
            teacher.setTelephone(null);
        }
        if(teacher.getNation().equals("")){
            teacher.setNation(null);
        }
        if(teacher.getSex().equals("")){
            teacher.setSex(null);
        }
        if(teacher.getEmail().equals("")){
            teacher.setEmail(null);
        }
        if(teacher.getOrigin().equals("")){
            teacher.setOrigin(null);
        }
        if(teacher.getAcademy().equals("")){
            teacher.setAcademy(null);
        }
    }
}
