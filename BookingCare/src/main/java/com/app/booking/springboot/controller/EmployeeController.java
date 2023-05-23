package com.app.booking.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.springboot.response.BaseResponse;
import com.app.booking.springboot.response.EmployeeResponse;
import com.app.booking.springboot.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getEmployees(
			@RequestParam(name = "employee_id", required = true, defaultValue = "-1") int employeeId,
			@RequestParam(name = "key_search", required = true, defaultValue = "") String keySearch,
			@RequestParam(name = "is_login", required = true, defaultValue = "-1") int isLogin,
			@RequestParam(name = "is_active", required = true, defaultValue = "-1") int isActive) throws Exception {
		BaseResponse response = new BaseResponse<>();
		response.setData(new EmployeeResponse()
				.mapToList(employeeService.getEmployees(employeeId, keySearch, isLogin, isActive)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
