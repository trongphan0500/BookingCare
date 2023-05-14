package com.example.doctorcareserver.service;

import java.util.List;

import com.example.doctorcareserver.entity.Category;



public interface CategoryService {

	Category findOne(int id) throws Exception;
	
	Category createCategory(String name) throws Exception;
	
	List<Category> findAll(int categoryId) throws Exception;
}
