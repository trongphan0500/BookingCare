package com.app.booking.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.UserDao;
import com.app.booking.springboot.entity.Doctor;
import com.app.booking.springboot.entity.Employee;
import com.app.booking.springboot.entity.Patient;
import com.app.booking.springboot.entity.Role;
import com.app.booking.springboot.entity.User;
import com.app.booking.springboot.entity.model.storeProcedure.UserModal;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;

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

	@Override
	public StoreProcedureListResult<UserModal> spULogin(String phone, String password) throws Exception {
		return userDao.spULogin(phone, password);
	}

	@Override
	public User findByEmail(String email) throws Exception {
		return userDao.findByEmail(email);
	}

	@Override
	public User findByPhone(String phone) throws Exception {
		return userDao.findByPhone(phone);
	}

	@Override
	public User checkEmail(String email, int id) throws Exception {
		return userDao.checkEmail(email, id);
	}

	@Override
	public User checkPhone(String phone, int id) throws Exception {
		return userDao.checkPhone(phone, id);

	}

	@Override
	public List<Patient> findPatientByName(String name) throws Exception {
		return userDao.findPatientByName(name);
	}

	@Override
	public User findPatient(String phone) throws Exception {
		return null;
	}

}
