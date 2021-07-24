package com.grofin.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grofin.api.model.UserInfoModel;
import com.grofin.api.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping("/info")
	public ResponseEntity<UserInfoModel> getUserInfo(@RequestParam String userId) {
		 ResponseEntity<UserInfoModel> responseEntity = null;
		 UserInfoModel userInfo = userInfoService.getUserInfo(userId);
		 if(userInfo!=null) {
			 responseEntity = new ResponseEntity<UserInfoModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }else {
			 responseEntity = new ResponseEntity<UserInfoModel>(userInfo, HttpStatus.OK);
		 }
		 return responseEntity;
	}
}
