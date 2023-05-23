package com.app.booking.spirngboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.spirngboot.dao.MedicineDao;
import com.app.booking.spirngboot.entity.Medicine;
import com.app.booking.spirngboot.response.BaseResponse;

@RestController
@RequestMapping("api/medicines")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class MedicineController {

	@Autowired
	private MedicineDao medicineDao;
	
	@PostMapping(value = "/add", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spAddMedicine(@RequestBody Medicine entity) throws Exception {
		BaseResponse response = new BaseResponse();
//		Medicine a =  medicineDao.add(medicine);
		
		// Tạo đối tượng mới để thêm vào cơ sở dữ liệu
		entity.setId(1);
		entity.setName("name");
		entity.setCode("john@example.com");

		entity.setId(2);
		entity.setName("name2");
		entity.setCode("john@example.com");
		entity.setId(3);
		entity.setName("name2");
		entity.setCode("john@example.com");

		// entity.setId(3);
		// entity.setName("name2");
		// entity.setCode("john@example.com");

		response.setData(medicineDao.save(entity));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
