package com.app.booking.springboot.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.booking.springboot.dao.MedicineDao;
import com.app.booking.springboot.entity.Medicine;

@Service("medicineService")
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineDao medicineDao;

	@Override
	public Medicine createMedicine(int categoryId, String name, String avatar, Date expiryDate,
			int outStockAlertQuantity, float retailPrice, float costPrice, int status, String note, String storageUnit,
			String useUnit, String methodOfUse, String originalName, int outExpiryDateAlert) throws Exception {
		return medicineDao.createMedicine(categoryId, name, avatar, expiryDate, outStockAlertQuantity, retailPrice,
				costPrice, status, note, storageUnit, useUnit, methodOfUse, originalName, outExpiryDateAlert);
	}

	@Override
	public List<Medicine> getMedicines(int categoryId, int medicineId, String keySearch, int status) throws Exception {
		return medicineDao.getMedicines(categoryId, medicineId, keySearch, status);
	}

}
