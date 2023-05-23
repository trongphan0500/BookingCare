package com.example.doctorcareserver.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;
import com.example.doctorcareserver.entity.Medicine;
import com.example.doctorcareserver.entity.model.storeProcedure.MedicineHistoryModel;
import com.example.doctorcareserver.entity.model.storeProcedure.MedicineInventoryModel;
import com.example.doctorcareserver.entity.model.storeProcedure.MedicineInventoryNew;
import com.example.doctorcareserver.entity.model.storeProcedure.MedicineWaningModel;


public interface MedicineDao {
	ArrayList<Medicine> getMediasfrom(String name);
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

	StoreProcedureListResult<MedicineHistoryModel> getMedicineHistory(int medicineId, String fromDate, String toDate,
			String keySearch, int status, Pagination pagination) throws Exception;

	StoreProcedureListResult<MedicineWaningModel> getWarningMedicine(int categoryId, int isExpriyDateAlert,
			String keySearch, String fromDate, String toDate, int sortBy, Pagination pagination) throws Exception;

	StoreProcedureListResult<MedicineInventoryNew> getInventoryMedicines(int categoryId, int medicineId, int isExpiry,
			String keySearch, int status, int sortBy, Pagination pagination) throws Exception;
		
}