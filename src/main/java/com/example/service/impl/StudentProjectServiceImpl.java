package com.example.service.impl;

import com.example.bean.StudentProject;
import com.example.mapper.StudentProjectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.example.service.StudentProjectService;

import java.io.IOException;
import java.io.InputStream;

public class StudentProjectServiceImpl implements StudentProjectService {
    //@Override
    public StudentProject selectBysp_id( StudentProject studentProject) {
        StudentProject student=new StudentProject();
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            StudentProjectMapper mapper = sqlSession.getMapper(StudentProjectMapper.class);
            //page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            student=mapper.selectBysp_id(studentProject);

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

        return student;
    }

    public StudentProject selectByid( StudentProject studentProject) {
        StudentProject student=new StudentProject();
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            StudentProjectMapper mapper = sqlSession.getMapper(StudentProjectMapper.class);
            //page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            student=mapper.selectByid(studentProject);

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

        return student;
    }

    public int insertStudentProject(StudentProject studentProject) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        int result=0;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
           StudentProjectMapper mapper = sqlSession.getMapper(StudentProjectMapper.class);
            //5.执行方法
            result = mapper.insertStudentProject(studentProject);

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
        return  result;
    }

    public int deleteStudentProject(StudentProject studentProject) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        int result=0;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            StudentProjectMapper mapper = sqlSession.getMapper(StudentProjectMapper.class);
            //5.执行方法
           result = mapper.deleteStudentProject(studentProject);

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

    public int updateStudentProject(StudentProject studentProject) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        int result=0;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            StudentProjectMapper mapper = sqlSession.getMapper(StudentProjectMapper.class);
            //5.执行方法
            result = mapper.updateStudentProject(studentProject);

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


}
