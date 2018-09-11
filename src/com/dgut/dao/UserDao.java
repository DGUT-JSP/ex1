package com.dgut.dao;

import java.util.List;

import com.dgut.bean.User;

/**
 * 用户dao
 * @author DELL
 *
 */
public interface UserDao {

	/**
	 * 
	 * @param user
	 * @throws 
	 */
	public void addUser(User user) throws Exception;
	
	/**
	 * 
	 * @param u
	 * @return
	 * @throws Exception
	 */
	public User findUserByNameAndPassword(User u) throws Exception;
	
	public User findUserByName(User u) throws Exception;
	
	public User findUserById(int id) throws Exception;
	
	public List<User> findAllUser() throws Exception;
	
	/**
	 * 返回指定页数的userList
	 * @param startIndex
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<User> findOnePageUser(Integer startIndex, Integer pageSize) throws Exception;
	
	public int deleteUserById(String Ids) throws Exception;
}
