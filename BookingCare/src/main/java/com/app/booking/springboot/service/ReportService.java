package com.app.booking.springboot.service;

import java.util.List;

import com.app.booking.springboot.entity.model.storeProcedure.BestSeller;
import com.app.booking.springboot.entity.model.storeProcedure.Inventory;
import com.app.booking.springboot.entity.model.storeProcedure.OutOfStock;
import com.app.booking.springboot.entity.model.storeProcedure.Report;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;

public interface ReportService {

	List<Report> spCreateReport(int reportType, String fromDate, String toDate) throws Exception;

	StoreProcedureListResult<BestSeller> spGetBestSeller(String fromDate, String toDate, int limit) throws Exception;

	List<Inventory> spGetInventory() throws Exception;

	StoreProcedureListResult<OutOfStock> spGetOutOfStock(Pagination pagination) throws Exception;
}
