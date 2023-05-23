package com.app.booking.springboot.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.app.booking.springboot.controller.BaseController;
import com.app.booking.springboot.entity.model.storeProcedure.Report;

public class ReportResponse extends BaseController {

	private String date;

	private BigDecimal revenue;

	private BigDecimal cost;

	private BigDecimal profit;

	public ReportResponse() {
	}

	public ReportResponse(Report entity) {
		this.date = (entity.getDate());
		this.revenue = entity.getRevenue();
		this.cost = entity.getCost();
		this.profit = entity.getProfit();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<ReportResponse> mapToList(List<Report> entiies) {
		return entiies.stream().map(x -> new ReportResponse(x)).collect(Collectors.toList());
	}

	public BigDecimal getRevenue() {
		return revenue;
	}

	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

}
