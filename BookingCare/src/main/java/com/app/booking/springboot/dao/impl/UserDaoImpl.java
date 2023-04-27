package com.app.booking.springboot.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.app.booking.springboot.dao.UserDao;
import com.app.booking.springboot.entity.User;

@Repository
@SuppressWarnings("unchecked")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public User findOne(int id) throws Exception {
		return (User) this.getSession().createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
	}
}
