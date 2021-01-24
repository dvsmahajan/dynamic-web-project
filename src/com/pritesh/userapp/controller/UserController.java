package com.pritesh.userapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pritesh.userapp.dto.UserDTO;
import com.pritesh.userapp.model.UserEntity;
import com.pritesh.userapp.service.UserService;
import com.pritesh.userapp.util.CommonResponse;

@RestController
@EnableWebMvc
@RequestMapping("/")
public class UserController {
	
	
	@Autowired
	private UserService  userService;
	
	@GetMapping("getUserById.do")
	public ResponseEntity<CommonResponse> getUser(@RequestParam Integer userId){
		CommonResponse response = new CommonResponse();
		UserDTO dto = userService.getUserById(userId);
		if(dto != null ) {
			response.setStatus(true);
			response.setRespCode(HttpStatus.OK.value());
			response.setData(dto);
			response.setMessage("Successfully get user");
		}else {
			response.setStatus(false);
			response.setRespCode(HttpStatus.OK.value());
			response.setMessage("User not available");
			
		}
		return new ResponseEntity<>(response,HttpStatus.OK );
	}
	
	@PostMapping("saveUser.do")
	public ResponseEntity<CommonResponse> saveUser(@RequestBody UserDTO dto){
		dto=userService.saveUser(dto);
		CommonResponse response = new CommonResponse();
		if(dto != null ) {
			response.setStatus(true);
			response.setRespCode(HttpStatus.CREATED.value());
			response.setData(dto);
			response.setMessage("Successfully Saved");
		}else {
			response.setStatus(false);
			response.setRespCode(HttpStatus.METHOD_NOT_ALLOWED.value());
			response.setMessage("Data not Saved");
			
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
