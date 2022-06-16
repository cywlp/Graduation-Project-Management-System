package com.example.service.impl;


import com.example.bean.Teacher_Project;
import com.example.mapper.Teacher_ProjectMapper;
import com.example.service.Teacher_ProjectService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Teacher_ProjectServiceImpl implements Teacher_ProjectService {
    @Override
    public int addTeacher_Project(Teacher_Project teacher_project) {
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
            Teacher_ProjectMapper mapper = sqlSession.getMapper(Teacher_ProjectMapper.class);
            //5.执行方法
            i = mapper.addTeacher_Project(teacher_project);
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
    public int deleteTeacher_Project(Teacher_Project teacher_project) {
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
            Teacher_ProjectMapper mapper = sqlSession.getMapper(Teacher_ProjectMapper.class);
            //5.执行方法
            i = mapper.deleteTeacher_Project(teacher_project);
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
    public int updateTeacher_Project(Teacher_Project teacher_project) {
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
            Teacher_ProjectMapper mapper = sqlSession.getMapper(Teacher_ProjectMapper.class);
            //5.执行方法
            i = mapper.updateTeacher_Project(teacher_project);
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
    public Teacher_Project selectByConditions(Teacher_Project teacher_project) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Teacher_Project teacher_project1=new Teacher_Project();
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            Teacher_ProjectMapper mapper = sqlSession.getMapper(Teacher_ProjectMapper.class);
            //5.执行方法
            teacher_project1 =  mapper.selectByConditions(teacher_project);
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
        return teacher_project1;
    }
}
