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
import com.app.booking.springboot.service.DoctorService;

@RestController
@RequestMapping("api/doctors")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getHistoryExamination(
			@RequestParam(name = "patient_id", required = true, defaultValue = "-1") int patientId,
			@RequestParam(name = "key_search", required = true, defaultValue = "") String keySearch) throws Exception {
		BaseResponse response = new BaseResponse<>();
		doctorService.getHistoryExamination(patientId, keySearch);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
