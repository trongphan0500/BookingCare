package com.app.booking.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.springboot.entity.Specialization;
import com.app.booking.springboot.response.BaseListDataResponse;
import com.app.booking.springboot.response.BaseResponse;
import com.app.booking.springboot.response.SpecializationResponse;
import com.app.booking.springboot.service.DoctorService;
import com.app.booking.springboot.service.SpecializtionService;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;

@RestController
@RequestMapping("api/doctors")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private SpecializtionService specializtionService;

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getHistoryExamination(
			@RequestParam(name = "patient_id", required = true, defaultValue = "-1") int patientId,
			@RequestParam(name = "key_search", required = true, defaultValue = "") String keySearch) throws Exception {
		BaseResponse response = new BaseResponse<>();
		doctorService.getHistoryExamination(patientId, keySearch);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/specialties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse<BaseListDataResponse<SpecializationResponse>>> getSpecialization(
			@RequestParam(name = "specialization_id", required = true, defaultValue = "-1") int specializationId,
			@RequestParam(name = "key_search", required = true, defaultValue = "") String keySearch,
			@RequestParam(name = "limit", required = true, defaultValue = "-1") int limit,
			@RequestParam(name = "page", required = true, defaultValue = "-1") int page,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse<BaseListDataResponse<SpecializationResponse>> response = new BaseResponse();

		Pagination pagination = new Pagination(page, limit);

		StoreProcedureListResult<Specialization> specialties = specializtionService.getSpecialization(specializationId,
				keySearch, pagination);
		BaseListDataResponse<SpecializationResponse> listData = new BaseListDataResponse<>();

		listData.setList(new SpecializationResponse().mapToList(specialties.getResult()));

		listData.setLimit(pagination.getLimit());
		listData.setTotalRecord(specialties.getTotalRecord());

		response.setData(listData);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
