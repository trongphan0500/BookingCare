package com.app.booking.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.springboot.response.BaseResponse;
import com.app.booking.springboot.response.CategoryResponse;
import com.app.booking.springboot.service.CategoryService;

@RestController
@RequestMapping("api/categories")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CategoryController extends BaseController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createCategory(@RequestBody String name) throws Exception {
		BaseResponse response = new BaseResponse();

		response.setData(new CategoryResponse(categoryService.createCategory(name)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getCategories(
			@RequestParam(name = "category_id", required = true, defaultValue = "-1") int categoryId) throws Exception {
		BaseResponse response = new BaseResponse<>();
		response.setData(new CategoryResponse().mapToList(categoryService.findAll(categoryId)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
