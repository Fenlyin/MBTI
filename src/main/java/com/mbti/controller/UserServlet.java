package com.mbti.controller;

import com.mbti.entity.Users;
import com.mbti.service.UserService;
import com.mbti.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制器：针对用户的请求，接收前端发过来的请求（参数）
 * 引入jar包（仅引入一次）
 * 1、定义类继承HttpServlet
 * 2、类上添加注解@WebServlet，指定映射地址
 * 3、重写doGet/doPost方法
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    //重写doGet/doPost

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //获取操作类型，根据不同操作进行处理
            String opr=req.getParameter("opr");
            if(opr.equals("login")){
                //获取登录名、密码，判断是否匹配
                String login=req.getParameter("login");//获取前端请求提交的参数
                String passwd=req.getParameter("passwd");
                //调用业务逻辑层进行身份验证
                Users users=userService.getLoginUser(login,passwd);
                if(users!=null){
                    //把用户存在session对象中
                    req.getSession().setAttribute("current_user",users);
                    //登录成功，跳转到主页面
                    req.getRequestDispatcher("WEB-INF/pages/main.jsp").forward(req,resp);

                }else {
                    //重新登录,重定向
                    resp.sendRedirect("login.jsp");
                }
            }else if(opr.equals("logout")){//退出登录
                //移除session存储的数据
                req.getSession().removeAttribute("login");
                //设置session为无效
                req.getSession().invalidate();
                //打开登录页面
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
