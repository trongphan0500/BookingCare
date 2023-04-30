package com.app.booking.springboot.service;

import java.util.List;

import com.app.booking.springboot.entity.Category;

public interface CategoryService {

	Category findOne(int id) throws Exception;
	
	Category createCategory(String name) throws Exception;
	
	List<Category> findAll() throws Exception;
}
