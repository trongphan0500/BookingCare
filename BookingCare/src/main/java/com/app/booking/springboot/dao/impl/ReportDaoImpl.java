package com.app.booking.springboot.dao.impl;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.ReportDao;
import com.app.booking.springboot.entity.model.storeProcedure.AllReport;
import com.app.booking.springboot.entity.model.storeProcedure.BestSeller;
import com.app.booking.springboot.entity.model.storeProcedure.Inventory;
import com.app.booking.springboot.entity.model.storeProcedure.OutOfStock;
import com.app.booking.springboot.entity.model.storeProcedure.Report;
import com.app.bookingcare.enums.StoreProcedureStatusCodeEnum;
import com.app.bookingcare.exceptions.Pagination;
import com.app.bookingcare.exceptions.StoreProcedureListResult;
import com.app.bookingcare.exceptions.TechresHttpException;

@Repository("reportDao")
@Transactional
@SuppressWarnings("unchecked")
public class ReportDaoImpl extends AbstractDao<Integer, Report> implements ReportDao {

	@Override
	public List<Report> spCreateReport(int reportType, String fromDate, String toDate) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_report_profit", Report.class)
				.registerStoredProcedureParameter("reportType", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("fromDateString", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("toDateString", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("reportType", reportType);
		query.setParameter("fromDateString", fromDate);
		query.setParameter("toDateString", toDate);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return query.getResultList();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public StoreProcedureListResult<BestSeller> spGetBestSeller(String fromDate, String toDate, int limit)
			throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_best_sellers", BestSeller.class)
				.registerStoredProcedureParameter("fromDateString", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("toDateString", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("limit", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("fromDateString", fromDate);
		query.setParameter("toDateString", toDate);
		query.setParameter("limit", limit);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<>(statusCode, messageError, query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public List<Inventory> spGetInventory() throws Exception {
		return null;
	}

	@Override
	public StoreProcedureListResult<OutOfStock> spGetOutOfStock(Pagination pagination) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_out_of_stock", OutOfStock.class)
				.registerStoredProcedureParameter("limit", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("offset", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("total_record", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("limit", pagination.getLimit());
		query.setParameter("offset", pagination.getOffset());

		int totalRecord = (int) query.getOutputParameterValue("total_record");
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return new StoreProcedureListResult<>(statusCode, messageError, totalRecord, query.getResultList());
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public List<AllReport> getAllReportData(String keySearch) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_all_info_report", AllReport.class)
				.registerStoredProcedureParameter("keySearch", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("keySearch", keySearch);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return query.getResultList();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

}
