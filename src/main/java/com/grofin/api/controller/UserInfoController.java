package com.grofin.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grofin.api.model.StatusModel;
import com.grofin.api.model.UserInfoModel;
import com.grofin.api.model.response.RegistrationResponse;
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
		UserInfoResponse response = userInfoService.getUserInfo(userId);
		StatusModel status = new StatusModel();
		if (response.getUserInfoModel() == null) {
			responseEntity = new ResponseEntity<UserInfoResponse>(response, HttpStatus.NOT_FOUND);
		} else {
			status.setStatusCode(HttpStatus.OK.toString());
			response.setStatusModel(status);
			responseEntity = new ResponseEntity<UserInfoResponse>(response, HttpStatus.OK);
		}
		return responseEntity;
	}

	@PostMapping("/register")
	public ResponseEntity<RegistrationResponse> registerUser(@RequestBody UserInfoModel request) {
		ResponseEntity<RegistrationResponse> responseEntity = null;
		RegistrationResponse userInfoResponse = userInfoService.registerUser(request);
		StatusModel status = new StatusModel();
		if (userInfoResponse.getUserInfoModel() == null) {
			userInfoResponse.setStatusModel(status);
			responseEntity = new ResponseEntity<RegistrationResponse>(userInfoResponse, HttpStatus.NOT_FOUND);
		} else {
			status.setStatusCode(HttpStatus.OK.toString());
			userInfoResponse.setStatusModel(status);
			responseEntity = new ResponseEntity<RegistrationResponse>(userInfoResponse, HttpStatus.OK);
		}
		return responseEntity;
	}

}
