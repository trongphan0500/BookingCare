package com.app.booking.springboot.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.PatientDao;
import com.app.booking.springboot.entity.Patient;
@Repository("patientDao")
@Transactional
@SuppressWarnings("unchecked")
public class PatienDaoImpl extends AbstractDao<Integer, Patient> implements PatientDao {

	@Override
	public Patient savePatient(Patient pt) throws Exception {
		// TODO Auto-generated method stub
		Patient patient =  (Patient) this.getSession().merge(pt);
		return patient;
	}

	@Override
	public Patient getPatientByPhone(String phone) {
		// TODO Auto-generated method stub
//		Patient patient = (Patient) this.getSession().createQuery("SELECT P FROM Patient P WHERE P.p");
		return null;
	}

}
