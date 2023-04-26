package com.app.booking.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.booking.springboot.dao.MedicineDao;
import com.app.booking.springboot.entity.Medicine;

@Service("medicineService")
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	private MedicineDao medicineDao;

	@Override
	public Medicine createMedicine(Medicine medicine) throws Exception {
		return medicineDao.createMedicine(medicine);
	}
	
	

}
