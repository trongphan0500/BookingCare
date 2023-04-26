package com.app.booking.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.booking.springboot.dao.CategoryDao;
import com.app.booking.springboot.entity.Category;

@Service("categorySerive")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category findOne(int id) throws Exception {
		return categoryDao.findOne(id);
	}

	@Override
	public Category createCategory(String name) throws Exception {
		return categoryDao.createCategory(name);
	}

}
