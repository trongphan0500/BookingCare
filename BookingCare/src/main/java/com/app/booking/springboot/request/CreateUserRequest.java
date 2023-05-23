package com.app.booking.springboot.request;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequest {

	@NotEmpty(message = "Vui lòng nhập tên")
	private String name;

	@NotEmpty(message = "Vui lòng nhập mail")
	private String email;

	@NotEmpty(message = "Vui lòng nhập số điện thoại")
	private String phone;

	@NotEmpty(message = "Vui lòng nhập địa chỉ")
	private String address;

	@Min(value = 0, message = "gender thuộc [0-2]")
	@Max(value = 2, message = "gender thuộc [0-2]")
	private int gender;

	@Min(value = 0, message = "roleId thuộc [0-10]")
	@Max(value = 10, message = "roleId thuộc [0-10]")
	@JsonProperty("role_id")
	private int roleId;

	private String position;

	private String description;

	@Lob
	@Column(name = "avatar", columnDefinition = "BLOB")
	private byte[] avatar;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

}
