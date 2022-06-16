package com.example.service.impl;

import com.example.bean.DefenseGrades;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.example.mapper.DefenseGradesMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.example.service.DefenseGradesService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DefenseGradesServiceImpl implements DefenseGradesService {
    //@Override
    @Override
    public Page<DefenseGrades> selectBydg_id(Integer currentPage, Integer pageSize, DefenseGrades defenseGrades) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<DefenseGrades> page = null;
        List<DefenseGrades> defenseGrades1=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            DefenseGradesMapper mapper = sqlSession.getMapper(DefenseGradesMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            defenseGrades1 = mapper.selectBydg_id(defenseGrades);

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
    public void insertDefensGrades(DefenseGrades defenseGrades) {
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
            DefenseGradesMapper mapper = sqlSession.getMapper(DefenseGradesMapper.class);
            //5.执行方法
            mapper.insertDefenseGrades(defenseGrades);

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
    public void deleteDefensGrades(DefenseGrades defenseGrades) {
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
            DefenseGradesMapper mapper = sqlSession.getMapper(DefenseGradesMapper.class);
            //5.执行方法
            mapper.deleteDefenseGrades(defenseGrades);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void updateDefensGrades(DefenseGrades defenseGrades) {
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
            DefenseGradesMapper mapper = sqlSession.getMapper(DefenseGradesMapper.class);
            //5.执行方法
            mapper.updateDefenseGrades(defenseGrades);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
            DefenseGradesMapper mapper = sqlSession.getMapper(DefenseGradesMapper.class);
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

    @Override
    public DefenseGrades selectByS_number(String s_number) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
DefenseGrades defenseGrades =new DefenseGrades();
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            DefenseGradesMapper mapper = sqlSession.getMapper(DefenseGradesMapper.class);
            //5.执行方法
            defenseGrades = mapper.selectByS_number(s_number);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  defenseGrades;
    }

}
