package com.example.service.impl;

import com.example.bean.InstructorGrades;
import com.example.bean.ReviewerGrades;
import com.example.bean.Student;
import com.example.mapper.InstructorGradesMapper;
import com.example.mapper.ReviewerGradesMapper;
import com.example.service.InstructorGradesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InstructorGradesServiceImpl implements InstructorGradesService {
    @Override
    public boolean addInstructorGrades(InstructorGrades instructorGrades) {
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
            InstructorGradesMapper mapper = sqlSession.getMapper(InstructorGradesMapper.class);
            //5.执行方法
            mapper.addInstructorGrades(instructorGrades);


        } catch (IOException e) {
            e.printStackTrace();
            return false;
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
        return  true;
    }

    @Override
    public boolean deleteInstructorGrades(InstructorGrades instructorGrades) {
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
            InstructorGradesMapper mapper = sqlSession.getMapper(InstructorGradesMapper.class);
            //5.执行方法
            mapper.deleteInstructorGrades(instructorGrades);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
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
        return  true;
    }

    @Override
    public boolean updateInstructorGrades(InstructorGrades instructorGrades) {
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
            InstructorGradesMapper mapper = sqlSession.getMapper(InstructorGradesMapper.class);
            //5.执行方法
            mapper.updateInstructorGrades(instructorGrades);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
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
        return  true;
    }

    @Override
    public Page<InstructorGrades> selectByConditions(Integer currentPage, Integer pageSize, InstructorGrades instructorGrades) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<InstructorGrades> page = null;
        List<InstructorGrades > instructorGrades1=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            InstructorGradesMapper mapper = sqlSession.getMapper(InstructorGradesMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            instructorGrades1 = mapper.selectByConditions(instructorGrades);

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

    @Override
    public Integer getMaxId() {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Integer maxId=0;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            InstructorGradesMapper mapper = sqlSession.getMapper(InstructorGradesMapper.class);
            //5.执行方法
            maxId = mapper.getMaxId();

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
        return maxId+1;
    }

    @Override
    public InstructorGrades selectByS_number(String s_number) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
 InstructorGrades instructorGrades =new InstructorGrades();
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            InstructorGradesMapper mapper = sqlSession.getMapper(InstructorGradesMapper.class);
            //5.执行方法
         instructorGrades  = mapper.selectByS_number(s_number);

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
       return instructorGrades;
    }
}
