package com.app.booking.springboot.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateMedicineRequest {

	@JsonProperty("category_id")
	private int categoryId;

	private String name;

	private String avatar;

	@JsonProperty("expiry_date")
	private Date expiryDate;

	@JsonProperty("out_stock_alert_quantity")
	private int outStockAlertQuantity;

	@JsonProperty("retail_price")
	private float retailPrice;

	@JsonProperty("cost_price")
	private float costPrice;

	private int status;

	private String note;

	@JsonProperty("storage_unit")
	private String storageUnit;

	@JsonProperty("use_unit")
	private String useUnit;

	@JsonProperty("method_of_use")
	private String methodOfUse;

	@JsonProperty("original_name")
	private String originalName;

	@JsonProperty("out_expiry_date_alert")
	private int outExpiryDateAlert;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getOutStockAlertQuantity() {
		return outStockAlertQuantity;
	}

	public void setOutStockAlertQuantity(int outStockAlertQuantity) {
		this.outStockAlertQuantity = outStockAlertQuantity;
	}

	public float getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(float retailPrice) {
		this.retailPrice = retailPrice;
	}

	public float getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStorageUnit() {
		return storageUnit;
	}

	public void setStorageUnit(String storageUnit) {
		this.storageUnit = storageUnit;
	}

	public String getUseUnit() {
		return useUnit;
	}

	public void setUseUnit(String useUnit) {
		this.useUnit = useUnit;
	}

	public String getMethodOfUse() {
		return methodOfUse;
	}

	public void setMethodOfUse(String methodOfUse) {
		this.methodOfUse = methodOfUse;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public int getOutExpiryDateAlert() {
		return outExpiryDateAlert;
	}

	public void setOutExpiryDateAlert(int outExpiryDateAlert) {
		this.outExpiryDateAlert = outExpiryDateAlert;
	}

}
