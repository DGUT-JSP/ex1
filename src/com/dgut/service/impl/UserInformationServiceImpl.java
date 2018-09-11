package com.dgut.service.impl;

import com.dgut.bean.UserInformation;
import com.dgut.dao.UserInformationDao;
import com.dgut.dao.impl.UserInformationDaoImpl;
import com.dgut.service.UserInformationService;

public class UserInformationServiceImpl implements UserInformationService {
	UserInformationDao userInformationDao = new UserInformationDaoImpl();
	@Override
	public void addUserInformation(UserInformation ui) throws Exception {
		userInformationDao.addUserInformation(ui);
	}

	@Override
	public UserInformation findByUserId(String id) throws Exception {
		UserInformation ui = null;
		ui = userInformationDao.findByUserId(id);
		return ui;
	}

	@Override
	public void updateUserInformation(UserInformation ui) throws Exception {
		userInformationDao.updateUserInformation(ui);
	}

	@Override
	public void updateHeadIconUrl(UserInformation ui) throws Exception {
		userInformationDao.updateUserHeadIconUrl(ui);
	}

	@Override
	public String getHeadIconUrl(String id) throws Exception {
		
		return userInformationDao.findHeadIconUrlByUserId(id);
	}

}
