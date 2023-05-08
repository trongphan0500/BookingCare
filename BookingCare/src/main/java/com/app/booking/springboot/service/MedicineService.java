package com.app.booking.springboot.service;

import java.util.Date;
import java.util.List;

import com.app.booking.springboot.entity.Medicine;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineHistoryModel;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineInventoryModel;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineWaningModel;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;

public interface MedicineService {

	Medicine createMedicine(int categoryId, String name, String avatar, Date expiryDate, int outStockAlertQuantity,
			float retailPrice, float costPrice, int status, String note, String storageUnit, String methodOfUse,
			String originalName, int outExpiryDateAlert) throws Exception;

	StoreProcedureListResult<Medicine> getMedicines(int categoryId, int medicineId, String keySearch, int status,
			int sortBy, Pagination pagination) throws Exception;

	Medicine getMedicine(int medicineId) throws Exception;

	List<MedicineInventoryModel> getMedicineInvetory(int categoryId, int medicineId) throws Exception;

	void updateMedicine(int categoryId, int medicineId, String name, String avatar, Date expiryDate,
			int outStockAlertQuantity, float retailPrice, float costPrice, int status, String note, String storageUnit,
			String useUnit, String methodOfUse, String originalName, int outExpiryDateAlert) throws Exception;

	List<MedicineHistoryModel> getMedicineHistory(int medicineId, String fromDate, String toDate, String keySearch,
			int status) throws Exception;

	StoreProcedureListResult<MedicineWaningModel> getWarningMedicine(int categoryId, int isExpriyDateAlert,
			String keySearch, String fromDate, String toDate, int sortBy, Pagination pagination) throws Exception;
}
