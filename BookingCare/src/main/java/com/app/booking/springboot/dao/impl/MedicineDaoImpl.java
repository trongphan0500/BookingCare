package com.app.booking.springboot.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.MedicineDao;
import com.app.booking.springboot.entity.Medicine;

@Repository("medicineDao")
@Transactional
@SuppressWarnings("unchecked")
public class MedicineDaoImpl extends AbstractDao<Integer, Medicine> implements MedicineDao {
	@Override
	public Medicine createMedicine(Medicine medicine) throws Exception {
		this.getSession().save(medicine);
		return (Medicine) medicine;
	}

}
