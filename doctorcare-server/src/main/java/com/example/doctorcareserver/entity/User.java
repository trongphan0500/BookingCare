package com.example.doctorcareserver.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
	
	private String avatar;
	
	private int gender;
	
	private String description;
	
	@Column(name = "is_active")
	private int isActive;
	
	@Column(name = "is_login")
	private int isLogin;
	
	@Column(name = "verify_code")
	private int verifyCode;
	
	@Column(name = "access_token")
	private int accessToken;
	
	private String position;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	public User(int id, String name, String email, String password, String address, String phone, String avatar,
			int gender, String description, int isActive, int isLogin, int verifyCode, int accessToken, String position,
			Role role, Date createdAt, Date updatedAt) {
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
		this.position = position;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public User(String name, String email, String password, String address, String phone, String avatar,
			int gender, String description, int isActive, int isLogin, int verifyCode, int accessToken, String position,
			Role role, Date createdAt, Date updatedAt) {
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
		this.position = position;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public User() {
		super();
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
	public int getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(int accessToken) {
		this.accessToken = accessToken;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
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
