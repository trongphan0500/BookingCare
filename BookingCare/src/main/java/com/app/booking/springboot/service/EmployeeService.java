package com.app.booking.springboot.service;

import java.util.List;

import com.app.booking.springboot.entity.model.storeProcedure.EmployeeModal;

public interface EmployeeService {

	List<EmployeeModal> getEmployees(int employeeId, String keySearch, int isLogin, int isActive) throws Exception;
}
