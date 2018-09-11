package com.dgut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dgut.bean.User;
import com.dgut.dao.UserDao;
import com.dgut.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement("insert into user(userName,passWord,userType) values(?,?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getType());
		ps.executeUpdate();
	}

	@Override
	public User findUserByNameAndPassword(User u) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement("select userId,userName,`passWord`,userType,registerDate from user where userName=? and `passWord`=?");
		ps.setString(1, u.getName());
		System.out.println(u.getName());
		ps.setString(2, u.getPassword());
		System.out.println(u.getPassword());
		rs = ps.executeQuery();
		
		User user = null;
		//查询出的结果封装到user
		if(rs.next()){
			user = new User();
			user.setId(rs.getInt("userId"));
			user.setName(rs.getString("userName"));
			user.setPassword(rs.getString("passWord"));
			user.setType(rs.getString("userType"));
			user.setRegisterDate(rs.getTimestamp("registerDate"));
		}
		return user;
	}

	@Override
	public User findUserByName(User u) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement("select userName,`passWord`,userType from user where userName=?");
		ps.setString(1, u.getName());
		rs = ps.executeQuery();
		
		User user = null;
		//查询出的结果封装到user
		if(rs.next()){
			user = new User();
			user.setName(rs.getString("userName"));
			user.setType(rs.getString("userType"));
		}
		return user;
	}

	
	
	@Override
	public User findUserById(int id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement("select * from user where userId=?");
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		User user = null;
		//查询出的结果封装到user
		if(rs.next()){
			user = new User();
			user.setId(id);
			user.setName(rs.getString("userName"));
			user.setType(rs.getString("userType"));
			user.setRegisterDate(rs.getTimestamp("registerDate"));
		}
		return user;
	}

	@Override
	public List<User> findAllUser() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		ps = conn.prepareStatement("SELECT userId,userName,userType,registerDate FROM user");
		rs = ps.executeQuery();
		
		User user = null;
		List<User> userList = new ArrayList<>();
		
		while(rs.next()){
			user = new User();
			user.setId(rs.getInt("userId"));
			user.setName(rs.getString("userName"));
			user.setType(rs.getString("userType"));
			user.setRegisterDate(rs.getTimestamp("registerDate"));
			userList.add(user);
		}
		
		
		return userList;
	}

	
	@Override
	public List<User> findOnePageUser(Integer startIndex, Integer pageSize) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		
		ps = conn.prepareStatement("SELECT userId,userName,userType,registerDate FROM user limit " + startIndex.toString() + "," + pageSize.toString());
		rs = ps.executeQuery();
		
		User user = null;
		List<User> userList = new ArrayList<>();
		
		while(rs.next()){
			user = new User();
			user.setId(rs.getInt("userId"));
			user.setName(rs.getString("userName"));
			user.setType(rs.getString("userType"));
			user.setRegisterDate(rs.getTimestamp("registerDate"));
			userList.add(user);
		}
		
		
		return userList;
	}

	@Override
	public int deleteUserById(String ids) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		
		if(ids!=null && ids.length()>0){
			ps = conn.prepareStatement("delete from user where userId in(?)");
			ps.setString(1, ids);
			System.out.println(ps);
			return ps.executeUpdate();
		}else return -1;
	}
	
	
	
}
