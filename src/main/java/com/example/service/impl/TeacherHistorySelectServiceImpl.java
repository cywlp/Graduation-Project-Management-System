package com.example.service.impl;

import com.example.bean.Student_Select;
import com.example.bean.TeacherHistorySelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.example.mapper.Student_SelectMapper;
import com.example.mapper.TeacherHistorySelectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.example.service.TeacherHistorySelectService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TeacherHistorySelectServiceImpl implements TeacherHistorySelectService {
    @Override
    public Page<TeacherHistorySelect> selectByConditions(Integer currentPage, Integer pageSize, TeacherHistorySelect teacherHistorySelect) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<TeacherHistorySelect> page = null;
        List<TeacherHistorySelect > teacherHistorySelects=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            TeacherHistorySelectMapper mapper = sqlSession.getMapper(TeacherHistorySelectMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            teacherHistorySelects = mapper.selectByConditions(teacherHistorySelect);

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
