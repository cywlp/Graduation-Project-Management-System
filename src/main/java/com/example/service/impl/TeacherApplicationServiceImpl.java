package com.example.service.impl;

import com.example.bean.TeacherApplication;
import com.example.bean.TeacherHistorySelect;
import com.example.mapper.TeacherApplicationMapper;
import com.example.mapper.TeacherHistorySelectMapper;
import com.example.service.TeacherApplicationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TeacherApplicationServiceImpl implements TeacherApplicationService {
    @Override
    public Page<TeacherApplication> selectByConditions(Integer currentPage, Integer pageSize, TeacherApplication teacherApplication) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<TeacherApplication> page = null;
        List<TeacherApplication > teacherApplications=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            TeacherApplicationMapper mapper = sqlSession.getMapper(TeacherApplicationMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            teacherApplications = mapper.selectByConditions(teacherApplication);

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
