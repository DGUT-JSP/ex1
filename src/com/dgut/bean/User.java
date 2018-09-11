package com.dgut.bean;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 用户表(t_user)
 * @author DELL
 *
 */
public class User {
	
	private int id;
	private String name;
	private String password;
	private String type;
	private Timestamp registerDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
}
