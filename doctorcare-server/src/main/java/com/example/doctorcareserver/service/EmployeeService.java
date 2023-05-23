package com.example.doctorcareserver.service;

import java.util.List;

import com.example.doctorcareserver.entity.model.storeProcedure.EmployeeModal;



public interface EmployeeService {

	List<EmployeeModal> getEmployees(int employeeId, String keySearch, int isLogin, int isActive) throws Exception;
}
