package com.app.booking.springboot.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String email;

	private String password;

	private String address;

	private String phone;

//	private String avatar;

	@Lob
	@Column(name = "avatar", columnDefinition = "LONGBLOB")
	private byte[] avatar;

	private int gender;

	private String description;

	@Column(name = "is_active")
	private int isActive;

	@Column(name = "is_login")
	private int isLogin;

	@Column(name = "verify_code")
	private int verifyCode;

	@Column(name = "access_token")
	private String accessToken;

	@Column(name = "refesh_token")
	private String refeshToken;

	private String position;

//	@ManyToOne
//	@JoinColumn(name = "role_id")
//	private Role role;
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

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

	public User(int id, String name, String email, String password, String address, String phone, byte[] avatar,
			int gender, String description, int isActive, int isLogin, int verifyCode, String accessToken,
			String refeshToken, String position, int roleId, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.avatar = avatar;
		this.gender = gender;
		this.description = description;
		this.isActive = isActive;
		this.isLogin = isLogin;
		this.verifyCode = verifyCode;
		this.accessToken = accessToken;
		this.refeshToken = refeshToken;
		this.position = position;
		this.roleId = roleId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", phone=" + phone + ", avatar=" + Arrays.toString(avatar) + ", gender=" + gender + "]";
	}
	
	

}
