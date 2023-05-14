package com.example.doctorcareserver.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;


import com.app.bookingcare.enums.StoreProcedureStatusCodeEnum;
import com.app.bookingcare.exceptions.TechresHttpException;
import com.example.doctorcareserver.dao.AbstractDao;
import com.example.doctorcareserver.dao.UserDao;
import com.example.doctorcareserver.entity.Doctor;
import com.example.doctorcareserver.entity.Patient;
import com.example.doctorcareserver.entity.User;

@Repository
@SuppressWarnings("unchecked")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public List<User> getAll() throws Exception {
		return (List<User>) this.getSession().get(User.class, 1);
	}

	@Override
	public Patient savePatient(Patient pt) throws Exception {
		// TODO Auto-generated method stub
		Patient ptn = new Patient("Thang", "Thang@gmail.com", "123", "go vap", "03909090", null, 1, null, 1, 1, 1, 1, null, null, null, null, null, 56,65, null, null, null);
		Patient patient =  (Patient) this.getSession().merge(pt);
		System.out.println(patient);
		return patient;
	}
	@Override
	public Patient getPatientById(int id) {
		// TODO Auto-generated method stub
		ArrayList<Patient> list = (ArrayList<Patient>) this.getSession().createQuery("FROM Patient P WHERE P.id = 35").list();
		return  list.get(0);
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		ArrayList<Doctor> list = (ArrayList<Doctor>) this.getSession().createQuery("FROM Doctor D WHERE D.id = 1").list();
		return list.get(0);
	}
}
