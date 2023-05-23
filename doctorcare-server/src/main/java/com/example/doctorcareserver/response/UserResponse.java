package com.example.doctorcareserver.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.doctorcareserver.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {

	private int id;

	private String name;

	private String email;

	private String address;

	private String phone;

//	private String avatar;

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
//		this.avatar = entity.getAvatar();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

//	public String getAvatar() {
//		return avatar;
//	}
//
//	public void setAvatar(String avatar) {
//		this.avatar = avatar;
//	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}

	public int getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefeshToken() {
		return refeshToken;
	}

	public void setRefeshToken(String refeshToken) {
		this.refeshToken = refeshToken;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
