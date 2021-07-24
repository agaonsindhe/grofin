package com.grofin.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grofin.api.model.StatusModel;
import com.grofin.api.model.UserInfoModel;
import com.grofin.api.model.response.UserInfoResponse;
import com.grofin.api.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping("/info")
	public ResponseEntity<UserInfoResponse> getUserInfo(@RequestParam String userId) {
		 ResponseEntity<UserInfoResponse> responseEntity = null;
		 UserInfoResponse response = new UserInfoResponse();
		 UserInfoModel userInfo = userInfoService.getUserInfo(userId);
		 StatusModel status = new StatusModel();
		 if(userInfo==null) {
			 status.setMessage("No Records Found!!");
			 status.setStatusCode(HttpStatus.NOT_FOUND.toString());
			 response.setStatusModel(status);
			 responseEntity = new ResponseEntity<UserInfoResponse>(response,HttpStatus.NOT_FOUND);
		 }else {
			 response.setUserInfoModel(userInfo);
			 response.setStatusModel(status);
			 status.setStatusCode(HttpStatus.OK.toString());
			 responseEntity = new ResponseEntity<UserInfoResponse>(response, HttpStatus.OK);
		 }
		 return responseEntity;
	}
}
