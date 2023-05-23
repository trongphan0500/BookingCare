package com.app.booking.springboot.dao;

import java.util.List;

import com.app.booking.springboot.entity.ExamninationHistory;

public interface ExaminitionHistoryDao {
	public ExamninationHistory addExamninationHistory(ExamninationHistory examninationHistory);
	public List<ExamninationHistory> getAllex(int id);

}
