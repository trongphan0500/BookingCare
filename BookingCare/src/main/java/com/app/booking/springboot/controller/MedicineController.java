package com.app.booking.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.springboot.entity.Medicine;
import com.app.booking.springboot.entity.User;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineAvatar;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineHistoryModal;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineInventoryNew;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineWaningModel;
import com.app.booking.springboot.request.CreateMedicineRequest;
import com.app.booking.springboot.request.CreateWarehouseSessionRequest;
import com.app.booking.springboot.request.UpdateMedicineRequest;
import com.app.booking.springboot.request.UploadAvatarRequest;
import com.app.booking.springboot.response.BaseListDataResponse;
import com.app.booking.springboot.response.BaseResponse;
import com.app.booking.springboot.response.MedicineDetailResponse;
import com.app.booking.springboot.response.MedicineHistoryResponse;
import com.app.booking.springboot.response.MedicineInventoryResponseNew;
import com.app.booking.springboot.response.MedicineResponse;
import com.app.booking.springboot.response.MedicineWarningResponse;
import com.app.booking.springboot.service.CategoryService;
import com.app.booking.springboot.service.MedicineService;
import com.app.booking.springboot.service.WarehouseSessionService;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;
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

		StoreProcedureListResult<MedicineAvatar> medicines = medicineService.getMedicines(categoryId, medicineId,
				keySearch, status, sortBy, pagination);
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

		response.setData(new MedicineDetailResponse(medicineService.getMedicine(id)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse<BaseListDataResponse<MedicineResponse>>> spAddMedicine(
			@Valid @RequestBody CreateMedicineRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();

//		response.setData(medicineService.createMedicine(wrapper.getCategoryId(), wrapper.getName(), wrapper.getAvatar(),
//				wrapper.getExpiryDate(), wrapper.getOutStockAlertQuantity(), wrapper.getRetailPrice(),
//				wrapper.getCostPrice(), wrapper.getStatus(), wrapper.getNote(), wrapper.getStorageUnit(),
//				wrapper.getMethodOfUse(), wrapper.getOriginalName(), wrapper.getOutExpiryDateAlert()));
		StoreProcedureListResult<MedicineAvatar> medicines = medicineService.createMedicine(wrapper.getCategoryId(),
				wrapper.getName(), wrapper.getAvatar(), wrapper.getExpiryDate(), wrapper.getOutStockAlertQuantity(),
				wrapper.getRetailPrice(), wrapper.getCostPrice(), wrapper.getStatus(), wrapper.getNote(),
				wrapper.getStorageUnit(), wrapper.getMethodOfUse(), wrapper.getOriginalName(),
				wrapper.getOutExpiryDateAlert());

		response.setData(medicines.getResult());
		response.setMessage(medicines.getMessageError());
		response.setStatus(medicines.getStatusCode());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/upload-avatar", consumes = { "multipart/form-data" })
	public void uploadAvatar(@RequestHeader(value = "authorization") String token,
			@Valid @ModelAttribute UploadAvatarRequest wrapper) throws Exception {
		Medicine medicine = medicineService.findOne(wrapper.getId());
		medicine.setAvatar(wrapper.getAvatar());

		medicineService.uploadAvatar(medicine);

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

	@PostMapping(value = "/{id}/update", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> updateMedicine(@PathVariable("id") int id,
			@Valid @RequestBody UpdateMedicineRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();

		StoreProcedureListResult update = medicineService.updateMedicine(wrapper.getCategoryId(), id, wrapper.getName(),
				wrapper.getAvatar(), wrapper.getExpiryDate(), wrapper.getOutStockAlertQuantity(),
				wrapper.getRetailPrice(), wrapper.getCostPrice(), wrapper.getStatus(), wrapper.getNote(),
				wrapper.getStorageUnit(), wrapper.getUseUnit(), wrapper.getMethodOfUse(), wrapper.getOriginalName(),
				wrapper.getOutExpiryDateAlert());

		response.setData(update.getResult());
		response.setMessage(update.getMessageError());
		response.setStatus(update.getStatusCode());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/history", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse<BaseListDataResponse<MedicineHistoryResponse>>> getMedicineHistory(
			@RequestParam(name = "medicine_id", required = false, defaultValue = "-1") int medicineId,
			@RequestParam(name = "from_date", required = false, defaultValue = "") String fromDate,
			@RequestParam(name = "to_date", required = false, defaultValue = "") String toDate,
			@RequestParam(name = "key_search", required = false, defaultValue = "") String keySearch,
			@RequestParam(name = "status", required = false, defaultValue = "-1") int status,
			@RequestParam(name = "limit", required = false, defaultValue = "-1") int limit,
			@RequestParam(name = "page", required = false, defaultValue = "-1") int page

	) throws Exception {
		BaseResponse response = new BaseResponse();

		Pagination pagination = new Pagination(page, limit);

		StoreProcedureListResult<MedicineHistoryModal> medicines = medicineService.getMedicineHistory(medicineId,
				fromDate, toDate, keySearch, status, pagination);
		BaseListDataResponse<MedicineHistoryResponse> listData = new BaseListDataResponse<>();
		listData.setList(new MedicineHistoryResponse().mapToList(medicines.getResult()));

		listData.setLimit(pagination.getLimit());
		listData.setTotalRecord(medicines.getTotalRecord());

		response.setData(listData);

//		response.setData(new MedicineHistoryResponse().mapToList(medicineService.getMedicineHistory(medicineId,
//				Utils.convertStringFood(fromDate), Utils.convertStringFood(toDate), keySearch, status)));
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

	@GetMapping(value = "/check-quantity", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> checkQuantity(@RequestHeader(value = "Authorization") String token,
			@RequestParam(name = "medicine_id", required = true) int medicineId,
			@RequestParam(name = "quantity", required = true, defaultValue = "-1") int quantity) throws Exception {
		BaseResponse response = new BaseResponse();

		int result = medicineService.checkEnoughQuantity(medicineId, quantity);
		if (result == 1) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Không đủ số lượng");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
