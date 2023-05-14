package com.example.doctorcareserver.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String keyMap;

	private String value;

	private String description;

//	@OneToOne(mappedBy = "role")
//	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyMap() {
		return keyMap;
	}

	public void setKeyMap(String keyMap) {
		this.keyMap = keyMap;
	}

	public String getValue() {
		return value;
	}
	

	public Role(int id, String keyMap, String value, String description) {
		super();
		this.id = id;
		this.keyMap = keyMap;
		this.value = value;
		this.description = description;
		
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Role() {
		super();
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", keyMap=" + keyMap + ", value=" + value + ", description=" + description + "]";
	}

	
	

}
