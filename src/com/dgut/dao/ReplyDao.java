package com.dgut.dao;

import java.util.List;

import com.dgut.bean.Reply;

public interface ReplyDao {

	public void addReply(Reply reply) throws Exception;
	
	public int deleteReplyById(int id) throws Exception;
	
	public List<Reply> findReplyByPostId(int id) throws Exception;
	
	//返回那页回复的列表
	public List<Reply> findOnePageReplyByPostId(int id, Integer startIndex, Integer pageSize) throws Exception;
}
