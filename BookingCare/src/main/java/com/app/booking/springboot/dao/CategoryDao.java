package com.app.booking.springboot.dao;

import com.app.booking.springboot.entity.Category;

public interface CategoryDao {
		
	Category findOne(int id) throws Exception;
	
	Category createCategory(String name) throws Exception;
}
