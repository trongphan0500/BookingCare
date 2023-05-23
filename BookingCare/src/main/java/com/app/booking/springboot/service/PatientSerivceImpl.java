package com.app.booking.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.PatientDao;
import com.app.booking.springboot.entity.Patient;
@Service("patientService")
@Transactional
public class PatientSerivceImpl implements PatientSerivce {
	@Autowired
	PatientDao patientDao;
	@Override
	public Patient savePatient(Patient pt) throws Exception {
		// TODO Auto-generated method stub
		return patientDao.savePatient(pt);
	}

}
