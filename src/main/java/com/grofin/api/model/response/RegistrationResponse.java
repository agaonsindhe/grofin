package com.grofin.api.model.response;

import com.grofin.api.model.BaseModel;
import com.grofin.api.model.UserInfoModel;

public class RegistrationResponse extends BaseModel {

	private UserInfoModel userInfoModel;

	public UserInfoModel getUserInfoModel() {
		return userInfoModel;
	}

	public void setUserInfoModel(UserInfoModel userInfoModel) {
		this.userInfoModel = userInfoModel;
	}
	
}
