package com.app.booking.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.booking.springboot.entity.model.storeProcedure.BestSeller;
import com.app.booking.springboot.entity.model.storeProcedure.OutOfStock;
import com.app.booking.springboot.response.BaseListDataResponse;
import com.app.booking.springboot.response.BaseResponse;
import com.app.booking.springboot.response.BestSellerResponse;
import com.app.booking.springboot.response.OutOfStockResponse;
import com.app.booking.springboot.response.ReportResponse;
import com.app.booking.springboot.service.ReportService;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;

@RestController
@RequestMapping("api/reports")
@CrossOrigin(origins = "http://localhost:9000")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ReportController extends BaseController {

	@Autowired
	private ReportService reportService;

	@GetMapping(value = "/profit-revenue", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spGCreateReport(@RequestParam("report_type") int reportType,
			@RequestParam("from_date") String fromDateString, @RequestParam("to_date") String toDateString,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();

		response.setData(
				new ReportResponse().mapToList(reportService.spCreateReport(reportType, fromDateString, toDateString)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/best-seller", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse<BaseListDataResponse<BestSellerResponse>>> getBestSeller(
			@RequestParam("from_date") String fromDate, @RequestParam("to_date") String toDate,
			@RequestParam(name = "limit", required = false, defaultValue = "-1") int limit,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse<BaseListDataResponse<BestSellerResponse>> response = new BaseResponse<>();

		StoreProcedureListResult<BestSeller> bestSeller = reportService.spGetBestSeller(this.formatDate(fromDate),
				this.formatDate(toDate), limit);

		BaseListDataResponse<BestSellerResponse> listData = new BaseListDataResponse<>();

		listData.setList(new BestSellerResponse().mapToList(bestSeller.getResult()));

		response.setData(listData);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/out-off-stock", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse<BaseListDataResponse<OutOfStockResponse>>> getOutOfStock(
			@RequestParam(name = "limit", required = false, defaultValue = "-1") int limit,
			@RequestParam(name = "page", required = false, defaultValue = "-1") int page,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse<BaseListDataResponse<OutOfStockResponse>> response = new BaseResponse<>();

		Pagination pagination = new Pagination(page, limit);

		StoreProcedureListResult<OutOfStock> medicines = reportService.spGetOutOfStock(pagination);
		BaseListDataResponse<OutOfStockResponse> listData = new BaseListDataResponse<>();
		listData.setList(new OutOfStockResponse().mapToList(medicines.getResult()));

		listData.setLimit(pagination.getLimit());
		listData.setTotalRecord(medicines.getTotalRecord());

		response.setData(listData);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
