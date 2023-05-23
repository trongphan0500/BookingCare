package com.example.doctorcareserver.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.doctorcareserver.entity.Specialization;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SpecializationResponse {

	private int id;

	private String code;

	private String name;

	private String image;

	@JsonProperty("number_exam_rooms")
	private int numberExamRooms;

	private String description;

	@JsonProperty("created_at")
	private Date createdAt;

	@JsonProperty("updated_at")
	private Date updatedAt;

	public SpecializationResponse() {
	}

	public SpecializationResponse(Specialization entity) {
		this.id = entity.getId();
		this.code = entity.getCode();
		this.name = entity.getName();
		this.image = entity.getImage();
		this.numberExamRooms = entity.getNumberExamRooms();
		this.description = entity.getDescription();
		this.createdAt = entity.getCreatedAt();
		this.updatedAt = entity.getUpdatedAt();
	}

	public List<SpecializationResponse> mapToList(List<Specialization> entiies) {
		return entiies.stream().map(x -> new SpecializationResponse(x)).collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNumberExamRooms() {
		return numberExamRooms;
	}

	public void setNumberExamRooms(int numberExamRooms) {
		this.numberExamRooms = numberExamRooms;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
