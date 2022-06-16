package com.example.service.impl;

import com.example.bean.Instruction;
import com.example.bean.InstructionTwo;
import com.example.bean.TeacherHistorySelect;
import com.example.mapper.InstructionMapper;
import com.example.mapper.TeacherHistorySelectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.example.service.InstructionService;

import javax.xml.transform.Result;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InstructionServiceImpl implements InstructionService {
    //@Override
    public void addInstruction( Instruction instruction) {
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
            InstructionMapper mapper = sqlSession.getMapper(InstructionMapper.class);
            //page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            mapper.addInstruction(instruction);

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


    public void deleteInstruction(Instruction instruction) {
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
            InstructionMapper mapper = sqlSession.getMapper(InstructionMapper.class);
            //5.执行方法
            mapper.deleteInstruction(instruction);

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

    public void updateInstruction( Instruction instruction) {
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
            InstructionMapper mapper = sqlSession.getMapper(InstructionMapper.class);
            //page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
             mapper.updateInstruction(instruction);

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

    @Override
    public Page<InstructionTwo> selectInstructionTwo(Integer currentPage, Integer pageSize, InstructionTwo instructionTwo) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<InstructionTwo> page = null;
        List<InstructionTwo > instructionTwos=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            InstructionMapper mapper = sqlSession.getMapper(InstructionMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            mapper.selectInstructionTwo(instructionTwo);

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
    public int updateInstructionFinish(Instruction instruction) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        int Result = 0;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            InstructionMapper mapper = sqlSession.getMapper(InstructionMapper.class);
            //page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            Result=mapper.updateInstructionFinish(instruction);

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


        return Result;
    }
}
