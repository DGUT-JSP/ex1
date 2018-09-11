package com.dgut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dgut.bean.UserInformation;
import com.dgut.util.DBUtil;

public class UserInformationDaoImpl implements com.dgut.dao.UserInformationDao {

	@Override
	public void addUserInformation(UserInformation ui) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement("insert into user_information(userId,gender,briefIntroduction,headIconUrl,nickName) values(?,?,?,?,?)");
		ps.setInt(1, ui.getUserId());
		ps.setString(2, ui.getGender());
		ps.setString(3, ui.getBriefIntroduction());
		ps.setString(4, ui.getHeadIconUrl());
		ps.setString(5, ui.getNickName());
		ps.executeUpdate();
	}

	@Override
	public UserInformation findByUserId(String id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		ResultSet rs = null;
		
		ps = conn.prepareStatement("select * from user_information where userId=?");
		ps.setString(1, id);
		rs = ps.executeQuery();
		
		//查询的结果封装到对象
		UserInformation ui = null;
		
		if(rs.next()){
			ui = new UserInformation();
			ui.setUserId(rs.getInt("userId"));
			ui.setNickName(rs.getString("nickName"));
			ui.setGender(rs.getString("gender"));
			ui.setBriefIntroduction(rs.getString("briefIntroduction"));
			ui.setHeadIconUrl(rs.getString("headIconUrl"));
			
		}
		
		return ui;
	}

	@Override
	public void updateUserInformation(UserInformation ui) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		
		ps = conn.prepareStatement("update user_information set gender=?,briefIntroduction=?,nickName=? where userId=?");
		ps.setString(1, ui.getGender());
		ps.setString(2, ui.getBriefIntroduction());
		ps.setString(3, ui.getNickName());
		ps.setInt(4, ui.getUserId());
		
		ps.executeUpdate();
	}

	@Override
	public void updateUserHeadIconUrl(UserInformation ui) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement("update user_information set headIconUrl=? where userId=?");
		ps.setString(1, ui.getHeadIconUrl());
		ps.setInt(2, ui.getUserId());
		ps.executeUpdate();
		
	}

	public String findHeadIconUrlByUserId(String id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		ResultSet rs = null;
		
		ps = conn.prepareStatement("select headIconUrl from user_information where userId=?");
		ps.setString(1, id);
		rs = ps.executeQuery();
		
		String result = "";
		if(rs.next()){
			result = rs.getString("headIconUrl");
		}
		return result;
		
	}


}
