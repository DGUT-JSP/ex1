package com.dgut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dgut.bean.Reply;
import com.dgut.dao.ReplyDao;
import com.dgut.util.DBUtil;

public class ReplyDaoImpl implements ReplyDao {

	@Override
	public void addReply(Reply reply) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement("insert into reply(postId,replyContext) values(?,?)");
		System.out.println(ps);
		ps.setInt(1, reply.getPostId());
		ps.setString(2, reply.getContext());
		ps.executeUpdate();
	}

	@Override
	public int deleteReplyById(int id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		
		
		ps = conn.prepareStatement("delete from reply where replyId in(?)");
		ps.setInt(1, id);
		System.out.println(ps);
		return ps.executeUpdate();
	}

	@Override
	public List<Reply>  findReplyByPostId(int id)  throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		ps = conn.prepareStatement("SELECT * FROM reply where postId=?");
		ps.setInt(1,id);
		rs = ps.executeQuery();
		
		Reply reply = null;
		List<Reply> replyList = new ArrayList<>();
		
		while(rs.next()){
			reply = new Reply();
			reply.setId(rs.getInt("replyId"));
			reply.setPostId(rs.getInt("postId"));
			reply.setContext(rs.getString("replyContext"));
			reply.setDateIssued(rs.getTimestamp("dateIssued"));
			replyList.add(reply);
		}
		
		return replyList;
	}
	
	public List<Reply> findOnePageReplyByPostId(int id, Integer startIndex, Integer pageSize) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		ps = conn.prepareStatement("SELECT * FROM reply where postId=? limit " + startIndex.toString() + "," + pageSize.toString());
		ps.setInt(1, id);
		System.out.println(ps);
		rs = ps.executeQuery();
		
		Reply reply = null;
		List<Reply> replyList = new ArrayList<>();
		
		while(rs.next()){
			reply = new Reply();
			reply.setId(rs.getInt("replyId"));
			reply.setPostId(rs.getInt("postId"));
			reply.setContext(rs.getString("replyContext"));
			reply.setDateIssued(rs.getTimestamp("dateIssued"));
			
			replyList.add(reply);
		}
		
		
		return replyList;
	}
}
