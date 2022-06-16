package com.example.service.impl;


import com.example.bean.Student_Select;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.example.mapper.Student_SelectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.example.service.Student_SelectService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Student_SelectServiceImpl implements Student_SelectService {
    @Override
    public Page<Student_Select> selectByConditions(Integer currentPage, Integer pageSize, Student_Select student_select) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<Student_Select> page = null;
        List<Student_Select > student_selects=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            Student_SelectMapper mapper = sqlSession.getMapper(Student_SelectMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            student_selects = mapper.selectByConditions(student_select);

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
    public Page<Student_Select> unSelect(Integer currentPage, Integer pageSize, Student_Select student_select) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<Student_Select> page = null;
        List<Student_Select > student_selects=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            Student_SelectMapper mapper = sqlSession.getMapper(Student_SelectMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            student_selects = mapper.unSelect(student_select);

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
