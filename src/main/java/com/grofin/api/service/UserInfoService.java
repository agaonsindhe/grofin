package com.grofin.api.service;

import com.grofin.api.model.UserInfoModel;
import com.grofin.api.model.response.RegistrationResponse;
import com.grofin.api.model.response.UserInfoResponse;


public interface UserInfoService {

	UserInfoResponse getUserInfo(String userId);

	RegistrationResponse registerUser(UserInfoModel request);
	
}
