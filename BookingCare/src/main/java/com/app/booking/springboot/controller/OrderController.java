package com.app.booking.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.springboot.entity.User;
import com.app.booking.springboot.request.CreateWarehouseSessionRequest;
import com.app.booking.springboot.response.BaseResponse;
import com.app.booking.springboot.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/orders")
@CrossOrigin(origins = "http://localhost:9000")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/create-medicines", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createOrderMedicnes(@Valid @RequestBody CreateWarehouseSessionRequest wrapper,
			@RequestHeader(value = "Authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();

		User userToken = this.handleTokenAccess(token);

		String json = new ObjectMapper().writeValueAsString(wrapper.getWarehouseSessionRequests());

		orderService.createMedicneOrder(userToken.getId(), wrapper.getDiscountPercent(), wrapper.getType(),
				wrapper.getDiscountAmount(), wrapper.getDescription(), json);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/check-quantity", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> checkMedicineQuantity(
			@RequestParam(name = "medicine_id", required = true) int medicineId,
			@RequestParam(name = "quantity", required = true) int quantity) throws Exception {
		BaseResponse response = new BaseResponse();

		int result = orderService.checkQuantityMedicine(medicineId, quantity);

		if (result == 0) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
