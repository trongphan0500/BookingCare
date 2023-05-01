package com.app.booking.springboot.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateWarehouseSessionRequest {

	@JsonProperty("employee_id")
	@Min(value = 1, message = "EmployeeIDss nhỏ nhất là 1")
	private int employeeId;

	@JsonProperty("discount_percent")
	@Min(value = 0, message = "Discount Percent nhỏ nhất 0%")
	@Max(value = 100, message = "Discount Percent lớn nhất 100%")
	private int discountPercent;

	@Min(value = 0, message = "type thuộc [0-1]")
	@Max(value = 1, message = "type thuộc [0-1]")
	private int type;

	@JsonProperty("discount_amount")
	@Min(value = 0, message = "Discount Amount không được âm")
	@Max(value = 10000000, message = "lớn nhất 10.000.00")
	private float discountAmount;

	@Length(max = 255, message = "không dược nhập tối đa 255 kí tự.")
	private String description;

	@Valid
	@JsonProperty("warehouse_session_request")
	private List<WarehouseSessionRequest> warehouseSessionRequests;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public float getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<WarehouseSessionRequest> getWarehouseSessionRequests() {
		return warehouseSessionRequests;
	}

	public void setWarehouseSessionRequests(List<WarehouseSessionRequest> warehouseSessionRequests) {
		this.warehouseSessionRequests = warehouseSessionRequests;
	}

}
