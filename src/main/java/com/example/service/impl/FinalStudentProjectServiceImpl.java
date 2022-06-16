package com.example.service.impl;

import com.example.bean.DefenseGrades;
import com.example.bean.FinalStudentProject;
import com.example.bean.Instruction_Student;
import com.example.bean.StudentProject;
import com.example.mapper.DefenseGradesMapper;
import com.example.mapper.FinalStudentProjectMapper;
import com.example.mapper.Instruction_StudentMapper;
import com.example.mapper.StudentProjectMapper;
import com.example.service.FinalStudentProjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FinalStudentProjectServiceImpl implements FinalStudentProjectService {
    public Page<FinalStudentProject> selectBySp_id(Integer currentPage, Integer pageSize, FinalStudentProject finalStudentProject) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<FinalStudentProject> page = null;
        List<FinalStudentProject> finalStudentProjects=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            FinalStudentProjectMapper mapper = sqlSession.getMapper(FinalStudentProjectMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            finalStudentProjects= mapper.selectBySpid(finalStudentProject);

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
        return  page;
    }

    public FinalStudentProject selectByid( FinalStudentProject finalStudentProject) {
        FinalStudentProject student=new FinalStudentProject();
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
            FinalStudentProjectMapper mapper = sqlSession.getMapper(FinalStudentProjectMapper.class);
            //page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            student=mapper.selectByid(finalStudentProject);

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

    public Page<FinalStudentProject> selectBynumber(Integer currentPage, Integer pageSize, FinalStudentProject finalStudentProject) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<FinalStudentProject> page = null;
        List<FinalStudentProject> finalStudentProjects=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            FinalStudentProjectMapper mapper = sqlSession.getMapper(FinalStudentProjectMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            finalStudentProjects= mapper.selectBynumber(finalStudentProject);

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
        return  page;
    }
    //@Override
    public void insertFinalStudentProject(FinalStudentProject finalStudentProject) {
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
            FinalStudentProjectMapper mapper = sqlSession.getMapper(FinalStudentProjectMapper.class);
            //5.执行方法
            mapper.insertFinalStudentProject(finalStudentProject);

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

    }

    public void deleteFinalStudentProject(StudentProject studentProject) {
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
            FinalStudentProjectMapper mapper = sqlSession.getMapper(FinalStudentProjectMapper.class);
            //5.执行方法
            mapper.deleteFinalStudentProject(studentProject);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void updateFinalStudentProject(FinalStudentProject finalStudentProject) {
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
            FinalStudentProjectMapper mapper = sqlSession.getMapper(FinalStudentProjectMapper.class);
            //5.执行方法
            mapper.updateFinalStudentProject(finalStudentProject);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
