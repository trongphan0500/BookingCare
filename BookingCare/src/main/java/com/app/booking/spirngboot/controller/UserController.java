//package com.app.booking.spirngboot.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.booking.spirngboot.response.BaseResponse;
//import com.app.booking.spirngboot.response.UserResponse;
//import com.app.booking.spirngboot.service.UserService;
//
//@RestController
//@RequestMapping("api/users")
//@SuppressWarnings({ "unchecked", "rawtypes" })
//public class UserController {
//
//	@Autowired
//	private UserService userService;
//
//	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<BaseResponse> spUCreateCategory() throws Exception {
//		BaseResponse response = new BaseResponse();
//		response.setData(new UserResponse().mapToList(userService.getAll()));
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
//}
