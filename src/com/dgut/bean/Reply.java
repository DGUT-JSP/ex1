package com.dgut.bean;

import java.sql.Timestamp;

public class Reply {
	int id;
	int postId;
	String context; 
	Timestamp dateIssued;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Timestamp getDateIssued() {
		return dateIssued;
	}
	public void setDateIssued(Timestamp dateIssued) {
		this.dateIssued = dateIssued;
	}
	
}
