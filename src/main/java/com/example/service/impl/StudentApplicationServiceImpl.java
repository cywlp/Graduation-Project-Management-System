package com.example.service.impl;

import com.example.bean.Student;
import com.example.bean.StudentApplication;
import com.example.mapper.StudentApplicationMapper;
import com.example.mapper.StudentMapper;
import com.example.service.StudentApplicationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentApplicationServiceImpl implements StudentApplicationService {
    @Override
    public Page<StudentApplication> selectByConditions(Integer currentPage, Integer pageSize, StudentApplication studentApplication) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<StudentApplication> page = null;
        List<StudentApplication> studentApplications=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            StudentApplicationMapper mapper = sqlSession.getMapper(StudentApplicationMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            studentApplications = mapper.selectByConditions(studentApplication);

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
