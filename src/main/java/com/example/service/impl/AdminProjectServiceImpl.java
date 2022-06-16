package com.example.service.impl;

import com.example.bean.AdminProject;
import com.example.mapper.AdminProjectMapper;
import com.example.service.AdminProjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AdminProjectServiceImpl implements AdminProjectService {
    @Override
    public Page<AdminProject> selectByConditions(Integer currentPage, Integer pageSize, AdminProject adminProject) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<AdminProject> page = null;
        List<AdminProject > adminProjects=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            AdminProjectMapper mapper = sqlSession.getMapper(AdminProjectMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            adminProjects = mapper.queryAdminProject(adminProject);

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
    public Page<AdminProject> queryAdminProject(Integer currentPage, Integer pageSize, AdminProject adminProject) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<AdminProject > page = null;
        List<AdminProject > adminProjects=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            AdminProjectMapper mapper = sqlSession.getMapper(AdminProjectMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            adminProjects = mapper.queryAdminProject(adminProject);

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
