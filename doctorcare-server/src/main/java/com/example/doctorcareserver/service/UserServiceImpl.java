package com.example.doctorcareserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;
import com.example.doctorcareserver.dao.UserDao;
import com.example.doctorcareserver.entity.Doctor;
import com.example.doctorcareserver.entity.Employee;
import com.example.doctorcareserver.entity.Patient;
import com.example.doctorcareserver.entity.Role;
import com.example.doctorcareserver.entity.User;
import com.example.doctorcareserver.entity.model.storeProcedure.UserModal;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findOne(int id) throws Exception {
		return userDao.findOne(id);
	}

	@Override
	public void update(User entity) throws Exception {
		userDao.update(entity);
	}

	@Override
	public List<Role> getAllRole(String pre) throws Exception {
		return userDao.getAllRole(pre);
	}

	@Override
	public void createDoctor(Doctor doctor) throws Exception {
		userDao.createDoctor(doctor);
	}

	@Override
	public void createPatient(Patient patient) throws Exception {
		userDao.createPatient(patient);
	}

	@Override
	public void createEmployee(Employee employee) throws Exception {
		userDao.createEmployee(employee);
	}

	@Override
	public Role getRole(int id) throws Exception {
		return userDao.getRole(id);
	}

	@Override
	public StoreProcedureListResult<UserModal> getUsers(int userId, String keySearch, int sortBy, int isActive,
			int userDefine, Pagination pagination) throws Exception {
		return userDao.getUsers(userId, keySearch, sortBy, isActive, userDefine, pagination);
	}

	@Override
	public void updateDoctor(Doctor doctor) throws Exception {
		userDao.updateDoctor(doctor);
	}

	@Override
	public void updatePatient(Patient patient) throws Exception {
		userDao.updatePatient(patient);
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		userDao.updateEmployee(employee);
	}

	@Override
	public void deleteDoctor(Doctor doctor) throws Exception {
		userDao.deleteDoctor(doctor);
	}

	@Override
	public void deletePatient(Patient doctor) throws Exception {
		userDao.deletePatient(doctor);
	}

	@Override
	public void deleteEmployee(Employee employee) throws Exception {
		userDao.deleteEmployee(employee);
	}

	@Override
	public Doctor findDoctor(int id) throws Exception {
		return userDao.findDoctor(id);
	}

	@Override
	public Patient findPatient(int id) throws Exception {
		return userDao.findPatient(id);
	}

	@Override
	public Employee findEmployee(int id) throws Exception {
		return userDao.findEmployee(id);
	}

}