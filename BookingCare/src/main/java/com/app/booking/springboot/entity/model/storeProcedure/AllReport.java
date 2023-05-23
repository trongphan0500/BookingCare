package com.app.booking.springboot.entity.model.storeProcedure;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AllReport {
	@Id
	private String attribute;

	private float value;

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}
