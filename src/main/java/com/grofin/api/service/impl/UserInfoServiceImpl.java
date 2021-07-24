package com.grofin.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grofin.api.dao.UserInfoDAO;
import com.grofin.api.model.UserInfoModel;
import com.grofin.api.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Override
	public UserInfoModel getUserInfo(String userId) {
		
		return userInfoDAO.getUserInfo(userId);
		
	}

}
