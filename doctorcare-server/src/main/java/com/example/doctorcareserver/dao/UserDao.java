package com.example.doctorcareserver.dao;


import java.util.List;

import com.example.doctorcareserver.entity.Doctor;
import com.example.doctorcareserver.entity.Patient;
import com.example.doctorcareserver.entity.User;



public interface UserDao {
	List<User> getAll() throws Exception;
	Patient savePatient(Patient pt)  throws Exception;
	Patient getPatientById(int id);
	Doctor getDoctorById(int id);
}
