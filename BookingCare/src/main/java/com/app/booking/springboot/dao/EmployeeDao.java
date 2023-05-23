package com.app.booking.springboot.dao;

import java.util.List;

import com.app.booking.springboot.entity.model.storeProcedure.EmployeeModal;

public interface EmployeeDao {

	List<EmployeeModal> getEmployees(int employeeId, String keySearch, int isLogin,int isActive) throws Exception;
}
