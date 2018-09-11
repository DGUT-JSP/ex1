package com.dgut.service.impl;

import com.dgut.bean.Post;
import com.dgut.dao.PostDao;
import com.dgut.dao.impl.PostDaoImpl;
import com.dgut.service.PostService;

public class PostServiceImpl implements PostService {

	PostDao postDao = new PostDaoImpl();
	@Override
	public void addPost(Post post) throws Exception {
		postDao.addPost(post);
	}

	@Override
	public int deletePostById(int id) throws Exception {
		return postDao.deletePostById(id);
	}

	public Post findPostById(int id) throws Exception{
		return postDao.findPostById(id);
	}
}
