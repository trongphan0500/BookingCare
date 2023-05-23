package com.example.doctorcareserver.service;

import com.example.doctorcareserver.entity.Patient;

public interface PatientService {

	public Patient getPatient(int id);
	public Patient savePatient(Patient pt);
}
