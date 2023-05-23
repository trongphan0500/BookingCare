package com.app.booking.springboot.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.ExaminitionHistoryDao;
import com.app.booking.springboot.entity.ExamninationHistory;


@Repository("ExaminitionHistoryDao")
@Transactional
@SuppressWarnings("unchecked")
public class ExaminitionHistoryDaoImpl extends AbstractDao<Integer, ExamninationHistory> implements ExaminitionHistoryDao {

	@Override
	public ExamninationHistory addExamninationHistory(ExamninationHistory examninationHistory) {
		ExamninationHistory ex =  (ExamninationHistory) this.getSession().merge(examninationHistory);
		// TODO Auto-generated method stub
		return ex;
	}

	@Override
	public List<ExamninationHistory> getAllex(int id) {
		// TODO Auto-generated method stub
		List<ExamninationHistory> ds = (List<ExamninationHistory>) this.getSession().createQuery("FROM ExamninationHistory E WHERE E.patient = "+id).list();
		System.out.println(ds.size());
		return ds;
	}
	

}
