package com.app.booking.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.UserDao;
import com.app.booking.springboot.entity.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findOne(int id) throws Exception {
		return userDao.findOne(id);
	}

	@Override
	public void update(User entity) {
		userDao.update(entity);
	}

}
