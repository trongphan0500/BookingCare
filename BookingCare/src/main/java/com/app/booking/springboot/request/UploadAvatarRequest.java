package com.app.booking.springboot.request;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadAvatarRequest {

	@Min(value = 0, message = "id lớn hơn 0")
	@NotNull(message = "medicine_id not null")
	@JsonProperty("id")
	private int id;

	@Lob
	@Column(name = "avatar", columnDefinition = "BLOB")
	private byte[] avatar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

}
