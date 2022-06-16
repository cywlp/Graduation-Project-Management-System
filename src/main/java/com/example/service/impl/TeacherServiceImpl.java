package com.example.service.impl;

import com.example.service.TeacherService;
import com.example.bean.Teacher;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.example.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    @Override
    public Page selectAll(Integer currentPage, Integer pageSize) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page page = null;
        List<Teacher> teachers=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            teachers = mapper.selectAll();

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
    public Page<Teacher> selectByT_id(Integer currentPage, Integer pageSize, Teacher teacher) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<Teacher> page = null;
        List<Teacher> teachers=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            teachers = mapper.selectByT_id(teacher);

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


//TODO:change
    @Override
    public boolean addTeacher(Teacher teacher) {
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
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            //5.执行方法
            mapper.addTeacher(teacher);

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

        return true;
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
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
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            //5.执行方法
            mapper.deleteTeacher(teacher);

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
    public void updateTeacher(Teacher teacher) {
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
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            //5.执行方法
            mapper.updateTeacher(teacher);

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
    public Page<Teacher> selectByConditions(Integer currentPage, Integer pageSize, Teacher teacher) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<Teacher> page = null;
        List<Teacher> teachers=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            teachers = mapper.selectByConditions(teacher);

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
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
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
}
