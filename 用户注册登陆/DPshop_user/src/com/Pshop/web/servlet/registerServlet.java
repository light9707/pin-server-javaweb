package com.Pshop.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Pshop.damian.User;
import com.Pshop.service.UserService;
import com.Pshop.service.impl.UserServiceImpl;

public class registerServlet extends HttpServlet {
    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         //设置编码模式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int i =0;
        //获取表单数据
               String name =  request.getParameter("username");
               String pwd =  request.getParameter("password");
            try {
              //将获取到的表单数据封装到u中
              User   u = new User(name,pwd);
              UserService us = new  UserServiceImpl();//这在上文有解析
             //对封装在u中的数据进行注册，使其记录在数据库表中
              i = us.register(u);//这也在上文有解析
              if(i!=0)
              {
                 out.write("注册成功,信息如下：<br>");
                 out.write("<br>姓名："+u.getUsername());
                 
               }else {
                 out.write("注册信息不成功");
                }  
            } catch (Exception e) {
               e.printStackTrace();
            }
       
        //处理业务逻辑
        //分发转向
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
      }
}