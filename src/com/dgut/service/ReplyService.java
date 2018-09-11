package com.dgut.service;

import com.dgut.bean.Reply;

public interface ReplyService {
	public void addReply(Reply reply) throws Exception;
	
	public int deleteReplyById(int id) throws Exception;
}
