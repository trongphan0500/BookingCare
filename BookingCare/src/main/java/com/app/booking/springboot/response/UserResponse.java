package com.app.booking.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.app.booking.springboot.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {

	private int id;

	private String name;

	private String email;

	private String address;

	private String phone;

	private String avatar;

	private int gender;

	private String description;

	@JsonProperty("is_active")
	private int isActive;

	@JsonProperty("is_login")
	private int isLogin;

	@JsonProperty("verify_code")
	private int verifyCode;

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("refesh_token")
	private String refeshToken;
	@JsonProperty("")
	private String position;

	@JsonProperty("created_at")
	private Date createdAt;

	@JsonProperty("updated_at")
	private Date updatedAt;

	public UserResponse() {
	}

	public UserResponse(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.address = entity.getAddress();
		this.phone = entity.getPhone();
		this.avatar = entity.getAvatar();
		this.gender = entity.getGender();
		this.description = entity.getDescription();
		this.isActive = entity.getIsActive();
		this.isLogin = entity.getIsLogin();
		this.verifyCode = entity.getVerifyCode();
		this.accessToken = entity.getAccessToken();
		this.refeshToken = entity.getRefeshToken();
		this.position = entity.getPosition();
	}

	public List<UserResponse> mapToList(List<User> entiies) {
		return entiies.stream().map(x -> new UserResponse(x)).collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
