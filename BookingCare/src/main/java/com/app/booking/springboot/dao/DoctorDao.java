package com.app.booking.springboot.dao;

import java.util.List;

import com.app.booking.springboot.entity.Patient;

public interface DoctorDao {

	List<Patient> getHistoryExamination(int patentId, String keySearch) throws Exception;
	
	

}
