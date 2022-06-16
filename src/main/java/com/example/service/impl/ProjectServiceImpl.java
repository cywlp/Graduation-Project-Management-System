package com.example.service.impl;

import com.example.bean.Project;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.example.mapper.ProjectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.example.service.ProjectService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    @Override
    public Page selectAll(Integer currentPage, Integer pageSize) {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        Page page = null;
        List<Project> projects = null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
            page = PageHelper.startPage(currentPage, pageSize);
            //5.执行方法
            projects = mapper.selectAll();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        return page;
    }

    @Override
    public Page<Project> selectByP_id(Integer currentPage, Integer pageSize, Project project) {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        Page<Project> page = null;
        List<Project> projects = null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
            page = PageHelper.startPage(currentPage, pageSize);
            //5.执行方法
            projects = mapper.selectByP_id(project);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

        return page;
    }


    @Override
    public int addProject(Project project) {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        int result = 0;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
            //5.执行方法
            result = mapper.addProject(project);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        return result;
    }

    @Override
    public int deleteProject(Project project) {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        int result = 0;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
            //5.执行方法
            mapper.deleteProject(project);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        return result;
    }

    @Override
    public int updateProject(Project project) {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        int result=0;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
            //5.执行方法
            result=mapper.updateProject(project);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        return result;
    }

    @Override
    public Page<Project> selectByConditions(Integer currentPage, Integer pageSize, Project project) {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        Page<Project> page = null;
        List<Project> projects = null;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
            page = PageHelper.startPage(currentPage, pageSize);
            //5.执行方法
            projects = mapper.selectByConditions(project);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

        return page;
    }

    @Override
    public Integer getMaxId() {
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        Integer maxId = 0;
        try {
            //1.引入MyBatisConfig.xml
            resourceAsStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.创建SqlSession工厂对象
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //3.创建SQL session对象
            sqlSession = build.openSession(true);
            //4.创建Mapper实现类
            ProjectMapper mapper = sqlSession.getMapper(ProjectMapper.class);
            //5.执行方法
            maxId = mapper.getMaxId();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        return maxId + 1;

    }
}
