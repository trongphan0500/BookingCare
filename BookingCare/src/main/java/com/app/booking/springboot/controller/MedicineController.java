package com.app.booking.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.springboot.entity.Medicine;
import com.app.booking.springboot.entity.User;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineInventoryNew;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineWaningModel;
import com.app.booking.springboot.request.CreateMedicineRequest;
import com.app.booking.springboot.request.CreateWarehouseSessionRequest;
import com.app.booking.springboot.request.UpdateMedicineRequest;
import com.app.booking.springboot.response.BaseListDataResponse;
import com.app.booking.springboot.response.BaseResponse;
import com.app.booking.springboot.response.MedicineHistoryResponse;
import com.app.booking.springboot.response.MedicineInventoryResponseNew;
import com.app.booking.springboot.response.MedicineResponse;
import com.app.booking.springboot.response.MedicineWarningResponse;
import com.app.booking.springboot.service.CategoryService;
import com.app.booking.springboot.service.MedicineService;
import com.app.booking.springboot.service.WarehouseSessionService;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;
import com.app.bookingcare.exceptions.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/medicines")
@CrossOrigin(origins = "http://localhost:9000")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class MedicineController extends BaseController {

	@Autowired
	private MedicineService medicineService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private WarehouseSessionService warehouseSessionService;

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse<BaseListDataResponse<MedicineResponse>>> getMedicines(
			@RequestParam(name = "category_id", required = true, defaultValue = "-1") int categoryId,
			@RequestParam(name = "medicine_id", required = false, defaultValue = "-1") int medicineId,
			@RequestParam(name = "key_search", required = false, defaultValue = "") String keySearch,
			@RequestParam(name = "status", required = false, defaultValue = "-1") int status,
			@RequestParam(name = "sort_by", required = false, defaultValue = "0") int sortBy,
			@RequestParam(name = "limit", required = true, defaultValue = "-1") int limit,
			@RequestParam(name = "page", required = true, defaultValue = "-1") int page) throws Exception {
		BaseResponse<BaseListDataResponse<MedicineResponse>> response = new BaseResponse<>();

		Pagination pagination = new Pagination(page, limit);

		StoreProcedureListResult<Medicine> medicines = medicineService.getMedicines(categoryId, medicineId, keySearch,
				status, sortBy, pagination);
		BaseListDataResponse<MedicineResponse> listData = new BaseListDataResponse<>();
		listData.setList(new MedicineResponse().mapToList(medicines.getResult()));

		listData.setLimit(pagination.getLimit());
		listData.setTotalRecord(medicines.getTotalRecord());

		response.setData(listData);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getMedicine(@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();

		response.setData(new MedicineResponse(medicineService.getMedicine(id)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spAddMedicine(@Valid @RequestBody CreateMedicineRequest wrapper)
			throws Exception {
		BaseResponse response = new BaseResponse();

		response.setData(new MedicineResponse(
				medicineService.createMedicine(wrapper.getCategoryId(), wrapper.getName(), wrapper.getAvatar(),
						wrapper.getExpiryDate(), wrapper.getOutStockAlertQuantity(), wrapper.getRetailPrice(),
						wrapper.getCostPrice(), wrapper.getStatus(), wrapper.getNote(), wrapper.getStorageUnit(),
						wrapper.getMethodOfUse(), wrapper.getOriginalName(), wrapper.getOutExpiryDateAlert())));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/inventory/medicines", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse<BaseListDataResponse<MedicineInventoryResponseNew>>> getMedicineInventory(
			@RequestParam(name = "category_id", required = true, defaultValue = "-1") int categoryId,
			@RequestParam(name = "medicine_id", required = false, defaultValue = "-1") int medicineId,
			@RequestParam(name = "key_search", required = false, defaultValue = "") String keySearch,
			@RequestParam(name = "status", required = false, defaultValue = "-1") int status,
			@RequestParam(name = "sort_by", required = false, defaultValue = "0") int sortBy,
			@RequestParam(name = "is_expiry", required = false, defaultValue = "0") int isExpiry,
			@RequestParam(name = "limit", required = true, defaultValue = "-1") int limit,
			@RequestParam(name = "page", required = true, defaultValue = "-1") int page) throws Exception {
		BaseResponse response = new BaseResponse();

		Pagination pagination = new Pagination(page, limit);

		StoreProcedureListResult<MedicineInventoryNew> medicines = medicineService.getInventoryMedicines(categoryId,
				medicineId, isExpiry, keySearch, status, sortBy, pagination);
		BaseListDataResponse<MedicineInventoryResponseNew> listData = new BaseListDataResponse<>();
		listData.setList(new MedicineInventoryResponseNew().mapToList(medicines.getResult()));

		listData.setLimit(pagination.getLimit());
		listData.setTotalRecord(medicines.getTotalRecord());

		response.setData(listData);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

//	@GetMapping(value = "/inventory", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<BaseResponse> getMedicineInventory(
//			@RequestParam(name = "category_id", required = true, defaultValue = "-1") int categoryId,
//			@RequestParam(name = "medicine_id", required = false, defaultValue = "-1") int medicineId)
//			throws Exception {
//		BaseResponse response = new BaseResponse();
//
//		response.setData(
//				new MedicineInventoryResponse().mapToList(medicineService.getMedicineInvetory(categoryId, medicineId)));
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}

//	@PostMapping(value = "/{id}/update", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<BaseResponse> updateMedicine(@PathVariable("id") int id,
//			@RequestBody UpdateMedicineRequest wrapper) throws Exception {
//		BaseResponse response = new BaseResponse();
//
//		Medicine medicine = medicineService.getMedicine(id);
//
////		medicine.ca(wrapper.getCategoryId());
//		medicine.setName(wrapper.getName());
//		medicine.setAvatar(wrapper.getAvatar());
//		medicine.setExpiryDate(wrapper.getExpiryDate());
//		medicine.setOutStockAlertQuantity(wrapper.getOutStockAlertQuantity());
//		medicine.setRetailPrice(wrapper.getRetailPrice());
//		medicine.setCostPrice(wrapper.getCostPrice());
//		medicine.setStatus(wrapper.getStatus());
//		medicine.setNote(wrapper.getNote());
//		medicine.setStorageUnit(wrapper.getStorageUnit());
//		medicine.setOutExpiryDateAlert(wrapper.getOutExpiryDateAlert());
//
//		medicineService.updateMedicine(medicine);
//
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}

	@PostMapping(value = "/{id}/update", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> updateMedicine(@PathVariable("id") int id,
			@Valid @RequestBody UpdateMedicineRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();

		medicineService.updateMedicine(wrapper.getCategoryId(), id, wrapper.getName(), wrapper.getAvatar(),
				wrapper.getExpiryDate(), wrapper.getOutStockAlertQuantity(), wrapper.getRetailPrice(),
				wrapper.getCostPrice(), wrapper.getStatus(), wrapper.getNote(), wrapper.getStorageUnit(),
				wrapper.getUseUnit(), wrapper.getMethodOfUse(), wrapper.getOriginalName(),
				wrapper.getOutExpiryDateAlert());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/history", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getMedicineHistory(
			@RequestParam(name = "medicine_id", required = false, defaultValue = "-1") int medicineId,
			@RequestParam(name = "from_date", required = false, defaultValue = "") String fromDate,
			@RequestParam(name = "to_date", required = false, defaultValue = "") String toDate,
			@RequestParam(name = "key_search", required = false, defaultValue = "") String keySearch,
			@RequestParam(name = "status", required = false, defaultValue = "1") int status

	) throws Exception {
		BaseResponse response = new BaseResponse();

		response.setData(new MedicineHistoryResponse().mapToList(medicineService.getMedicineHistory(medicineId,
				Utils.convertStringFood(fromDate), Utils.convertStringFood(toDate), keySearch, status)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/warning", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse<BaseListDataResponse<MedicineWarningResponse>>> getWarningMedicine(
			@RequestParam(name = "category_id", required = true, defaultValue = "-1") int categoryId,
			@RequestParam(name = "is_expiry_date_alert", required = false, defaultValue = "0") int isExpriyDateAlert,
			@RequestParam(name = "key_search", required = false, defaultValue = "") String keySearch,
			@RequestParam(name = "from_date", required = false, defaultValue = "") String fromDate,
			@RequestParam(name = "to_date", required = false, defaultValue = "") String toDate,
			@RequestParam(name = "sort_by", required = false, defaultValue = "0") int sorBy,
			@RequestParam(name = "limit", required = true, defaultValue = "-1") int limit,
			@RequestParam(name = "page", required = true, defaultValue = "-1") int page

	) throws Exception {
		BaseResponse<BaseListDataResponse<MedicineWarningResponse>> response = new BaseResponse();

		Pagination pagination = new Pagination(page, limit);

//		response.setData(new MedicineWarningResponse().mapToList(
//				medicineService.getWarningMedicine(categoryId, isExpriyDateAlert, keySearch, fromDate, toDate, sorBy)));
		StoreProcedureListResult<MedicineWaningModel> medicines = medicineService.getWarningMedicine(categoryId,
				isExpriyDateAlert, keySearch, fromDate, toDate, sorBy, pagination);
		BaseListDataResponse<MedicineWarningResponse> listData = new BaseListDataResponse<>();
		listData.setList(new MedicineWarningResponse().mapToList(medicines.getResult()));

		listData.setLimit(pagination.getLimit());
		listData.setTotalRecord(medicines.getTotalRecord());

		response.setData(listData);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

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
