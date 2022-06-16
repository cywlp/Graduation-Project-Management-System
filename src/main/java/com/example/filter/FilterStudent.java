package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 学生端过滤器
 */
@WebFilter(filterName = "FilterStudent",value = {"/index_student.html"})
public class FilterStudent implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        try{
            //1.将请求和响应对象转换为和HTTP协议相关
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            //2.获取会话域对象中数据
            Object power = request.getSession().getAttribute("power");

            //3.判断用户名
            if(power==null || (Integer) power != 1) {
                //重定向到登录页面
                response.sendRedirect(request.getContextPath() + "/login.html");
                return;
            }

            //4.放行
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
