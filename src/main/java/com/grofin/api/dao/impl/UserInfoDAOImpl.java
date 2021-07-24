package com.grofin.api.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grofin.api.dao.UserInfoDAO;
import com.grofin.api.dao.entity.UserInfoDTO;
import com.grofin.api.dao.repository.UserInfoRepository;
import com.grofin.api.mapper.UserInfoMapper;
import com.grofin.api.model.UserInfoModel;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

	@Autowired
	public UserInfoRepository userInfoRepository;
	
	@Override
	public UserInfoModel getUserInfo(String userId) {
		
		UserInfoDTO userInfoDTO = userInfoRepository.findByUserId(Long.parseLong(userId));
		UserInfoModel userInfo = null;
		
		if(userInfoDTO!=null)
			userInfo = UserInfoMapper.map(userInfoDTO); 
	
		return userInfo;
	}

	@Override
	public UserInfoDTO registerUser(UserInfoDTO userInfoEntity) {
		return userInfoRepository.save(userInfoEntity );
	}

}
