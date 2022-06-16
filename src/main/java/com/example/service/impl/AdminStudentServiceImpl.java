package com.example.service.impl;

import com.example.bean.AdminStudent;
import com.example.bean.Student;
import com.example.mapper.AdminStudentMapper;
import com.example.mapper.StudentMapper;
import com.example.service.AdminStudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AdminStudentServiceImpl implements AdminStudentService {
    @Override
    public Page<AdminStudent> selectByConditions(Integer currentPage, Integer pageSize, AdminStudent adminstudent) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<AdminStudent > page = null;
        List<AdminStudent > adminstudents=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            AdminStudentMapper mapper = sqlSession.getMapper(AdminStudentMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            adminstudents = mapper.selectByConditionsPlus(adminstudent);

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
