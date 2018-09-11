package com.dgut.service.impl;

import com.dgut.bean.Reply;
import com.dgut.dao.ReplyDao;
import com.dgut.dao.impl.ReplyDaoImpl;
import com.dgut.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {

	ReplyDao replyDao = new ReplyDaoImpl();
	@Override
	public void addReply(Reply reply) throws Exception {
		replyDao.addReply(reply);
	}

	@Override
	public int deleteReplyById(int id) throws Exception {
		return replyDao.deleteReplyById(id);
	}

}
