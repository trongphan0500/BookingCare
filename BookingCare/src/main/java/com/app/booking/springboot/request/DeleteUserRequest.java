package com.app.booking.springboot.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteUserRequest {

	@Min(value = 0, message = "roleId thuộc [0-10]")
	@Max(value = 10, message = "roleId thuộc [0-10]")
	@JsonProperty("role_id")
	private int roleId;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
