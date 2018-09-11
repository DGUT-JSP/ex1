package com.dgut.service;

import com.dgut.bean.UserInformation;

public interface UserInformationService {
	public void addUserInformation(UserInformation ui) throws Exception;
	
	public UserInformation findByUserId(String id)throws Exception;
	
	public void updateUserInformation(UserInformation ui) throws Exception;
	
	public void updateHeadIconUrl(UserInformation ui) throws Exception;
	
	public String getHeadIconUrl(String id) throws Exception;
}
