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
import com.dgut.service.impl.UserInformationServiceImpl;

/**
 * Servlet implementation class UpdatePrivate
 */
@WebServlet("/UpdatePrivate")
public class UpdatePrivate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInformationService uis = new UserInformationServiceImpl();
		int id = Integer.parseInt(request.getParameter("userId"));
		String gender = request.getParameter("gender");
		String briefIntroduction = request.getParameter("briefIntroduction");
		String nickName = request.getParameter("nickName");
		
		System.out.println(id);
		//封装到对象
		UserInformation ui = new UserInformation();
		ui.setUserId(id);
		ui.setGender(gender);
		ui.setNickName(nickName);
		ui.setBriefIntroduction(briefIntroduction);
		System.out.println(ui.toString());
		try {
			uis.updateUserInformation(ui);
			//更新个人信息后请求转发到个人信息界面
			request.getRequestDispatcher("/ShowPrivate?userId="+request.getParameter("userId")).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
