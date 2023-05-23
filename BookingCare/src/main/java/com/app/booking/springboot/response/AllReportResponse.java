package com.app.booking.springboot.response;

import java.util.List;
import java.util.stream.Collectors;

import com.app.booking.springboot.entity.model.storeProcedure.AllReport;

public class AllReportResponse {

	private String attribute;

	private float value;

	public AllReportResponse() {
	}

	public AllReportResponse(AllReport entity) {
		this.attribute = entity.getAttribute();
		this.value = entity.getValue();
	}

	public List<AllReportResponse> mapToList(List<AllReport> entiies) {
		return entiies.stream().map(x -> new AllReportResponse(x)).collect(Collectors.toList());
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}
