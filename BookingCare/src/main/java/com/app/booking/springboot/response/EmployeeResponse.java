package com.app.booking.springboot.response;

import java.util.List;
import java.util.stream.Collectors;

import com.app.booking.springboot.entity.model.storeProcedure.EmployeeModal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeResponse {

	private int id;

	private String name;

	private String email;

	private String address;

	private String phone;

	private String avatar;

	private int gender;

	@JsonProperty("is_active")
	private int isActive;

	@JsonProperty("is_login")
	private int isLogin;

//	@JsonProperty("verify_code")
//	private int verifyCode;

	@JsonProperty("")
	private String position;

	private String department;

	private float salary;

	public EmployeeResponse() {
	}

	public EmployeeResponse(EmployeeModal entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.address = entity.getAddress();
		this.phone = entity.getPhone();
		this.avatar = entity.getAvatar();
		this.gender = entity.getGender();
		this.isActive = entity.getIsActive();
		this.isLogin = entity.getIsLogin();
		this.position = entity.getPosition();
		this.department = entity.getDepartment();
		this.salary = entity.getSalary();
	}

	public List<EmployeeResponse> mapToList(List<EmployeeModal> entiies) {
		return entiies.stream().map(x -> new EmployeeResponse(x)).collect(Collectors.toList());
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
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

//	public int getVerifyCode() {
//		return verifyCode;
//	}
//
//	public void setVerifyCode(int verifyCode) {
//		this.verifyCode = verifyCode;
//	}
//
//	public String getAccessToken() {
//		return accessToken;
//	}
//
//	public void setAccessToken(String accessToken) {
//		this.accessToken = accessToken;
//	}
//
//	public String getRefeshToken() {
//		return refeshToken;
//	}
//
//	public void setRefeshToken(String refeshToken) {
//		this.refeshToken = refeshToken;
//	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

}
