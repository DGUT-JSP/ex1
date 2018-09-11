package com.dgut.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgut.bean.Reply;
import com.dgut.service.ReplyService;
import com.dgut.service.impl.ReplyServiceImpl;

/**
 * Servlet implementation class AddReply
 */
@WebServlet("/AddReply")
public class AddReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyService rs = new ReplyServiceImpl();
		//获取表单信息
		String context = request.getParameter("context");
		int postId = Integer.valueOf(request.getParameter("postId"));
		//封装reply对象
		Reply reply = new Reply();
		reply.setContext(context);
		reply.setPostId(postId);
		try {
			//对象放进数据库
			rs.addReply(reply);
			response.sendRedirect(request.getContextPath()+"/ShowReply?postId="+postId+"&pageNum=1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
