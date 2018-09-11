package com.dgut.dao;

import java.util.List;

import com.dgut.bean.Post;

public interface PostDao {

	public void addPost(Post post) throws Exception;
	
	public int deletePostById(int id) throws Exception;
	
	public Post findPostById(int id) throws Exception;
	
	public List<Post> findAllPost() throws Exception;
	
	public List<Post> findOnePagePost(Integer startIndex, Integer pageSize) throws Exception;
}
