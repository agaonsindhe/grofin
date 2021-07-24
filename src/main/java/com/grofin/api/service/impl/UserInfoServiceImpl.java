package com.grofin.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.grofin.api.dao.UserInfoDAO;
import com.grofin.api.dao.entity.UserInfoDTO;
import com.grofin.api.mapper.UserInfoMapper;
import com.grofin.api.model.StatusModel;
import com.grofin.api.model.UserInfoModel;
import com.grofin.api.model.response.RegistrationResponse;
import com.grofin.api.model.response.UserInfoResponse;
import com.grofin.api.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Override
	public UserInfoResponse getUserInfo(String userId) {
		UserInfoModel userInfo = userInfoDAO.getUserInfo(userId);
		UserInfoResponse userInfoResponse = new UserInfoResponse();
		if(userInfo==null) {
			StatusModel status = new StatusModel();
			status.setMessage("No records found for user "+userId);
			status.setStatusCode(HttpStatus.NOT_FOUND.toString());
			userInfoResponse.setStatusModel(status );
		}else {
			userInfoResponse.setUserInfoModel(userInfo);
		}
		
		return userInfoResponse; 
	}

	@Override
	public RegistrationResponse registerUser(UserInfoModel userInfo) {
		UserInfoDTO userInfoEntity = UserInfoMapper.mapModelToDTO(userInfo);
		//TODO: Validate OTP and register 
		/*
		 *  OTP validation to be implemented
		 * */
		
		UserInfoDTO userInfoDTOResponse = userInfoDAO.registerUser(userInfoEntity);
		RegistrationResponse response = new RegistrationResponse();
		
		if(userInfoDTOResponse==null) {
			StatusModel status = new StatusModel();
			status.setMessage("Registration failed!!!");
			status.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			response.setStatusModel(status);
		}else {
			userInfo = UserInfoMapper.map(userInfoDTOResponse);
			response.setUserInfoModel(userInfo);
		}
		
		return response;
	}

}
