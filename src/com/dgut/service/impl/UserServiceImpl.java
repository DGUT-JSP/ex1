package com.dgut.service.impl;

import com.dgut.bean.User;
import com.dgut.dao.UserDao;
import com.dgut.dao.impl.UserDaoImpl;
import com.dgut.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public void addUser(User user) throws Exception {
		userDao.addUser(user);
	}

	@Override
	public User findUserByNameAndPassword(User user) throws Exception {
		return userDao.findUserByNameAndPassword(user);
	}

	@Override
	public User findUserByName(User user) throws Exception {
		return userDao.findUserByName(user);
	}

	@Override
	public Integer deleteUserById(String ids) throws Exception {
		return userDao.deleteUserById(ids);
	}

	@Override
	public User findUserById(int id) throws Exception {
		return userDao.findUserById(id);
	}

	
}
