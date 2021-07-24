package com.grofin.api.model.response;

import com.grofin.api.model.BaseModel;
import com.grofin.api.model.UserInfoModel;

public class UserInfoResponse extends BaseModel {
	
	private UserInfoModel userInfoModel;

	public UserInfoModel getUserInfoModel() {
		return userInfoModel;
	}

	public void setUserInfoModel(UserInfoModel userInfoModel) {
		this.userInfoModel = userInfoModel;
	}
}
