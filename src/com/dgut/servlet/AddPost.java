package com.dgut.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dgut.bean.Post;
import com.dgut.bean.User;
import com.dgut.service.PostService;
import com.dgut.service.impl.PostServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/AddPost")
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获取表单数据
		Post post = new Post();
		post.setAuthorId(((User)request.getSession().getAttribute("user")).getId());
		post.setContext(request.getParameter("context"));
		//调用业务逻辑
		PostService ps = new PostServiceImpl();
		try {
			ps.addPost(post);
			response.getWriter().write("ok,1 秒后到帖子页 ");
			response.setHeader("refresh", "1;url="+request.getContextPath()+"/ShowPost?pageNum=1");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
