package com.example.service.impl;

import com.example.bean.ReviewerGrades;
import com.example.mapper.TeacherMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.example.mapper.ReviewerGradesMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.example.service.ReviewerGradesService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ReviewerGradesServiceImpl implements ReviewerGradesService {
    @Override
    public boolean addReviewerGrades(ReviewerGrades reviewerGrades) {
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
            ReviewerGradesMapper mapper = sqlSession.getMapper(ReviewerGradesMapper.class);
            //5.执行方法
            mapper.addReviewerGrades(reviewerGrades);


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
        return  true;
    }

    @Override
    public boolean deleteReviewerGrades(ReviewerGrades reviewerGrades) {
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
            ReviewerGradesMapper mapper = sqlSession.getMapper(ReviewerGradesMapper.class);
            //5.执行方法
            mapper.deleteReviewerGrades(reviewerGrades);

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
        return  true;
    }

    @Override
    public boolean updateReviewerGrades(ReviewerGrades reviewerGrades) {
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
            ReviewerGradesMapper mapper = sqlSession.getMapper(ReviewerGradesMapper.class);
            //5.执行方法
            mapper.updateReviewerGrades(reviewerGrades);

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
        return  true;
    }

    @Override
    public Page<ReviewerGrades> selectByConditions(Integer currentPage, Integer pageSize, ReviewerGrades reviewerGrades) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        Page<ReviewerGrades> page = null;
        List<ReviewerGrades > reviewerGrades1=null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            ReviewerGradesMapper mapper = sqlSession.getMapper(ReviewerGradesMapper.class);
            page= PageHelper.startPage(currentPage,pageSize);
            //5.执行方法
            reviewerGrades1 = mapper.selectByConditions(reviewerGrades);

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
            ReviewerGradesMapper mapper = sqlSession.getMapper(ReviewerGradesMapper.class);
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
    public ReviewerGrades selectByS_number(String s_number) {
        InputStream resourceAsStream=null;
        SqlSession sqlSession=null;
        ReviewerGrades reviewerGrades =new ReviewerGrades();
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            ReviewerGradesMapper mapper = sqlSession.getMapper(ReviewerGradesMapper.class);
            //5.执行方法
           reviewerGrades= mapper.selectByS_number(s_number);

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
       return reviewerGrades;
    }
}
