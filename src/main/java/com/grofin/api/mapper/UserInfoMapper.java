package com.grofin.api.mapper;

import com.grofin.api.dao.entity.UserInfoDTO;
import com.grofin.api.model.UserInfoModel;

public class UserInfoMapper {
	
	public static UserInfoModel map(UserInfoDTO userInfoDTO) {
		
		UserInfoModel userInfo = new UserInfoModel();
		userInfo.setUserId(userInfoDTO.getUserId());
		userInfo.setContactNumber(userInfoDTO.getContactNumber());
		userInfo.setEmail(userInfoDTO.getEmail());
		userInfo.setFirstName(userInfoDTO.getFirstName());
		userInfo.setLastName(userInfoDTO.getLastName());
		userInfo.setPassword(userInfoDTO.getPassword());
		userInfo.setReferralId(userInfoDTO.getReferralId());

		return userInfo;
	}

	public static UserInfoDTO mapModelToDTO(UserInfoModel userInfo) {
		
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO.setUserId(userInfo.getUserId());
		userInfoDTO.setContactNumber(userInfo.getContactNumber());
		userInfoDTO.setEmail(userInfo.getEmail());
		userInfoDTO.setFirstName(userInfo.getFirstName());
		userInfoDTO.setLastName(userInfo.getLastName());
		userInfoDTO.setPassword(userInfo.getPassword());
		userInfoDTO.setReferralId(userInfo.getReferralId());
		
		return userInfoDTO;
	}
	

}
