package com.app.booking.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.ExaminitionHistoryDao;
import com.app.booking.springboot.entity.ExamninationHistory;

@Service("examinitionHistoryService")
@Transactional
public class ExaminitionHistoryServiceImpl implements ExaminitionHistoryService {
	@Autowired
	ExaminitionHistoryDao examinitionHistoryDao;
	@Override
	public ExamninationHistory addExamninationHistory(ExamninationHistory examninationHistory) {
		// TODO Auto-generated method stub
		return examinitionHistoryDao.addExamninationHistory(examninationHistory);
	}
	@Override
	public List<ExamninationHistory> getAllex(int id) {
		// TODO Auto-generated method stub
		return examinitionHistoryDao.getAllex(id);
	}

}
