package com.dgut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgut.service.ReplyService;
import com.dgut.service.impl.ReplyServiceImpl;

/**
 * Servlet implementation class DeleteReply
 */
@WebServlet("/DeleteReply")
public class DeleteReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 此处应有权限判断
		 */
		
		ReplyService rs = new ReplyServiceImpl();
		int id = Integer.valueOf(request.getParameter("id"));
		try {
			rs.deleteReplyById(id);
			//哪里来回哪去
			response.sendRedirect(request.getHeader("Referer"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
