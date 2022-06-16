package com.example.controller;

import com.example.bean.*;
import com.example.service.*;
import com.example.service.impl.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TeacherServlet", value = "/teacherServlet")
public class TeacherServlet extends HttpServlet {
    TeacherApplicationService teacherApplicationService = new TeacherApplicationServiceImpl();
    Pre_selectService pre_selectService = new Pre_selectServiceImpl();
    InstructionService instructionService = new InstructionServiceImpl();
    FinalStudentProjectService finalStudentProjectService = new FinalStudentProjectServiceImpl();
    InstructorGradesService instructorGradesService = new InstructorGradesServiceImpl();
    StudentProjectService studentProjectService = new StudentProjectServiceImpl();
    ReviewerGradesService reviewerGradesService = new ReviewerGradesServiceImpl();
    DefenseGradesService defenseGradesService = new DefenseGradesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取参数
        String method = request.getParameter("method");
        if(method.equals("selectByPageProject")){
            selectByPageProject(request,response);
        }else if(method.equals("selectProjectByConditions")){
            selectProjectByConditions(request,response);
        }else if(method.equals("selectProjectContentByPid")){
            selectProjectContentByPid(request,response);
        }else if(method.equals("updateProject")){
            updateProject(request,response);
        }else if(method.equals("addProject")){
            addProject(request,response);
        }else if(method.equals("selectByPageApply")){
            selectByPageApply(request,response);
        }else if(method.equals("selectApplyByConditions")){
            selectApplyByConditions(request,response);
        }else if(method.equals("agreeApply")){
            agreeApply(request,response);
        }else if(method.equals("selectByPageFinal")){
            selectByPageFinal(request,response);
        }else if(method.equals("selectApplyByConditionsFinal")){
            selectApplyByConditionsFinal(request,response);
        }else if(method.equals("selectByPageInstruction")){
            //历史指导记录查询
            selectByPageInstruction(request,response);
        }else if(method.equals("selectByPageInstructionNeed")){
            //待确认指导记录查询
            selectByPageInstructionNeed(request,response);
        }else if(method.equals("agreeInstruction")){
            //确认指导记录
            agreeInstruction(request,response);
        }else if(method.equals("selectInstructionByConditionsFinal")){
            //根据学号查找指导记录
            selectInstructionByConditionsFinal(request,response,1);
        }else if(method.equals("selectInstructionByConditions")){
            selectInstructionByConditionsFinal(request,response,0);
        }else if(method.equals("deleteInstruction")){
            deleteInstruction(request,response);
        }

        if(method.equals("teacherGradeSetPara")){
            teacherGradeSetPara(request,response);
        }
        if(method.equals("getData")){
            getData(request,response);
        }
        if(method.equals("setTeacherGrade")){
            setTeacherGrade(request,response);
        }
        if(method.equals("selectInstructorGrade")){
            selectInstructorGrade(request,response);
        }
        if(method.equals("setReviewerGrade")){
            setReviewerGrade(request,response);
        }
        if(method.equals("selectReviewerGrade")){
            selectReviewerGrade(request,response);
        }
        if(method.equals("setReplyGrade")){
            setReplyGrade(request,response);
        }
        if(method.equals("selectReplyGrade")){
            selectReplyGrade(request,response);
        }


    }

    private void selectReplyGrade(HttpServletRequest request, HttpServletResponse response) {
        FinalStudentProject myObject = (FinalStudentProject) request.getSession().getAttribute("myObject");

        DefenseGrades defenseGrades = defenseGradesService.selectByS_number(myObject.getNumber());
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

    private void setReplyGrade(HttpServletRequest request, HttpServletResponse response) {
        String g1 = request.getParameter("g1");
        String g2 = request.getParameter("g2");
        String g3 = request.getParameter("g3");
        String g4 = request.getParameter("g4");
        String g5 = request.getParameter("g5");
        String g = request.getParameter("g");
        String comment = request.getParameter("comment");
        String teacher = request.getParameter("teacher");
        String time = request.getParameter("time");

        FinalStudentProject myObject = (FinalStudentProject) request.getSession().getAttribute("myObject");
        StudentProject studentProject = new StudentProject();
        studentProject.setS_id(myObject.getId());
        studentProject.setP_id(myObject.getProjectId());
        studentProject = studentProjectService.selectByid(studentProject);
        Integer dg_id = studentProject.getDg_id();

        DefenseGrades defenseGrades = new DefenseGrades();
        defenseGrades.setDg_id(dg_id);
        defenseGrades.setDg_quality(Float.valueOf(g1));
        defenseGrades.setDg_difficulty(Float.valueOf(g2));
        defenseGrades.setDg_innovation(Float.valueOf(g3));
        defenseGrades.setDg_verbal(Float.valueOf(g4));
        defenseGrades.setDg_defense(Float.valueOf(g5));
        defenseGrades.setDg_sum(Float.valueOf(g));
        defenseGrades.setDg_comment(comment);
        defenseGrades.setDg_person(teacher);
        //instructorGrades.setIg_date(time);

        defenseGradesService.updateDefensGrades(defenseGrades);
    }

    private void selectReviewerGrade(HttpServletRequest request, HttpServletResponse response) {

        FinalStudentProject myObject = (FinalStudentProject) request.getSession().getAttribute("myObject");
        ReviewerGrades reviewerGrades = reviewerGradesService.selectByS_number(myObject.getNumber());
        try {
            String string = new ObjectMapper().writeValueAsString(reviewerGrades);
            System.out.println(string);
            response.getWriter().write(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setReviewerGrade(HttpServletRequest request, HttpServletResponse response) {
        String g1 = request.getParameter("g1");
        String g2 = request.getParameter("g2");
        String g3 = request.getParameter("g3");
        String g4 = request.getParameter("g4");
        String g5 = request.getParameter("g5");
        String g6 = request.getParameter("g6");
        String g = request.getParameter("g");
        String comment = request.getParameter("comment");
        String teacher = request.getParameter("teacher");
        String time = request.getParameter("time");

        FinalStudentProject myObject = (FinalStudentProject) request.getSession().getAttribute("myObject");
        StudentProject studentProject = new StudentProject();
        studentProject.setS_id(myObject.getId());
        studentProject.setP_id(myObject.getProjectId());
        studentProject = studentProjectService.selectByid(studentProject);
        Integer rg_id = studentProject.getRg_id();

        ReviewerGrades reviewerGrades = new ReviewerGrades();
        reviewerGrades.setRg_id(rg_id);
        reviewerGrades.setRg_completion(Float.valueOf(g1));
        reviewerGrades.setRg_investigate(Float.valueOf(g2));
        reviewerGrades.setRg_translation(Float.valueOf(g3));
        reviewerGrades.setRg_comprehension(Float.valueOf(g4));
        reviewerGrades.setRg_design(Float.valueOf(g5));
        reviewerGrades.setRg_innovation(Float.valueOf(g6));
        reviewerGrades.setRg_sum(Float.valueOf(g));
        reviewerGrades.setRg_comment(comment);
        reviewerGrades.setRg_person(teacher);
        //instructorGrades.setIg_date(time);

        reviewerGradesService.updateReviewerGrades(reviewerGrades);
    }

    private void selectInstructorGrade(HttpServletRequest request, HttpServletResponse response) {

        FinalStudentProject myObject = (FinalStudentProject) request.getSession().getAttribute("myObject");
        InstructorGrades instructorGrades = instructorGradesService.selectByS_number(myObject.getNumber());
        try {
            String string = new ObjectMapper().writeValueAsString(instructorGrades);
            System.out.println(string);
            response.getWriter().write(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTeacherGrade(HttpServletRequest request, HttpServletResponse response) {
        String g1 = request.getParameter("g1");
        String g2 = request.getParameter("g2");
        String g3 = request.getParameter("g3");
        String g4 = request.getParameter("g4");
        String g5 = request.getParameter("g5");
        String g6 = request.getParameter("g6");
        String g = request.getParameter("g");
        String agree = request.getParameter("agree");
        String comment = request.getParameter("comment");
        String teacher = request.getParameter("teacher");
        String time = request.getParameter("time");

        FinalStudentProject myObject = (FinalStudentProject) request.getSession().getAttribute("myObject");
        StudentProject studentProject = new StudentProject();
        studentProject.setS_id(myObject.getId());
        studentProject.setP_id(myObject.getProjectId());
        studentProject = studentProjectService.selectByid(studentProject);
        Integer ig_id = studentProject.getIg_id();

        InstructorGrades instructorGrades = new InstructorGrades();
        instructorGrades.setIg_id(ig_id);
        instructorGrades.setIg_workload(Float.valueOf(g1));
        instructorGrades.setIg_investigate(Float.valueOf(g2));
        instructorGrades.setIg_information(Float.valueOf(g3));
        instructorGrades.setIg_comprehension(Float.valueOf(g4));
        instructorGrades.setIg_design(Float.valueOf(g5));
        instructorGrades.setIg_innovation(Float.valueOf(g6));
        instructorGrades.setIg_sum(Float.valueOf(g));
        instructorGrades.setIg_agree(agree);
        instructorGrades.setIg_comment(comment);
        instructorGrades.setIg_person(teacher);
        //instructorGrades.setIg_date(time);

        instructorGradesService.updateInstructorGrades(instructorGrades);


    }

    //TODO:test
    private void getData(HttpServletRequest request, HttpServletResponse response) {
//        name: '王佳宝',
//                major: '软件工程',
//                a_class: '2019240207',
//                project: '基于红外识别的室内自动消毒杀菌系统'
        System.out.println("wooooooo");
        FinalStudentProject myObject = (FinalStudentProject) request.getSession().getAttribute("myObject");
        System.out.println("----1----");
        StudentService studentService = new StudentServiceImpl();
        System.out.println("----2----");
        Student student = new Student();
        System.out.println(myObject);
        System.out.println(myObject.getId());
        student.setS_id(myObject.getId());
        System.out.println("----3----");
        List<Student> students = studentService.selectByS_id(student);
        System.out.println(students.get(0));
        System.out.println("----------");
        HashMap<String,String>map = new HashMap<>();
        map.put("name",students.get(0).getS_name());
        map.put("major",students.get(0).getS_major());
        map.put("a_class",students.get(0).getS_class());
        map.put("project",myObject.getProjectName());
        try {
            String string = new ObjectMapper().writeValueAsString(map);
            response.getWriter().write(string);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void teacherGradeSetPara(HttpServletRequest request, HttpServletResponse response) {
        /**
         * id="+row.id+
         *                     "&name="+row.name+
         *                     "&number="+row.number+
         *                     "&projectId="+row.projectId+
         *                     "&projectName="+row.projectName+
         *                     "&t_id="+row.t_id+
         *                     "&t_number"+row.t_number+
         */
        //1.获取对象
        Map<String, String[]> parameterMap = request.getParameterMap();
        FinalStudentProject finalStudentProject = new FinalStudentProject();
        //封装对象
        //3.封装对象
        try {
            BeanUtils.populate(finalStudentProject,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("myObject",finalStudentProject);
        System.out.println(finalStudentProject);
    }

    private void deleteInstruction(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        String isid = request.getParameter("isid");
        System.out.println("---删除---");
        System.out.println(isid);
        System.out.println("---删除----");


        InstructionService service = new InstructionServiceImpl();
        Instruction instruction = new Instruction();
        instruction.setIs_id(Integer.parseInt(isid));

        service.deleteInstruction(instruction);

            try {
                response.sendRedirect(request.getContextPath()+"/teacherServlet?method=selectByPageInstructionNeed&currentPage="+
                        currentPage+"&pageSize="+pageSize);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    private void selectInstructionByConditionsFinal(HttpServletRequest request, HttpServletResponse response,int isFinish) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        System.out.println("-------");

        String snumber = request.getParameter("snumber");


        String number = (String) request.getSession().getAttribute("number");
        InstructionTwo instructionTwo = new InstructionTwo();
        instructionTwo.setTnumber(number);
        instructionTwo.setSnumber(snumber);
        instructionTwo.setIsFinished(isFinish);

        Page<InstructionTwo> page = instructionService.selectInstructionTwo(
                Integer.parseInt(currentPage),Integer.parseInt(pageSize),instructionTwo);

        //2.封装PageInfo
        System.out.println("------------");
        PageInfo<InstructionTwo> pageInfo = new PageInfo(page);
        for (InstructionTwo instructionTwo1:pageInfo.getList()){
            System.out.println(instructionTwo1);
        }
        System.out.println("-----------------");
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

    private void agreeInstruction(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        String isid = request.getParameter("isid");
        System.out.println("----同意---");
        System.out.println(isid);
        System.out.println("---同意----");


        InstructionService service = new InstructionServiceImpl();
        Instruction instruction = new Instruction();
        instruction.setIs_id(Integer.parseInt(isid));

        instruction.setIs_finished(1);
        int i = service.updateInstructionFinish(instruction);
        if(i!=0){
            try {
                response.sendRedirect(request.getContextPath()+"/teacherServlet?method=selectByPageInstructionNeed&currentPage="+
                        currentPage+"&pageSize="+pageSize);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void selectByPageInstructionNeed(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        System.out.println("-------");

        String number = (String) request.getSession().getAttribute("number");
        InstructionTwo instructionTwo = new InstructionTwo();
        instructionTwo.setTnumber(number);
        instructionTwo.setIsFinished(0);

        Page<InstructionTwo> page = instructionService.selectInstructionTwo(
                Integer.parseInt(currentPage),Integer.parseInt(pageSize),instructionTwo);

        //2.封装PageInfo
        System.out.println("------------");
        PageInfo<InstructionTwo> pageInfo = new PageInfo(page);
        for (InstructionTwo instructionTwo1:pageInfo.getList()){
            System.out.println(instructionTwo1);
        }
        System.out.println("-----------------");
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

    private void selectByPageInstruction(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        System.out.println("-------");

        String number = (String) request.getSession().getAttribute("number");
        InstructionTwo instructionTwo = new InstructionTwo();
        instructionTwo.setTnumber(number);
        instructionTwo.setIsFinished(1);

        Page<InstructionTwo> page = instructionService.selectInstructionTwo(
                Integer.parseInt(currentPage),Integer.parseInt(pageSize),instructionTwo);

        //2.封装PageInfo
        PageInfo<InstructionTwo> pageInfo = new PageInfo(page);
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


    private void selectApplyByConditionsFinal(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        String number_t = request.getParameter("number");
        String name = request.getParameter("name");

        String number = (String) request.getSession().getAttribute("number");
        FinalStudentProject studentProject = new FinalStudentProject();

        studentProject.setT_number(number);
        if(!"".equals(number_t)){
            studentProject.setNumber(number_t);
        }
       if(!"".equals(name)){
           studentProject.setName(name);
       }



        Page<FinalStudentProject> page = finalStudentProjectService.selectBynumber(Integer.parseInt(currentPage),
                Integer.parseInt(pageSize), studentProject);
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


    private void selectByPageFinal(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");


        String number = (String) request.getSession().getAttribute("number");
        FinalStudentProject studentProject=new FinalStudentProject();
        studentProject.setT_number(number);
        Page<FinalStudentProject> page = finalStudentProjectService.selectBynumber(Integer.parseInt(currentPage)
                , Integer.parseInt(pageSize), studentProject);

        //2.封装PageInfo
        PageInfo<FinalStudentProject> pageInfo = new PageInfo(page);
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
     * 状态success
     * 0：申请选题，未同意
     * 1：同意该选题
     *
     *      一个题目被其某位同学选中后，其他人的申请自动拒绝
     *      同时将该题目id,学生id 放入学生题目表。
     * 2：拒绝该选题
     *
     *逻辑思路：
     * 学生端：
     *      学生端可见的题目表来源：
     *      视图根据年级学院匹配的题目-预选表中该学生已选择（success=0）的题目 -学生题目表中的题目。
     *老师端：
     *      同意：将预选表中success=1
     *      该学生其他申请
     * */


    private void agreeApply(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        String id = request.getParameter("id");
        String projectId = request.getParameter("projectId");
        boolean result = pre_selectService.agreeApply(Integer.parseInt(id), Integer.parseInt(projectId));
        if(result){
            try {
                response.sendRedirect(request.getContextPath()+"/teacherServlet?method=selectByPageApply&currentPage="+
                        currentPage+"&pageSize="+pageSize);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void selectApplyByConditions(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        TeacherApplication application = new TeacherApplication();

        String number_t = request.getParameter("number");
        String name = request.getParameter("name");
        String projectName = request.getParameter("projectName");

        String number = (String) request.getSession().getAttribute("number");
        application.setT_number(number);
        application.setStatus(0);
        if(number_t!=null&&(!number_t.equals(""))){
            application.setNumber(number_t);
        }
        if(name!=null&&(!name.equals(""))){
            application.setName(name);
        }
        if(projectName!=null&&(!projectName.equals(""))){
            application.setProjectName(projectName);
        }
        System.out.println(application);
        Page<TeacherApplication> page = teacherApplicationService.selectByConditions(
                Integer.parseInt(currentPage),Integer.parseInt(pageSize),application);
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


    private void selectByPageApply(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        TeacherApplication application = new TeacherApplication();

        String number = (String) request.getSession().getAttribute("number");
        application.setT_number(number);
        application.setStatus(0);

        Page<TeacherApplication> page = teacherApplicationService.selectByConditions(
                Integer.parseInt(currentPage),Integer.parseInt(pageSize),application);

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

    private void addProject(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String grade = request.getParameter("grade");
        String scale = request.getParameter("scale");
        String origin = request.getParameter("origin");
        String content = request.getParameter("content");
        String finalNumber = request.getParameter("finalNumber");
        System.out.println("--------进来了");
        ProjectService projectService = new ProjectServiceImpl();
        Project project = new Project();
        int pid = projectService.getMaxId();
        project.setP_id(projectService.getMaxId());
        project.setP_name(name);
        project.setP_type(type);
        project.setP_origin(origin);
        project.setP_content(content);
        int i = projectService.addProject(project);
        System.out.println("--------进来了2");
        if(i==1){
//            设置老师项目表
            Teacher_Project teacher_project = new Teacher_Project();

            teacher_project.setP_id(pid);

            String number = (String) request.getSession().getAttribute("number");
            teacher_project.setT_id(getTeacher_id(number));

            teacher_project.setGrade(grade);
            teacher_project.setScale(scale);

            Teacher_ProjectService teacher_projectService = new Teacher_ProjectServiceImpl();
            int i1 = teacher_projectService.addTeacher_Project(teacher_project);
            if(i1==1){
                int result2=0;
                //执行定向分配
                int student_id = getStudent_id(finalNumber);
                if(student_id!=-1){
                    StudentProject studentProject = new StudentProject();
                    studentProject.setS_id(student_id);
                    studentProject.setP_id(pid);
                    StudentProjectService studentProjectService = new StudentProjectServiceImpl();
                    result2= studentProjectService.insertStudentProject(studentProject);
                }
                if(result2!=0){
                    System.out.println("定向分配成功");
                }
                try {
                    response.sendRedirect(request.getContextPath()+"/teacherServlet?method=selectByPageProject&currentPage="+
                            currentPage+"&pageSize="+pageSize);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private void updateProject(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String p_id = request.getParameter("p_id");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String grade = request.getParameter("grade");
        String scale = request.getParameter("scale");
        String origin = request.getParameter("origin");
        String content = request.getParameter("content");

        Project project = new Project();
        project.setP_id(Integer.parseInt(p_id));
        project.setP_name(name);
        project.setP_origin(origin);
        project.setP_type(type);
        project.setP_content(content);

        ProjectService projectService = new ProjectServiceImpl();
        projectService.updateProject(project);

//        获得老师id
        TeacherService service = new TeacherServiceImpl();
        Teacher teacher = new Teacher();
        String number = (String) request.getSession().getAttribute("number");

        teacher.setT_number(number);
//        teacher.setT_number("11");
        Page<Teacher> teachers = service.selectByConditions(1, 1, teacher);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);

        Teacher_Project teacher_project = new Teacher_Project();
        Integer tid = pageInfo.getList().get(0).getT_id();
        int pid = Integer.parseInt(p_id);


        teacher_project.setT_id(tid);
        teacher_project.setP_id(pid);

        Teacher_ProjectService teacher_projectService = new Teacher_ProjectServiceImpl();
        Teacher_Project teacher_project1 = teacher_projectService.selectByConditions(teacher_project);
        teacher_project1.setScale(scale);
        teacher_project1.setGrade(grade);

        int i = teacher_projectService.updateTeacher_Project(teacher_project1);
        if(i!=0){
            try {
                response.sendRedirect(request.getContextPath()+"/teacherServlet?method=selectByPageProject&currentPage="+
                        currentPage+"&pageSize="+pageSize);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int getTeacher_id(String number) {
        TeacherService service = new TeacherServiceImpl();
        Teacher teacher = new Teacher();

        teacher.setT_number(number);
        Page<Teacher> teachers = service.selectByConditions(1, 1, teacher);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);

        Integer tid = pageInfo.getList().get(0).getT_id();
        return tid;
    }
    private int getStudent_id(String number) {
        StudentService studentService = new StudentServiceImpl();
        Student student = new Student();
        student.setS_number(number);
        Page<Student> students = studentService.selectByConditions(1, 1, student);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        if(pageInfo.getList().size()==0){
            return -1;
        }
        Integer sid = pageInfo.getList().get(0).getS_id();
        return sid;
    }

    private void selectProjectContentByPid(HttpServletRequest request, HttpServletResponse response) {

        String p_id = (String) request.getParameter("p_id");
        Project project = new Project();
        project.setP_id(Integer.parseInt(p_id));

        ProjectService projectService = new ProjectServiceImpl();

        Page<Project> page = projectService.selectByP_id(1, 1, project);

        PageInfo<Project> pageInfo = new PageInfo(page);

        Project project1 = pageInfo.getList().get(0);

        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("origin",project1.getP_origin());
        hashMap.put("content",project1.getP_content());
        try {
            String string = new ObjectMapper().writeValueAsString(hashMap);
            response.getWriter().write(string);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void selectProjectByConditions(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        TeacherHistorySelectService service = new TeacherHistorySelectServiceImpl();
        TeacherHistorySelect teacherHistorySelect = new TeacherHistorySelect();

        String number = (String) request.getSession().getAttribute("number");

        teacherHistorySelect.setNumber(number);

        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String grade = request.getParameter("grade");
        String scale = request.getParameter("scale");
        if(name!=""){
        teacherHistorySelect.setName(name);
        }
        if(type!=""){
            teacherHistorySelect.setType(type);
        }
        if(grade!=""){
            teacherHistorySelect.setGrade(grade);
        }
        if(scale!=""){
            teacherHistorySelect.setScale(scale);
        }

        Page<TeacherHistorySelect> page = service.selectByConditions(Integer.parseInt(currentPage), Integer.parseInt(pageSize), teacherHistorySelect);

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

    private void selectByPageProject(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        TeacherHistorySelectService service = new TeacherHistorySelectServiceImpl();
        TeacherHistorySelect teacherHistorySelect = new TeacherHistorySelect();

        String number = (String) request.getSession().getAttribute("number");

        teacherHistorySelect.setNumber(number);

        Page<TeacherHistorySelect> page = service.selectByConditions(Integer.parseInt(currentPage), Integer.parseInt(pageSize), teacherHistorySelect);

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
