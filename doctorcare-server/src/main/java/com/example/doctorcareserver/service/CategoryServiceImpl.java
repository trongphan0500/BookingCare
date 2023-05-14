package com.example.doctorcareserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.doctorcareserver.dao.CategoryDao;
import com.example.doctorcareserver.entity.Category;



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
	public List<Category> findAll(int categoryId) throws Exception {
		return categoryDao.findAll(categoryId);
	}

}
