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
import com.dgut.bean.User;
import com.dgut.dao.UserInformationDao;
import com.dgut.dao.impl.UserInformationDaoImpl;
import com.dgut.service.PageService;
import com.dgut.service.PostService;
import com.dgut.service.impl.PageServiceImpl;
import com.dgut.service.impl.PostServiceImpl;

/**
 * Servlet implementation class ShowPost
 */
@WebServlet("/ShowPost")
public class ShowPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实例化业务逻辑
		PostService postService = new PostServiceImpl();
		//
		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		
		//每页显示记录数
		int pageSize =5;
		PageService ps = new PageServiceImpl();
		
		try {//将pb放入request中
			PageBean pb = ps.findAllPostWithPage(pageNum, pageSize);
			
			/**
			 * 这里根据拿到的这页用户id再拿头像地址
			 */
			UserInformationDao userInformationDao = new UserInformationDaoImpl();
			List<Post> postList = pb.getList();
			List<String> iconList = new ArrayList();
			for(Post post : postList){
				String id = post.getAuthorId()+"";
				iconList.add(userInformationDao.findHeadIconUrlByUserId(id));
			}
			
			//pb.getList();
			request.setAttribute("pageBean", pb);
			request.setAttribute("postList", pb.getList());
			request.setAttribute("iconList", iconList);
			request.getRequestDispatcher("/showPosts.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
