package com.grofin.api.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grofin.api.dao.entity.UserInfoDTO;

public interface UserInfoRepository extends JpaRepository<UserInfoDTO, Long> {

	UserInfoDTO findByUserId(Long userId);
	
}
