package com.grofin.api.dao;

import com.grofin.api.model.UserInfoModel;

public interface UserInfoDAO {

	UserInfoModel getUserInfo(String userId);
	
}
