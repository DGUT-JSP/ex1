package com.dgut.service;

import com.dgut.bean.PageBean;
import com.dgut.bean.Post;
import com.dgut.bean.Reply;
import com.dgut.bean.User;

public interface PageService {

	public PageBean<User> findAllUserWithPage(int pageNum, int pageSize) throws Exception;
	
	public PageBean<Post> findAllPostWithPage(int pageNum, int pageSize) throws Exception;
	
	public PageBean<Reply> findAllReplyWithPageByPostId(int id, int pageNum, int pageSize) throws Exception;
}
