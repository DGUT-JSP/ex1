package com.dgut.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgut.service.PostService;
import com.dgut.service.impl.PostServiceImpl;

/**
 * Servlet implementation class DeletePost
 */
@WebServlet("/DeletePost")
public class DeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostService ps = new PostServiceImpl();
		int id = Integer.valueOf(request.getParameter("id"));
		
		try {
			ps.deletePostById(id);
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
