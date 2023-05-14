package com.example.doctorcareserver.service;

import java.util.List;


import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;
import com.example.doctorcareserver.entity.Doctor;
import com.example.doctorcareserver.entity.Employee;
import com.example.doctorcareserver.entity.Patient;
import com.example.doctorcareserver.entity.Role;
import com.example.doctorcareserver.entity.User;
import com.example.doctorcareserver.entity.model.storeProcedure.UserModal;

public interface UserService {

	User findOne(int id) throws Exception;

	void update(User entity) throws Exception;

	List<Role> getAllRole(String pre) throws Exception;

	Role getRole(int id) throws Exception;

	void createDoctor(Doctor doctor) throws Exception;

	void createPatient(Patient patient) throws Exception;

	void createEmployee(Employee employee) throws Exception;

	void updateDoctor(Doctor doctor) throws Exception;

	void updatePatient(Patient patient) throws Exception;

	void updateEmployee(Employee employee) throws Exception;

	void deleteDoctor(Doctor doctor) throws Exception;

	void deletePatient(Patient patient) throws Exception;

	void deleteEmployee(Employee employee) throws Exception;

	Doctor findDoctor(int id) throws Exception;

	Patient findPatient(int id) throws Exception;

	Employee findEmployee(int id) throws Exception;

	StoreProcedureListResult<UserModal> getUsers(int userId, String keySearch, int sortBy, int isActive, int userDefine,
			Pagination pagination) throws Exception;
}
