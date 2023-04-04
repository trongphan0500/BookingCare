package com.app.booking.spirngboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.booking.spirngboot.entity.Medicine;

@Repository
public interface MedicineDao extends JpaRepository<Medicine, Integer>{
//		Medicine add(Medicine entity) throws Exception;
		
}
