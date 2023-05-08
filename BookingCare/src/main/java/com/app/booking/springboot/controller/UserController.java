package com.app.booking.springboot.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.springboot.entity.User;
import com.app.booking.springboot.request.ChangePasswordRequest;
import com.app.booking.springboot.response.BaseResponse;
import com.app.booking.springboot.response.UserResponse;
import com.app.booking.springboot.service.UserService;
import java.util.Base64;

@RestController
@RequestMapping("api/users")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spUCreateCategory() throws Exception {
		BaseResponse response = new BaseResponse();
//		response.setData(new UserResponse().mapToList(userService.getAll()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/change-password", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spUChangePassword(@RequestHeader(value = "authorization") String token,
			@Valid @RequestBody ChangePasswordRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();
		User userToken = this.handleTokenAccess(token);

		User user = userService.findOne(userToken.getId());

		if (!(wrapper.getOldPass().equals(user.getPassword()))) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Old Password khong chinh xac");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		String newPass = wrapper.getNewPass();
		user.setPassword(Base64.getEncoder().encodeToString(newPass.getBytes()));
		userService.update(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
