package com.dgut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dgut.bean.Post;
import com.dgut.dao.PostDao;
import com.dgut.util.DBUtil;

public class PostDaoImpl implements PostDao {

	@Override
	public void addPost(Post post) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement("insert into post(authorId,postContext) values(?,?)");
		System.out.println(ps);
		ps.setInt(1, post.getAuthorId());
		ps.setString(2, post.getContext());
		ps.executeUpdate();
	}

	@Override
	public int deletePostById(int id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		
		
		ps = conn.prepareStatement("delete from post where postId in(?)");
		ps.setInt(1, id);
		System.out.println(ps);
		return ps.executeUpdate();
	}
	
	

	@Override
	public Post findPostById(int id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		ps = conn.prepareStatement("SELECT * FROM post where postId=?");
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		Post post = null;
		if(rs.next()){
			post = new Post();
			post.setId(rs.getInt("postId"));
			post.setAuthorId(rs.getInt("authorId"));
			post.setContext(rs.getString("postContext"));
			post.setDateIssued(rs.getTimestamp("dateIssued"));
		}
		return post;
	}

	@Override
	public List<Post> findAllPost() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		ps = conn.prepareStatement("SELECT * FROM post");
		rs = ps.executeQuery();
		
		Post post = null;
		List<Post> postList = new ArrayList<>();
		
		while(rs.next()){
			post = new Post();
			post.setId(rs.getInt("postId"));
			post.setAuthorId(rs.getInt("authorId"));
			post.setContext(rs.getString("postContext"));
			post.setDateIssued(rs.getTimestamp("dateIssued"));
			postList.add(post);
		}
		
		return postList;
	}
	
	public List<Post> findOnePagePost(Integer startIndex, Integer pageSize) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		ps = conn.prepareStatement("SELECT * FROM post limit " + startIndex.toString() + "," + pageSize.toString());
		rs = ps.executeQuery();
		
		Post post = null;
		List<Post> postList = new ArrayList<>();
		
		while(rs.next()){
			post = new Post();
			post.setId(rs.getInt("postId"));
			post.setAuthorId(rs.getInt("authorId"));
			post.setContext(rs.getString("postContext"));
			post.setDateIssued(rs.getTimestamp("dateIssued"));
			postList.add(post);
		}
		
		
		return postList;
	}
}
