package com.mbti.controller;

import com.mbti.entity.AssessmentType;
import com.mbti.entity.PersonalityDimension;
import com.mbti.service.AssessmentTypeService;
import com.mbti.service.DimensionService;
import com.mbti.service.impl.AssessmentTypeServiceImpl;
import com.mbti.service.impl.DimensionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 性格维度的控制器：处理跟性格维度相关的请求
 */
@WebServlet("/dimension")
public class DimensionServlet extends HttpServlet {
    DimensionService dimensionService=new DimensionServiceImpl();
    AssessmentTypeService assessmentTypeService=new AssessmentTypeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //根据不同的操作类型进行判断，分别进行不同的处理
        String opr=req.getParameter("opr");
        if("list".equals(opr)){//打开展示性格维度列表的页面：请求数据库，获取性格维度的所有记录，传递给前端页面
            //调用业务逻辑层相关方法
            List<PersonalityDimension> dimensionList=dimensionService.getDimensionList();
            List<AssessmentType> assessmentTypeList=assessmentTypeService.getAssessmentTypeList();
            //把列表 保存在reques对象中(性格维度、考核类型)
            req.setAttribute("dimensionList",dimensionList);
            req.setAttribute("assessmentList",assessmentTypeList);
            req.getRequestDispatcher("WEB-INF/pages/dimension/list.jsp").forward(req,resp);
        } else if ("view".equals(opr)) {//查看相关性格维度信息
            //获取性格的id
            String idStr=req.getParameter("id");
            //根据前端页面传过来id获取对应性格维度对象的信息
            PersonalityDimension p=dimensionService.getPdById(Integer.valueOf(idStr));
            req.setAttribute("dimension",p);
            //打开view.jsp
            req.getRequestDispatcher("WEB-INF/pages/dimension/view.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
