package com.example.service.impl;

import com.example.bean.AdminTeacher;
import com.example.mapper.AdminTeacherMapper;
import com.example.service.AdminTeacherService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AdminTeacherServiceImpl implements AdminTeacherService {
    @Override
    public Page<AdminTeacher> selectByConditions(Integer currentPage, Integer pageSize, AdminTeacher adminTeacher) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<AdminTeacher> page = null;
        List<AdminTeacher > adminTeachers=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            AdminTeacherMapper mapper = sqlSession.getMapper(AdminTeacherMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            adminTeachers = mapper.queryAdminTeacher(adminTeacher);

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
    public Page<AdminTeacher> queryAdminTeacher(Integer currentPage, Integer pageSize, AdminTeacher adminTeacher) {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        Page<AdminTeacher> page = null;
        List<AdminTeacher> adminTeachers = null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            AdminTeacherMapper mapper = sqlSession.getMapper(AdminTeacherMapper.class);
            page = PageHelper.startPage(currentPage, pageSize);
            //5.执行方法
            adminTeachers = mapper.queryAdminTeacher(adminTeacher);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        return page;
    }
}
