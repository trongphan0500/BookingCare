package com.example.doctorcareserver.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangePasswordRequest {

	@JsonProperty("old_pass")
	private String oldPass;

	@JsonProperty("new_pass")
	private String newPass;

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

}
