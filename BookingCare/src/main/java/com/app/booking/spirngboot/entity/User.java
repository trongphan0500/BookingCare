package com.app.booking.spirngboot.entity;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", unique = true)
    private Role role;
	
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

}
