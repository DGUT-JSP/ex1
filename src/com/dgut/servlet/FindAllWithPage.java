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
import com.dgut.bean.User;
import com.dgut.dao.UserInformationDao;
import com.dgut.dao.impl.UserInformationDaoImpl;
import com.dgut.service.PageService;
import com.dgut.service.impl.PageServiceImpl;

/**
 * Servlet implementation class FindAllWithPage
 */
@WebServlet("/FindAllWithPage")
public class FindAllWithPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		/**
		 * 不是管理员没有权限看
		 */
		String type = ((User)request.getSession().getAttribute("user")).getType();
		//System.out.println(type);
		if(!type.equals("manager")){
			
			response.getWriter().write("没有权限,1 秒后到主页 ");
			response.setHeader("refresh", "1;url="+request.getContextPath()+"/index.jsp");
		}else{
		
			int pageNum = Integer.valueOf(request.getParameter("pageNum"));
			
			//每页显示记录数
			int pageSize =5;
			PageService ps = new PageServiceImpl();
			
			try {//将pb放入request中
				PageBean pb = ps.findAllUserWithPage(pageNum, pageSize);
				
				/**
				 * 这里根据拿到的这页用户id再拿头像地址
				 */
				UserInformationDao userInformationDao = new UserInformationDaoImpl();
				List<User> userList = pb.getList();
				List<String> iconList = new ArrayList();
				for(User user : userList){
					String id = user.getId()+"";
					iconList.add(userInformationDao.findHeadIconUrlByUserId(id));
				}
				
				//pb.getList();
				request.setAttribute("pageBean", pb);
				request.setAttribute("userList", pb.getList());
				request.setAttribute("iconList", iconList);
				request.getRequestDispatcher("/user/showUsers.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
