package com.app.booking.springboot.request;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WarehouseSessionRequest {

	@Min(value = 0, message = "Matertial Id không được âm")
	@JsonProperty("medicine_id")
	private int medicineId;

	@Min(value = 0, message = "Số lượng không được phép âm")
	@NotNull(message = "Số lượng không được null")
	private BigDecimal quantity;

	private String unit;

	@JsonProperty("expiry_date")
	private Date expiryDate;

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
