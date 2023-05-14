package com.example.doctorcareserver.response;

import java.util.List;
import java.util.stream.Collectors;

import com.example.doctorcareserver.entity.model.storeProcedure.UserModal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponseV2 {

	private int id;

	private String name;

	private String email;

	private String phone;

	private String avatar;

	private String address;

	private int gender;

	@JsonProperty("role_id")
	private int roleId;

	private String position;

	private String description;

	private String value;

	private String note;

	@JsonProperty("specialization_name")
	private String specializationName;

	public UserResponseV2() {
	}

	public UserResponseV2(UserModal user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.address = user.getAddress();
		this.gender = user.getGender();
		this.roleId = user.getRoleId();
		this.position = user.getPosition();
		this.description = user.getDescription();
		this.value = user.getValue();
		this.note = user.getNote();
		this.avatar = user.getAvatar();
		this.specializationName = user.getSpecializationName();
	}

	public List<UserResponseV2> mapToList(List<UserModal> entiies) {
		return entiies.stream().map(x -> new UserResponseV2(x)).collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getSpecializationName() {
		return specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
