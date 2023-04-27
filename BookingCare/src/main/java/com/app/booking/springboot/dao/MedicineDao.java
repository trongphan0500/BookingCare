package com.app.booking.springboot.dao;

import java.util.Date;
import java.util.List;

import com.app.booking.springboot.entity.Medicine;

public interface MedicineDao {

	Medicine createMedicine(int categoryId, String name, String avatar, Date expiryDate, int outStockAlertQuantity,
			float retailPrice, float costPrice, int status, String note, String storageUnit, String useUnit,
			String methodOfUse, String originalName, int outExpiryDateAlert) throws Exception;

	List<Medicine> getMedicines(int categoryId, int medicineId, String keySearch, int status) throws Exception;
}