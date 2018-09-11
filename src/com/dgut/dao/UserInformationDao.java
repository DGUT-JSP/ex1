package com.dgut.dao;

import com.dgut.bean.UserInformation;

public interface UserInformationDao {

	public void addUserInformation(UserInformation ui) throws Exception;
	
	public UserInformation findByUserId(String id)throws Exception;
	
	/**
	 * 更新除了头像地址外的用户信息
	 * @param ui
	 * @throws Exception
	 */
	public void updateUserInformation(UserInformation ui) throws Exception;

	public void updateUserHeadIconUrl(UserInformation ui) throws Exception;
	
	public String findHeadIconUrlByUserId(String id) throws Exception;
}
