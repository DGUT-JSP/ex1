package com.dgut.service.impl;

import java.util.List;

import com.dgut.bean.PageBean;
import com.dgut.bean.Post;
import com.dgut.bean.Reply;
import com.dgut.bean.User;
import com.dgut.dao.PostDao;
import com.dgut.dao.ReplyDao;
import com.dgut.dao.UserDao;
import com.dgut.dao.impl.PostDaoImpl;
import com.dgut.dao.impl.ReplyDaoImpl;
import com.dgut.dao.impl.UserDaoImpl;
import com.dgut.service.PageService;

public class PageServiceImpl implements PageService {

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public PageBean<User> findAllUserWithPage(int pageNum, int pageSize) throws Exception{
		List<User> userList = userDao.findAllUser();
		
		int totalRecord = userList.size();
		
		PageBean pb = new PageBean<User>(pageNum, pageSize, totalRecord);
		int startIndex = pb.getStartIndex();
		
		//拿到每页的数据
		pb.setList(userDao.findOnePageUser(startIndex, pageSize));
		
		
		
		return pb;
	}

	@Override
	public PageBean<Post> findAllPostWithPage(int pageNum, int pageSize) throws Exception {
		
		PostDao postDao = new PostDaoImpl();
		List<Post> postList = postDao.findAllPost();
		
		int totalRecord = postList.size();
		
		PageBean pb = new PageBean<List>(pageNum, pageSize, totalRecord);
		int startIndex = pb.getStartIndex();
		
		//拿到每页的数据
		pb.setList(postDao.findOnePagePost(startIndex, pageSize));
		
		return pb;
	}

	@Override
	public PageBean<Reply> findAllReplyWithPageByPostId(int id, int pageNum, int pageSize) throws Exception {
		ReplyDao replyDao = new ReplyDaoImpl();
		List<Reply> replyList = replyDao.findReplyByPostId(id);
		
		int totalRecord = replyList.size();
		
		PageBean pb = new PageBean<List>(pageNum, pageSize, totalRecord);
		int startIndex = pb.getStartIndex();
		
		//拿到每页的数据
		pb.setList(replyDao.findOnePageReplyByPostId(id, startIndex, pageSize));
		
		return pb;
	}
	

}
