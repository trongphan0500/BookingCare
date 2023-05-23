package com.app.booking.springboot.service;

import com.app.booking.springboot.entity.Patient;

public interface PatientSerivce {
	Patient savePatient(Patient pt)  throws Exception;
}
