package com.dgut.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgut.bean.User;
import com.dgut.service.UserService;
import com.dgut.service.impl.UserServiceImpl;

/**
 * 用户注册
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获取用户的表单数据，封装到user对象
		User u = new User();
		u.setName(request.getParameter("name"));
		u.setPassword(request.getParameter("password"));
		u.setType(request.getParameter("type"));
		
		//调用业务逻辑
		UserService us = new UserServiceImpl();
		

		
		try {
			//判断用户名是否重复
			User result = us.findUserByName(u);
			//如果用户名不存在，注册
			if (result == null){
				us.addUser(u);
				//分发转向
				response.getWriter().write("ok,1 秒后到主页 ");
				response.setHeader("refresh", "1;url="+request.getContextPath()+"/index.jsp");
			}else{
				request.setAttribute("msg", "用户名重复");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
