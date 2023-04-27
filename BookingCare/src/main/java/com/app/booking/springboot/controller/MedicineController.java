package com.app.booking.springboot.controller;

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

import com.app.booking.springboot.request.CreateMedicineRequest;
import com.app.booking.springboot.response.BaseResponse;
import com.app.booking.springboot.response.MedicineResponse;
import com.app.booking.springboot.service.CategoryService;
import com.app.booking.springboot.service.MedicineService;

@RestController
@RequestMapping("api/medicines")
@CrossOrigin(origins = "http://localhost:9000")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class MedicineController extends BaseController {

	@Autowired
	private MedicineService medicineService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getMedicines(
			@RequestParam(name = "category_id", required = true, defaultValue = "-1") int categoryId,
			@RequestParam(name = "medicine_id", required = false, defaultValue = "-1") int medicineId,
			@RequestParam(name = "key_search", required = false, defaultValue = "") String keySearch,
			@RequestParam(name = "status", required = false, defaultValue = "1") int status) throws Exception {
		BaseResponse response = new BaseResponse();
		
		response.setData(new MedicineResponse()
				.mapToList(medicineService.getMedicines(categoryId, medicineId, keySearch, status)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spAddMedicine(@RequestBody CreateMedicineRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();

		response.setData(new MedicineResponse(medicineService.createMedicine(wrapper.getCategoryId(), wrapper.getName(),
				wrapper.getAvatar(), wrapper.getExpiryDate(), wrapper.getOutStockAlertQuantity(),
				wrapper.getRetailPrice(), wrapper.getCostPrice(), wrapper.getStatus(), wrapper.getNote(),
				wrapper.getStorageUnit(), wrapper.getUseUnit(), wrapper.getMethodOfUse(), wrapper.getOriginalName(),
				wrapper.getOutExpiryDateAlert())));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
