package com.example.doctorcareserver.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.doctorcareserver.dao.AbstractDao;
import com.example.doctorcareserver.dao.ExaminitionHistoryDao;
import com.example.doctorcareserver.entity.ExamninationHistory;
import com.example.doctorcareserver.entity.Medicine;
@Repository()
@SuppressWarnings("unchecked")
public class ExaminitionHistoryDaoImpl extends AbstractDao<Integer, ExamninationHistory> implements ExaminitionHistoryDao {

	@Override
	public ExamninationHistory addExamninationHistory(ExamninationHistory examninationHistory) {
		this.getSession().save(examninationHistory);
		// TODO Auto-generated method stub
		return null;
	}
	

}
