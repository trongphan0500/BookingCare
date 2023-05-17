package com.app.booking.springboot.request;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateMedicineRequest {

	@JsonProperty("category_id")
	@NotNull(message = "Danh mục bắt buộc điền")
	@Min(value = 1, message = "category_id > 0")
	private int categoryId;

	@NotEmpty(message = "Vui lòng nhập tên")
	private String name;

//	@NotNull(message = "avatar không được null")

	private String avatar = "";
//	@Lob
//	@Column(name = "avatar", columnDefinition = "BLOB")
//	private byte[] avatar;

	@JsonProperty("expiry_date")
	private Date expiryDate;

	@JsonProperty("out_stock_alert_quantity")
	@Min(value = 1, message = "outStockAlertQuantity > 0")
	@NotNull(message = "outStockAlertQuantity must not null")

	private int outStockAlertQuantity;

	@JsonProperty("retail_price")
	@Min(value = 0, message = "retail_price phải lớn hơn 0 ")
	@NotNull(message = "retail_price must not null")
	private float retailPrice;

	@JsonProperty("cost_price")
	@Min(value = 0, message = "cost_price phải lớn hơn 0 ")
	@NotNull(message = "cost_price must not null")
	private float costPrice;

	private int status;

	private String note;

	@JsonProperty("storage_unit")
	private String storageUnit;

	@JsonProperty("method_of_use")
	@NotNull(message = "method_of_use must not null")
	private String methodOfUse;

	@JsonProperty("original_name")
	@NotNull(message = "original_name must not null")
	private String originalName;

	@JsonProperty("out_expiry_date_alert")
	@NotNull(message = "out_expiry_date_alert bắt buộc")
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

//	public byte[] getAvatar() {
//		return avatar;
//	}
//
//	public void setAvatar(byte[] avatar) {
//		this.avatar = avatar;
//	}

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
