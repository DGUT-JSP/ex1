package com.dgut.service;

import com.dgut.bean.Post;

public interface PostService {
	public void addPost(Post post) throws Exception;
	
	public int deletePostById(int id) throws Exception;
	
	public Post findPostById(int id) throws Exception;
}
