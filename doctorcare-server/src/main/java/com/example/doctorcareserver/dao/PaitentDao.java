package com.example.doctorcareserver.dao;

import com.example.doctorcareserver.entity.Patient;

public interface PaitentDao   {
	Patient savePatient()  throws Exception;
	Patient getPatientById(int id);
	
}
