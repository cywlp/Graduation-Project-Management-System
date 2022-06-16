package com.example.controller;

import com.example.bean.*;
import com.example.service.*;
import com.example.service.impl.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import netscape.javascript.JSObject;
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
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "StudentServlet", value = "/studentServlet")
public class StudentServlet extends HttpServlet {
    Student_SelectService studentService  = new Student_SelectServiceImpl();
    ProjectService projectService = new ProjectServiceImpl();
    Pre_selectService pre_selectService = new Pre_selectServiceImpl();
    StudentService serviceStudent = new StudentServiceImpl();
    StudentApplicationService studentApplicationService = new StudentApplicationServiceImpl();
    Instruction_StudentService instruction_studentService = new Instruction_StudentServiceIimpl();
    InstructionService instructionService = new InstructionServiceImpl();
    FinalStudentProjectService finalStudentProjectService = new FinalStudentProjectServiceImpl();
    StudentViewService studentViewService = new StudentViewServiceImpl();
    InstructorGradesService instructorGradesService = new InstructorGradesServiceImpl();
    ReviewerGradesService reviewerGradesService = new ReviewerGradesServiceImpl();
    DefenseGradesService defenseGradesService = new DefenseGradesServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取参数
        String method = request.getParameter("method");
        if(method.equals("selectProjectByPage")){
            selectProjectByPage(request,response);
        }
        else if(method.equals("selectProjectByConditions")){
            selectProjectByConditions(request,response);
        }
        else if(method.equals("selectContentById")){
            selectContentById(request,response);
        }
        else if(method.equals("applyCheck")){
            applyCheck(request,response);
        }
        else if(method.equals("applyPre")){
            applyPre(request,response);
        }
        else if(method.equals("selectMyApplyByPage")){
            selectMyApplyByPage(request,response);
        }else if(method.equals("selectInstructionList")){
            selectInstructionList(request,response);
        }else if(method.equals("addInstruction")){
            addInstruction(request,response);
        }else if(method.equals("selectInstructionByConditions")){
            selectInstructionByConditions(request,response);
        }
        else if(method.equals("selectStuInfo")){
            selectStuInfo(request,response);
        }
        else if(method.equals("selectInstructorGrade")){
            selectInstructorGrade(request,response);
        }
        else if(method.equals("selectReviewerGrade")){
            selectReviewerGrade(request,response);
        }
        else if(method.equals("selectReplyGrade")){
            selectReplyGrade(request,response);
        }
        else if(method.equals("selectTotalGrade")){
            selectTotalGrade(request,response);
        }
    }

    //TODO
    private void selectTotalGrade(HttpServletRequest request, HttpServletResponse response) {

    }

    private void selectReplyGrade(HttpServletRequest request, HttpServletResponse response) {
        String number = (String) request.getSession().getAttribute("number");

        DefenseGrades defenseGrades = defenseGradesService.selectByS_number(number);
        System.out.println(defenseGrades.toString());
        try {
            System.out.println(defenseGrades.getDg_date().toString());
            String string = new ObjectMapper().writeValueAsString(defenseGrades);
            System.out.println(string);
            response.getWriter().write(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectReviewerGrade(HttpServletRequest request, HttpServletResponse response) {
        String number = (String) request.getSession().getAttribute("number");

        ReviewerGrades reviewerGrades = reviewerGradesService.selectByS_number(number);
        try {
            String string = new ObjectMapper().writeValueAsString(reviewerGrades);
            System.out.println(string);
            response.getWriter().write(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectInstructorGrade(HttpServletRequest request, HttpServletResponse response) {
        String number = (String) request.getSession().getAttribute("number");

        InstructorGrades instructorGrades = instructorGradesService.selectByS_number(number);
        try {
            String string = new ObjectMapper().writeValueAsString(instructorGrades);
            System.out.println(string);
            response.getWriter().write(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectStuInfo(HttpServletRequest request, HttpServletResponse response) {
        String number = (String) request.getSession().getAttribute("number");
        StudentView student = new StudentView();
        student.setS_number(number);

        Page<StudentView> studentViews = studentViewService.selectByS_number(1, 1, student);
        student = studentViews.get(0);

        try {
            String string = new ObjectMapper().writeValueAsString(student);
            System.out.println(string);
            response.getWriter().write(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectInstructionByConditions(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String number = (String) request.getSession().getAttribute("number");
        String content = request.getParameter("content");

        Instruction_Student instruction_student = new Instruction_Student();
        instruction_student.setSid(number);
        instruction_student.setContent(content);
        Page<Instruction_Student> page = instruction_studentService
                .selectInstructionByContent(Integer.parseInt(currentPage), Integer.parseInt(pageSize), instruction_student);
        //2.封装PageInfo
        PageInfo pageInfo = new PageInfo(page);
        //3.info=>json
        try {
            String string = new ObjectMapper().writeValueAsString(pageInfo);
            System.out.println(string);
            response.getWriter().write(string);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addInstruction(HttpServletRequest request, HttpServletResponse response) {
        String sNumber = (String) request.getSession().getAttribute("number");
//        String content = request.getParameter("content");
//        String time = request.getParameter("time");

        Student student = new Student();
        student.setS_number(sNumber);
        Page<Student> students = serviceStudent.selectByConditions(1, 1, student);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        student = pageInfo.getList().get(0);
        Integer s_id = student.getS_id();

        FinalStudentProject finalStudentProject = new FinalStudentProject();
        finalStudentProject.setId(s_id);
        finalStudentProject = finalStudentProjectService.selectByid(finalStudentProject);
        Integer t_id = finalStudentProject.getT_id();

        Map<String, String[]> parameterMap = request.getParameterMap();
        Instruction instruction = new Instruction();
        //封装对象
        //2.注册日期转换器方法
        dataConvert();
        //3.封装对象
        try {
            BeanUtils.populate(instruction,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        instruction.setS_id(s_id);
        instruction.setT_id(t_id);
        instruction.setIs_finished(0);
        instructionService.addInstruction(instruction);
        try {
            response.getWriter().write("申请成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO 前端时间显示
    private void selectInstructionList(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String number = (String) request.getSession().getAttribute("number");

        Instruction_Student instruction_student = new Instruction_Student();
        instruction_student.setSid(number);
        Page<Instruction_Student> page = instruction_studentService
                .selectInstructionByConditions(Integer.parseInt(currentPage), Integer.parseInt(pageSize), instruction_student);
        //2.封装PageInfo
        PageInfo pageInfo = new PageInfo(page);
        //3.info=>json
        try {
            String string = new ObjectMapper().writeValueAsString(pageInfo);
            System.out.println(string);
            response.getWriter().write(string);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void selectMyApplyByPage(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String number = (String) request.getSession().getAttribute("number");

        StudentApplication studentApplication = new StudentApplication();
        studentApplication.setNumber(number);
        Page<StudentApplication> page = studentApplicationService
                .selectByConditions(Integer.parseInt(currentPage), Integer.parseInt(pageSize), studentApplication);
        //2.封装PageInfo
        PageInfo pageInfo = new PageInfo(page);
        //3.info=>json
        try {
            String string = new ObjectMapper().writeValueAsString(pageInfo);
            System.out.println(string);
            response.getWriter().write(string);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //TODO
    private void selectProjectByConditions(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String number = (String) request.getSession().getAttribute("number");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String teacherName = request.getParameter("teacherName");

        Student_Select student_select = new Student_Select();
        student_select.setNumber(number);
        student_select.setName(name);
        student_select.setType(type);
        student_select.setTeacherName(teacherName);

        //1.调用业务层方法
        Page page = studentService.selectByConditions(Integer.parseInt(currentPage), Integer.parseInt(pageSize),student_select);
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

    private void applyPre(HttpServletRequest request, HttpServletResponse response) {
        String pId = request.getParameter("id");
        String sNumber = (String) request.getSession().getAttribute("number");
        Student student = new Student();
        student.setS_number(sNumber);
        Page<Student> students = serviceStudent.selectByConditions(1, 1, student);
        Integer sId = students.get(0).getS_id();
        Pre_select pre_select = new Pre_select();
        pre_select.setP_id(Integer.valueOf(pId));
        pre_select.setS_id(Integer.valueOf(sId));
        pre_select.setPre_success(0);
        String result;
        int row = pre_selectService.addPre_select(pre_select);
        if (row == 0){
            result = "选题失败";
        }else {
            result = "选题成功";
        }
        try {
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void applyCheck(HttpServletRequest request, HttpServletResponse response) {

        String number = (String) request.getSession().getAttribute("number");

        Student student = new Student();
        student.setS_number(number);
        Page<Student> students = serviceStudent.selectByConditions(1, 1, student);
        Integer sId = students.get(0).getS_id();

        Pre_select pre_select = new Pre_select();
        pre_select.setS_id(sId);
        Page<Pre_select> page = pre_selectService.countselectByConditions(1, 1, pre_select);
        //2.封装PageInfo
        PageInfo pageInfo = new PageInfo(page);
        String result = "less3";
        if (pageInfo.getTotal() > 2){
            result = "more3";
        }

        try {
            response.getWriter().write(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void selectContentById(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Project project = new Project();
        project.setP_id(Integer.valueOf(id));
        Page<Project> projectPage = projectService.selectByP_id(1, 1, project);
        PageInfo<Project> pageInfo = new PageInfo<>(projectPage);
        Project project1 = pageInfo.getList().get(0);
        String content = project1.getP_content();
        try {
            String string = new ObjectMapper().writeValueAsString(project1);
            System.out.println(string);
            response.getWriter().write(content);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void selectProjectByPage(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String number = (String) request.getSession().getAttribute("number");
        Student_Select student_select = new Student_Select();
        student_select.setNumber(number);

        //1.调用业务层方法
        Page page = studentService.unSelect(Integer.parseInt(currentPage), Integer.parseInt(pageSize),student_select);
        //2.封装PageInfo
        PageInfo pageInfo = new PageInfo(page);
//        List list = pageInfo.getList();

        //排除已选课题
//        Student student = new Student();
//        student.setS_number(number);
//        Page<Student> students = serviceStudent.selectByConditions(1, 1, student);
//        Integer sId = students.get(0).getS_id();
//        Pre_select pre_select = new Pre_select();
//        pre_select.setS_id(Integer.valueOf(sId));
//        //从预选表中查询此同学已选课题
//        List<Pre_select> pre_selects = (List<Pre_select>) pre_selectService.selectByConditions(pre_select);
//        PageInfo pageInfoSel = new PageInfo(pre_selects);
//        List listSel = pageInfoSel.getList();
//        List<Integer> listPid = new ArrayList<>();
//        List<Integer> listSelPid = new ArrayList<>();
//        for (Object ss : list) {
//            listPid.add(((Student_Select) ss).getId());
//        }
//        for (Object ps : listSel) {
//            listSelPid.add(((Pre_select) ps).getP_id());
//        }
//        //listPid - listSelPid
//        List<Integer> reduce = listPid.stream().filter(item -> !listSelPid.contains(item)).collect(Collectors.toList());
//        for (int i = 0; i < list.size(); i++) {
//            Student_Select ss = (Student_Select) list.get(i);
//            if (!reduce.contains(ss.getId())){
//                list.remove(i);
//            }
//        }
//        pageInfo.setList(new ArrayList<>(list));
//        PageInfo<Student_Select> newPageInfo = new PageInfo<>();
//        newPageInfo.setList(list);
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
