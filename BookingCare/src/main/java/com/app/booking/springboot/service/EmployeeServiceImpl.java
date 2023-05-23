package com.app.booking.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.EmployeeDao;
import com.app.booking.springboot.entity.model.storeProcedure.EmployeeModal;

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
