package com.app.booking.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.ReportDao;
import com.app.booking.springboot.entity.model.storeProcedure.BestSeller;
import com.app.booking.springboot.entity.model.storeProcedure.Inventory;
import com.app.booking.springboot.entity.model.storeProcedure.OutOfStock;
import com.app.booking.springboot.entity.model.storeProcedure.Report;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;

@Service("reportService")
@Transactional
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportDao dao;

	@Override
	public List<Report> spCreateReport(int reportType, String fromDate, String toDate) throws Exception {
		return dao.spCreateReport(reportType, fromDate, toDate);
	}

	@Override
	public StoreProcedureListResult<BestSeller> spGetBestSeller(String fromDate, String toDate, int limit)
			throws Exception {
		return dao.spGetBestSeller(fromDate, toDate, limit);
	}

	@Override
	public List<Inventory> spGetInventory() throws Exception {
		return null;
	}

	@Override
	public StoreProcedureListResult<OutOfStock> spGetOutOfStock(Pagination pagination) throws Exception {
		return dao.spGetOutOfStock(pagination);
	}

}
