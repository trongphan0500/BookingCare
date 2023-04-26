package com.app.booking.springboot.dao;

import org.springframework.stereotype.Repository;

import com.app.booking.springboot.entity.Medicine;


public interface MedicineDao {
//		Medicine add(Medicine entity) throws Exception;
	Medicine createMedicine(Medicine entity) throws Exception;
}