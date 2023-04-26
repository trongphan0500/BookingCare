package com.app.booking.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.springboot.entity.Category;
import com.app.booking.springboot.entity.Medicine;
import com.app.booking.springboot.request.CreateMedicineRequest;
import com.app.booking.springboot.response.BaseResponse;
import com.app.booking.springboot.service.CategoryService;
import com.app.booking.springboot.service.MedicineService;

@RestController
@RequestMapping("api/medicines")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Category spAddMedicine() throws Exception {

		return categoryService.findOne(1);
	}

	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spAddMedicine(@RequestBody CreateMedicineRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();

		Medicine medicine = new Medicine();
		Category category = categoryService.findOne(wrapper.getCategoryId());

		medicine.setCategory(category);
		medicine.setName(wrapper.getName());
		medicine.setAvatar(wrapper.getAvatar());
		medicine.setExpiryDate(wrapper.getExpiryDate());
		medicine.setOutStockAlertQuantity(wrapper.getOutStockAlertQuantity());
		medicine.setRetailPrice(wrapper.getRetailPrice());
		medicine.setCostPrice(wrapper.getCostPrice());
		medicine.setStatus(wrapper.getStatus());
		medicine.setNote(wrapper.getNote());
		medicine.setStorageUnit(wrapper.getStorageUnit());
		medicine.setUseUnit(wrapper.getUseUnit());
		medicine.setMethodOfUse(wrapper.getMethodOfUse());
		medicine.setOriginalName(wrapper.getOriginalName());
		medicine.setOutExpiryDateAlert(wrapper.getOutExpiryDateAlert());
		medicineService.createMedicine(medicine);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
