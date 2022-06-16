package com.example.service.impl;

import com.example.bean.*;
import com.example.mapper.*;
import com.example.service.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Pre_selectServiceImpl implements Pre_selectService {
    @Override
    public int addPre_select(Pre_select pre_select) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        int i=0;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            Pre_selectServiceMapper mapper = sqlSession.getMapper(Pre_selectServiceMapper.class);
            //5.执行方法
           i = mapper.addPre_select(pre_select);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
            if(resourceAsStream!=null){
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return i;
    }

    @Override
    public int deletePre_select(Pre_select pre_select) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        int i=0;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            Pre_selectServiceMapper mapper = sqlSession.getMapper(Pre_selectServiceMapper.class);
            //5.执行方法
            i = mapper.deletePre_select(pre_select);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
            if(resourceAsStream!=null){
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return i;
    }

    @Override
    public int updatePre_select(Pre_select pre_select) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        int i=0;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            Pre_selectServiceMapper mapper = sqlSession.getMapper(Pre_selectServiceMapper.class);
            //5.执行方法
            i = mapper.updatePre_select(pre_select);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
            if(resourceAsStream!=null){
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return i;
    }

    @Override
    public boolean agreeApply(Integer s_id, Integer p_id) {
        Pre_select pre_select =new Pre_select();
        StudentProject studentProject =new StudentProject();
        InstructorGrades instructorGrades =new InstructorGrades();
        DefenseGrades defenseGrades =new DefenseGrades();
        ReviewerGrades reviewerGrades =new ReviewerGrades();
        InstructorGradesService instructorGradesService=new InstructorGradesServiceImpl();
        ReviewerGradesService reviewerGradesService =new ReviewerGradesServiceImpl();
        DefenseGradesService defenseGradesService =new DefenseGradesServiceImpl();

        pre_select.setS_id(s_id);
        pre_select.setP_id(p_id);
        pre_select.setPre_success(-1);

        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;

        int i=0;
        int i1=0;
        int i2=0;
        int i3=0;

        int j1=0;
        int j2=0;
        int j3=0;

        boolean result=false;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(false);

            //4.创建Mapper实现类
            Pre_selectServiceMapper mapper = sqlSession.getMapper(Pre_selectServiceMapper.class);
            StudentProjectMapper mapper1 = sqlSession.getMapper(StudentProjectMapper.class);
            InstructorGradesMapper mapper2 =sqlSession.getMapper(InstructorGradesMapper.class);
            ReviewerGradesMapper mapper3 =sqlSession.getMapper(ReviewerGradesMapper.class);
            DefenseGradesMapper mapper4 =sqlSession.getMapper(DefenseGradesMapper.class);
            //5.执行方法
            i3=mapper.updatePre_SuccessByP_id(pre_select);
            pre_select.setPre_success(3);
            i1 = mapper.updatePre_SuccessByS_id(pre_select);
            pre_select.setPre_success(1);
            i = mapper.updatePre_Success(pre_select);

            j1= reviewerGradesService.getMaxId();
            j2=instructorGradesService.getMaxId();
            j3=defenseGradesService.getMaxId();
            instructorGrades.setIg_id(j1);
            reviewerGrades.setRg_id(j2);
            defenseGrades.setDg_id(j3);
            mapper2.addInstructorGrades(instructorGrades);
            mapper3.addReviewerGrades(reviewerGrades);
            mapper4.insertDefenseGrades(defenseGrades);


            studentProject.setP_id(p_id);
            studentProject.setS_id(s_id);
            studentProject.setRg_id(j2);
            studentProject.setIg_id(j1);
            studentProject.setDg_id(j3);
             i2 = mapper1.insertStudentProject(studentProject);


            if(i!=0&&i1!=0&&i2!=0&&i3!=0){
                sqlSession.commit();
                result=true;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
            if(resourceAsStream!=null){
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    @Override
    public Pre_select selectByConditions(Pre_select pre_select) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Pre_select pre_select1=new Pre_select();
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            Pre_selectServiceMapper mapper = sqlSession.getMapper(Pre_selectServiceMapper.class);
            //5.执行方法
           pre_select1 =  mapper.selectByConditions(pre_select);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
            if(resourceAsStream!=null){
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       return pre_select1;
    }

    @Override
    public Page<Pre_select> countselectByConditions(Integer currentPage, Integer pageSize,Pre_select pre_select) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<Pre_select> page = null;
        List<Pre_select > pre_selects=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            Pre_selectServiceMapper mapper = sqlSession.getMapper(Pre_selectServiceMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            pre_selects = mapper.countselectByConditions(pre_select);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
            if(resourceAsStream!=null){
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return page;
    }
}
