package com.app.booking.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.app.booking.springboot.entity.Medicine;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MedicineDetailResponse {

	private int id;

	private String name;

//	private String avatar;
	private byte[] avatar;

	private String code;

	@JsonProperty("expiry_date")
	private Date expiryDate;

	@JsonProperty("normalize_name")
	private String normalizeName;

	@JsonProperty("prefix_name")
	private String prefixName;

	@JsonProperty("out_stock_alert_quantity")
	private int outStockAlertQuantity;

	@JsonProperty("retail_price")
	private float retailPrice;

	@JsonProperty("category_id")
	private int categoryId;

	@JsonProperty("cost_price")
	private float costPrice;

	@JsonProperty("inventory_quantity")
	private int inventoryQuantity;

	private int status;

	private String type;

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

	@JsonProperty("created_at")
	private Date createdAt;

	@JsonProperty("updated_at")
	private Date updatedAt;

	public MedicineDetailResponse() {
	}

	public MedicineDetailResponse(Medicine entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.avatar = entity.getAvatar();
		this.code = entity.getCode();
		this.categoryId = entity.getCategory().getId();
		this.expiryDate = entity.getExpiryDate();
		this.normalizeName = entity.getNormalizeName();
		this.prefixName = entity.getPrefixName();
		this.outStockAlertQuantity = entity.getOutStockAlertQuantity();
		this.retailPrice = entity.getRetailPrice();
		this.costPrice = entity.getCostPrice();
		this.status = entity.getStatus();
		this.inventoryQuantity = entity.getInventoryQuantity();
		this.type = entity.getType();
		this.note = entity.getNote();
		this.storageUnit = entity.getStorageUnit();
		this.useUnit = entity.getUseUnit();
		this.methodOfUse = entity.getMethodOfUse();
		this.originalName = entity.getOriginalName();
		this.outExpiryDateAlert = entity.getOutExpiryDateAlert();
		this.createdAt = entity.getCreatedAt();
		this.updatedAt = entity.getUpdatedAt();
	}

	public List<MedicineDetailResponse> mapToList(List<Medicine> entiies) {
		return entiies.stream().map(x -> new MedicineDetailResponse(x)).collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
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
