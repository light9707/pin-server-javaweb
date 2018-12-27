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

@SuppressWarnings("serial")
public class loginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	       //设置编码模式
	        request.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	       //获取表单数据, 并将表单数据存入到login函数中
	        String name = request.getParameter("username");
	        String pwd = request.getParameter("password");
	       //处理业务逻辑，实现login 方法，里面涉及到finduser方法
	         UserService us = new UserServiceImpl();//
	         User u =us.login(name,pwd);
	       //分发转向
	        if(u!=null){    
	            out.write("<br/>欢迎你，登陆成功，3秒跳转首页");
	            request.setAttribute("u", u.getUsername());
	            request.getRequestDispatcher("/success.jsp").forward(request, response);
	        }else{
	            //实现刷新功能
	            out.write("用户名或密码错误，请重新登陆");
	            response.setHeader("refresh","1;url=/DPshop_user/login.jsp");
	                }          
	    }
	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	            doGet(request, response);
	    }
	}