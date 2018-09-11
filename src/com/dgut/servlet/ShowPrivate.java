package com.dgut.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgut.bean.User;
import com.dgut.bean.UserInformation;
import com.dgut.service.UserInformationService;
import com.dgut.service.UserService;
import com.dgut.service.impl.UserInformationServiceImpl;
import com.dgut.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShowPrivate
 */
@WebServlet("/ShowPrivate")
public class ShowPrivate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInformationService uis = new UserInformationServiceImpl();
		UserService us = new UserServiceImpl();
		//UserService us = new UserServiceImpl();
		try {
			UserInformation ui = uis.findByUserId(request.getParameter("userId"));
			//从数据库获取该id的用户对象
			User uo = us.findUserById(Integer.parseInt(request.getParameter("userId")));
			//System.out.println(uo.getName());
			if(ui!=null){
				request.setAttribute("userInformation", ui);
				//将要查看的对象信息放入session
				request.getSession().setAttribute("userObj",uo);
				request.getRequestDispatcher("/user/showPrivate.jsp").forward(request, response);
			}else{//不存在则新建用户信息
				ui = new UserInformation();
				ui.setUserId(Integer.parseInt(request.getParameter("userId")));
				uis.addUserInformation(ui);
				//新建后再请求一次
				request.getRequestDispatcher("/ShowPrivate?userId="+request.getParameter("userId")).forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
