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

        //System.out.println("usrServlet");
//        Users users=new Users();
//        users.setId(1);
//        users.setLogin("admin122");
//        users.setName("管理员");
        //调用业务逻辑层Service进行逻辑处理
        Users users=userService.getUserById(1);
        resp.getWriter().print(users.getLogin());//服务器传递数据到客户端
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
