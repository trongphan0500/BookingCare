package com.app.booking.springboot.service;

import java.util.List;

import com.app.booking.springboot.entity.ExamninationHistory;

public interface ExaminitionHistoryService {
	public ExamninationHistory addExamninationHistory(ExamninationHistory examninationHistory);
	public List<ExamninationHistory> getAllex(int id);
}
