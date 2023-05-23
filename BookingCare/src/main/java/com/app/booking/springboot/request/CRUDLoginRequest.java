package com.app.booking.springboot.request;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CRUDLoginRequest {
	@NotEmpty(message = "Phone không được rỗng")
	@Length(max = 255, message = "Tối đa 255 kí tự")
	private String email;
	@NotEmpty(message = "Password không được rỗng")
	@Length(max = 255, message = "Tối đa 255 kí tự")
	private String password;

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

}
