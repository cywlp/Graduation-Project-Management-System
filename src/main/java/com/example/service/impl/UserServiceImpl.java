package com.example.service.impl;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> login_Admin(String number, String pwd) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        List<User> users=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setNumber(number);
            user.setPwd(pwd);
            //5.执行方法
            users = mapper.selectAllAdmin(user);

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

        return users;
    }

    @Override
    public List<User> login_Student(String number, String pwd) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        List<User> users=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setNumber(number);
            user.setPwd(pwd);
            //5.执行方法
            users = mapper.selectAllStudent(user);

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

        return users;
    }

    @Override
    public List<User> login_Teacher(String number, String pwd) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        List<User> users=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setNumber(number);
            user.setPwd(pwd);
            //5.执行方法
            users = mapper.selectAllTeacher(user);

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

        return users;
    }
}
