package com.dgut.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgut.bean.PageBean;
import com.dgut.bean.Post;
import com.dgut.dao.UserInformationDao;
import com.dgut.dao.impl.UserInformationDaoImpl;
import com.dgut.service.PageService;
import com.dgut.service.PostService;
import com.dgut.service.impl.PageServiceImpl;
import com.dgut.service.impl.PostServiceImpl;

/**
 * Servlet implementation class ShowReply
 */
@WebServlet("/ShowReply")
public class ShowReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		int postId = Integer.valueOf(request.getParameter("postId"));
		//每页显示记录数
		int pageSize =5;
		PageService ps = new PageServiceImpl();
		
		try {//将pb放入request中
			PageBean pb = ps.findAllReplyWithPageByPostId(postId, pageNum, pageSize);
			
			/**
			 * 拿到postContext，传入request
			 */
			PostService postService = new PostServiceImpl();
			Post post = postService.findPostById(postId);
			
			
			
			
			/**
			 * 这里功能阉割掉
			 */
//			UserInformationDao userInformationDao = new UserInformationDaoImpl();
//			List<Post> postList = pb.getList();
//			List<String> iconList = new ArrayList();
//			for(Post post : postList){
//				String id = post.getAuthorId()+"";
//				iconList.add(userInformationDao.findHeadIconUrlByUserId(id));
//			}
			
			//pb.getList();
			//将当前postId放入request
			request.setAttribute("post", post);
			
			request.setAttribute("pageBean", pb);
			request.setAttribute("replyList", pb.getList());
			//request.setAttribute("iconList", iconList);
			request.getRequestDispatcher("/showReply.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
