package com.example.doctorcareserver.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.doctorcareserver.entity.User;
import com.example.doctorcareserver.request.CreateWarehouseSessionRequest;
import com.example.doctorcareserver.response.BaseResponse;
import com.example.doctorcareserver.service.WarehouseSessionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/warehouses")
@CrossOrigin(origins = "http://localhost:9000")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class WarehouseController extends BaseController {

	@Autowired
	private WarehouseSessionService warehouseSessionService;

	@PostMapping(value = "/create-warehouse", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createWarehouseSession(
			@Valid @RequestBody CreateWarehouseSessionRequest wrapper,
			@RequestHeader(value = "Authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();

		User userToken = this.handleTokenAccess(token);

		String json = new ObjectMapper().writeValueAsString(wrapper.getWarehouseSessionRequests());

		warehouseSessionService.createWarehouseSession(userToken.getId(), wrapper.getDiscountPercent(),
				wrapper.getType(), wrapper.getDiscountAmount(), wrapper.getManufactureDate(), wrapper.getExpiryDate(),
				wrapper.getDescription(), json);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
