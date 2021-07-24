package com.grofin.api.dao;

import com.grofin.api.dao.entity.UserInfoDTO;
import com.grofin.api.model.UserInfoModel;

public interface UserInfoDAO {

	UserInfoModel getUserInfo(String userId);

	UserInfoDTO registerUser(UserInfoDTO request);
	
}
