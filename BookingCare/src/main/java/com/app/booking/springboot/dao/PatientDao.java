package com.app.booking.springboot.dao;

import com.app.booking.springboot.entity.Patient;

public interface PatientDao {
	public Patient savePatient(Patient pt) throws Exception  ;
	public Patient getPatientByPhone(String phone);
}
