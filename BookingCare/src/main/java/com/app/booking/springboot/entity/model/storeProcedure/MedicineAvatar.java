package com.app.booking.springboot.entity.model.storeProcedure;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicineAvatar {

	@Id
	private int id;

	private String name;

	private String avatar;
//	private byte[] avatar;

	private String code;

	@Column(name = "expiry_date")
	private Date expiryDate;

	@Column(name = "normalize_name")
	private String normalizeName;

	@Column(name = "prefix_name")
	private String prefixName;

	@Column(name = "out_stock_alert_quantity")
	private int outStockAlertQuantity;

	@Column(name = "retail_price")
	private float retailPrice;

	@Column(name = "cost_price")
	private float costPrice;

	@Column(name = "inventory_quantity")
	private int inventoryQuantity;

	private int status;

	private String type;

	private String note;

	@Column(name = "storage_unit")
	private String storageUnit;

	@Column(name = "use_unit")
	private String useUnit;

	@Column(name = "method_of_use")
	private String methodOfUse;

	@Column(name = "original_name")
	private String originalName;

	@Column(name = "out_expiry_date_alert")
	private int outExpiryDateAlert;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNormalizeName() {
		return normalizeName;
	}

	public void setNormalizeName(String normalizeName) {
		this.normalizeName = normalizeName;
	}

	public String getPrefixName() {
		return prefixName;
	}

	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
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

	public int getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(int inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
