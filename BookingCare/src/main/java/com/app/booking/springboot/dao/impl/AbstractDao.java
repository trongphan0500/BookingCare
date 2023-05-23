package com.app.booking.springboot.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;
	
	@Autowired	
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	protected CriteriaBuilder getBuilder() {
		return this.getSession().getCriteriaBuilder();
	}

	
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public T create(T entity) {
		getSession().save(entity);
		return entity;
	}

	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}

	public void update(T entity) {
		this.getSession().update(entity);
	}

	public void delete(T entity) {
		this.getSession().delete(entity);
	}

}
