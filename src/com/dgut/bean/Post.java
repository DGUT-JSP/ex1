package com.dgut.bean;

import java.sql.Timestamp;

public class Post {
	int id;
	int authorId;
	String context;
	Timestamp dateIssued;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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
