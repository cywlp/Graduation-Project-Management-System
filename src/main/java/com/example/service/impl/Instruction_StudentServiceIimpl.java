package com.example.service.impl;

import com.example.bean.Instruction_Student;

import com.example.mapper.InstructionMapper;
import com.example.mapper.Instruction_StudentMapper;
import com.example.service.Instruction_StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Instruction_StudentServiceIimpl implements Instruction_StudentService {
    //@Override
    public Page<Instruction_Student> selectInstructionByConditions(Integer currentPage, Integer pageSize,Instruction_Student instruction_student) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<Instruction_Student> page = null;
        List<Instruction_Student> instruction_students=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            Instruction_StudentMapper mapper = sqlSession.getMapper(Instruction_StudentMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
             instruction_students= mapper.selectInstructionByConditions(instruction_student);

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

    public Page<Instruction_Student> selectInstructionByContent(Integer currentPage, Integer pageSize,Instruction_Student instruction_student) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<Instruction_Student> page = null;
        List<Instruction_Student> instruction_students=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            Instruction_StudentMapper mapper = sqlSession.getMapper(Instruction_StudentMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            instruction_students= mapper.selectInstructionByContent(instruction_student);

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
