package com.app.booking.spirngboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.spirngboot.dao.MedicineDao;

@RestController
@RequestMapping("api/medicines")
public class MedicineController {

	@Autowired
	private MedicineDao medicineDao;

	@GetMapping(value = "/add", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String spAddMedicine() throws Exception {
//		BaseResponse response = new BaseResponse();
//		Medicine a =  medicineDao.add(medicine);

		// Tạo đối tượng mới để thêm vào cơ sở dữ liệu
//		entity.setId(15);
//		entity.setName("name");
//		entity.setCode("john@example.com");
//		
//		response.setData(medicineDao.save(entity));
//		List<Medicine> medicines = medicineDao.findAll();
		return "Hello";

//		return new ResponseEntity<>(response, HttpStatus.OK);
	}

//	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<BaseResponse> spAddMedicine(@RequestBody CreateMedicineRequest wrapper) throws Exception {
//		BaseResponse response = new BaseResponse();
////		Medicine a =  medicineDao.add(medicine);
//
//		Medicine medicine = new Medicine();
//		
////		medicine.setCategory(1);
//		medicine.setName(wrapper.getName());
//		medicine.setAvatar(wrapper.getAvatar());
//		medicine.setExpiryDate(wrapper.getExpiryDate());
//		medicine.setOutStockAlertQuantity(wrapper.getOutStockAlertQuantity());
//		medicine.setRetailPrice(wrapper.getRetailPrice());
//		medicine.setCostPrice(wrapper.getCostPrice());
//		medicine.setStatus(wrapper.getStatus());
//		medicine.setNote(wrapper.getNote());
//		medicine.setStorageUnit(wrapper.getStorageUnit());
//		medicine.setUseUnit(wrapper.getUseUnit());
//		medicine.setMethodOfUse(wrapper.getMethodOfUse());
//		medicine.setOriginalName(wrapper.getOriginalName());
//		medicine.setOutExpiryDateAlert(wrapper.getOutExpiryDateAlert());
//
//		response.setData(medicineDao.createMedicine(medicine));
//
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
}
