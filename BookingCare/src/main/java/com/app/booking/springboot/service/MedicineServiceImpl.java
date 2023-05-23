package com.app.booking.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.MedicineDao;
import com.app.booking.springboot.entity.Medicine;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineHistoryModel;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineInventoryModel;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineInventoryNew;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineWaningModel;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;

@Service("medicineService")
@Transactional
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineDao medicineDao;

	@Override
	public Medicine createMedicine(int categoryId, String name, String avatar, Date expiryDate,
			int outStockAlertQuantity, float retailPrice, float costPrice, int status, String note, String storageUnit,
			String methodOfUse, String originalName, int outExpiryDateAlert) throws Exception {
		return medicineDao.createMedicine(categoryId, name, avatar, expiryDate, outStockAlertQuantity, retailPrice,
				costPrice, status, note, storageUnit, methodOfUse, originalName, outExpiryDateAlert);
	}

	@Override
	public StoreProcedureListResult<Medicine> getMedicines(int categoryId, int medicineId, String keySearch, int status,
			int sortBy, Pagination pagination) throws Exception {
		return medicineDao.getMedicines(categoryId, medicineId, keySearch, status, sortBy, pagination);
	}

	@Override
	public Medicine getMedicine(int medicineId) throws Exception {
		return medicineDao.getMedicine(medicineId);
	}

	@Override
	public List<MedicineInventoryModel> getMedicineInvetory(int categoryId, int medicineId) throws Exception {
		return medicineDao.getMedicineInvetory(categoryId, medicineId);
	}

	@Override
	public void updateMedicine(int categoryId, int medicineId, String name, String avatar, Date expiryDate,
			int outStockAlertQuantity, float retailPrice, float costPrice, int status, String note, String storageUnit,
			String useUnit, String methodOfUse, String originalName, int outExpiryDateAlert) throws Exception {
		medicineDao.updateMedicine(categoryId, medicineId, name, avatar, expiryDate, outStockAlertQuantity, retailPrice,
				costPrice, status, note, storageUnit, useUnit, methodOfUse, originalName, outExpiryDateAlert);
	}

	@Override
	public StoreProcedureListResult<MedicineHistoryModel> getMedicineHistory(int medicineId, String fromDate,
			String toDate, String keySearch, int status, Pagination pagination) throws Exception {
		return medicineDao.getMedicineHistory(medicineId, fromDate, toDate, keySearch, status, pagination);
	}

	@Override
	public StoreProcedureListResult<MedicineWaningModel> getWarningMedicine(int categoryId, int isExpriyDateAlert,
			String keySearch, String fromDate, String toDate, int sortBy, Pagination pagination) throws Exception {
		return medicineDao.getWarningMedicine(categoryId, isExpriyDateAlert, keySearch, fromDate, toDate, sortBy,
				pagination);
	}

	@Override
	public StoreProcedureListResult<MedicineInventoryNew> getInventoryMedicines(int categoryId, int medicineId,
			int isExpiry, String keySearch, int status, int sortBy, Pagination pagination) throws Exception {
		return medicineDao.getInventoryMedicines(categoryId, medicineId, isExpiry, keySearch, status, sortBy,
				pagination);
	}

	@Override
	public ArrayList<Medicine> getMediasfrom(String name) {
		// TODO Auto-generated method stub
		return medicineDao.getMediasfrom(name);
	}

}
