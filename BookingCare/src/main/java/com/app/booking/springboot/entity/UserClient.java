package com.app.booking.springboot.entity;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserClient {
	
	@JsonProperty("user_id")
	public int userId;

	@NotNull(message = "Sai token")
	@JsonProperty("phone")
	private String phone;

	@NotNull(message = "Sai token")
	@JsonProperty("password")
	private String password;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
