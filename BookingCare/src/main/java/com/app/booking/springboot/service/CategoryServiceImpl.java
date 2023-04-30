package com.app.booking.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.CategoryDao;
import com.app.booking.springboot.entity.Category;

@Service("categorySerive")
@Transactional
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

	@Override
	public List<Category> findAll() throws Exception {
		return categoryDao.findAll();
	}

}
