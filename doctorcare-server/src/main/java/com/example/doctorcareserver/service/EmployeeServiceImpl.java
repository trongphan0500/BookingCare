package com.example.doctorcareserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.doctorcareserver.dao.EmployeeDao;
import com.example.doctorcareserver.entity.model.storeProcedure.EmployeeModal;



@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<EmployeeModal> getEmployees(int employeeId, String keySearch, int isLogin, int isActive)
			throws Exception {
		return employeeDao.getEmployees(employeeId, keySearch, isLogin, isActive);
	}

}
