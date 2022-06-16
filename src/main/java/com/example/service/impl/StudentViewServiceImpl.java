package com.example.service.impl;

import com.example.bean.Instruction_Student;
import com.example.bean.StudentView;
import com.example.mapper.Instruction_StudentMapper;
import com.example.mapper.StudentViewMapper;
import com.example.service.StudentViewService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentViewServiceImpl implements StudentViewService {
    public Page<StudentView> selectByS_number(Integer currentPage, Integer pageSize,StudentView studentView) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<StudentView> page = null;
        List<StudentView> studentViews=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            StudentViewMapper mapper = sqlSession.getMapper(StudentViewMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            studentViews= mapper.selectByS_number(studentView);

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
}
