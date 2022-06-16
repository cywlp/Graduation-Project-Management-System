package com.example.controller;

import com.example.bean.AdminStudent;
import com.example.bean.Student;
import com.example.service.AdminStudentService;
import com.example.service.StudentService;
import com.example.service.impl.AdminStudentServiceImpl;
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
import java.util.Map;

@WebServlet(name = "AdminStudentServlet", value = "/adminStudentServlet")
public class AdminStudentServlet extends HttpServlet {
    private AdminStudentService service = new AdminStudentServiceImpl();
    private StudentService studentService=new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("我来了");
        //获取参数
        String method = request.getParameter("method");
        if(method.equals("selectByPage")){
            System.out.println("我来了2");
            selectByPage(request,response);
        }else if(method.equals("selectByConditions")){
            selectByConditions(request,response);
        }else if(method.equals("updateStu")){
            updateStu(request,response);
        }else if(method.equals("deleteStu")){
            deleteStu(request,response);
        }else if(method.equals("addStu")){
            addStu(request,response);
        }




    }

    private void addStu(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        System.out.println("1111");
        Student student = new Student();
        student.setS_id(studentService.getMaxId());
        student.setS_number(request.getParameter("number"));
        student.setS_pwd(request.getParameter("pwd"));
        student.setS_name(request.getParameter("name"));
        student.setS_major(request.getParameter("major"));
        student.setS_telephone(request.getParameter("telephone"));
        student.setS_grade(request.getParameter("grade"));
        student.setS_class(request.getParameter("a_class"));
        student.setS_nation(request.getParameter("nation"));
        student.setS_sex(request.getParameter("sex"));
        student.setS_email(request.getParameter("email"));
        student.setS_origin(request.getParameter("origin"));
        student.setS_academy(request.getParameter("academy"));
        student.setS_status(1);
        System.out.println("22222");
        System.out.println(student);
        System.out.println("-------------");
        //调用业务层
        boolean b = studentService.addStudent(student);
        if(b){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        System.out.println("333333");
        System.out.println(student);
        //3.重定向到分页
        try {
            response.sendRedirect(request.getContextPath()+"/adminStudentServlet?method=selectByPage&currentPage="+
                    currentPage+"&pageSize="+pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteStu(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        //1.获取对象
        String number = request.getParameter("number");
        Student student = new Student();
        student.setS_number(number);
        //2.调用业务层
        studentService.deleteStudent(student);
        //3.重定向到分页
        try {
            response.sendRedirect(request.getContextPath()+"/adminStudentServlet?method=selectByPage&currentPage="+
                    currentPage+"&pageSize="+pageSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateStu(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        Student student = new Student();
        student.setS_id(null);
        student.setS_number(request.getParameter("number"));
        student.setS_pwd(request.getParameter("pwd"));
        student.setS_name(request.getParameter("name"));
        student.setS_major(request.getParameter("major"));
        student.setS_telephone(request.getParameter("telephone"));
        student.setS_grade(request.getParameter("grade"));
        student.setS_class(request.getParameter("a_class"));
        student.setS_nation(request.getParameter("nation"));
        student.setS_sex(request.getParameter("sex"));
        student.setS_email(request.getParameter("email"));
        student.setS_origin(request.getParameter("origin"));
        student.setS_academy(request.getParameter("academy"));
        student.setS_status(Integer.parseInt(request.getParameter("status")));
        System.out.println("------------");
        System.out.println(student);
        System.out.println("------------");
        //调用业务层方法
        studentService.updateStudent(student);
        try {
            response.sendRedirect(request.getContextPath()+"/adminStudentServlet?method=selectByPage&currentPage="+
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
        AdminStudent student = new AdminStudent();
        //封装对象
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
        setParam(student);

        //4.调用业务层
        Page<AdminStudent> page = service.selectByConditions(Integer.parseInt(currentPage), Integer.parseInt(pageSize), student);
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

    private void setParam(AdminStudent student) {
        if(student.getId()==0){
            student.setId(null);
        }
        if(student.getNumber().equals("")){
            student.setNumber(null);
        }
        if(student.getPwd().equals("")){
            student.setPwd(null);
        }
        if(student.getName().equals("")){
            student.setName(null);
        }
        if(student.getMajor().equals("")){
            student.setMajor(null);
        }
        if(student.getTelephone().equals("")){
            student.setTelephone(null);
        }
        if(student.getGrade().equals("")){
            student.setGrade(null);
        }
        if(student.getA_class().equals("")){
            student.setA_class(null);
        }
        if(student.getNation().equals("")){
            student.setNation(null);
        }
        if(student.getSex().equals("")){
            student.setSex(null);
        }
        if(student.getEmail().equals("")){
            student.setEmail(null);
        }
        if(student.getOrigin().equals("")){
            student.setOrigin(null);
        }
        if(student.getAcademy().equals("")){
            student.setAcademy(null);
        }
        if(student.getStatus()==0){
            student.setStatus(null);
        }
    }

    Student modify(AdminStudent adminStudent){
        Student student = new Student();
        student.setS_id(adminStudent.getId());
        student.setS_number(adminStudent.getNumber());
        student.setS_pwd(adminStudent.getPwd());
        student.setS_name(adminStudent.getName());
        student.setS_major(adminStudent.getMajor());
        student.setS_telephone(adminStudent.getTelephone());
        student.setS_grade(adminStudent.getGrade());
        student.setS_class(adminStudent.getA_class());
        student.setS_nation(adminStudent.getNation());
        student.setS_sex(adminStudent.getSex());
        student.setS_email(adminStudent.getEmail());
        student.setS_origin(adminStudent.getOrigin());
        student.setS_academy(adminStudent.getAcademy());
        student.setS_status(adminStudent.getStatus());
        return student;
    }


    private void selectByPage(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        AdminStudent student = new AdminStudent();

        System.out.println("进入业无----------");
        //1.调用业务层方法
        Page page = service.selectByConditions(Integer.parseInt(currentPage), Integer.parseInt(pageSize),student);
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
