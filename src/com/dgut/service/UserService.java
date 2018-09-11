package com.dgut.service;

import com.dgut.bean.User;

public interface UserService {

	/**
	 * 添加用户信息
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	
	public User findUserByNameAndPassword(User user) throws Exception;
	
	public User findUserByName(User user) throws Exception;
	
	public Integer deleteUserById(String ids) throws Exception;

	public User findUserById(int id) throws Exception;
}
