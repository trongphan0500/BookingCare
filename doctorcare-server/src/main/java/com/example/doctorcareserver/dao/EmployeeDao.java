package com.example.doctorcareserver.dao;

import java.util.List;

import com.example.doctorcareserver.entity.model.storeProcedure.EmployeeModal;



public interface EmployeeDao {

	List<EmployeeModal> getEmployees(int employeeId, String keySearch, int isLogin,int isActive) throws Exception;
	
}
