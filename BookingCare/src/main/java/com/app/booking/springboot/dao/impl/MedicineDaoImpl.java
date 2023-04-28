package com.app.booking.springboot.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.MedicineDao;
import com.app.booking.springboot.entity.Medicine;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineHistoryModel;
import com.app.booking.springboot.entity.model.storeProcedure.MedicineInventoryModel;
import com.app.bookingcare.enums.StoreProcedureStatusCodeEnum;
import com.app.bookingcare.exceptions.TechresHttpException;

@Repository("medicineDao")
@Transactional
@SuppressWarnings("unchecked")
public class MedicineDaoImpl extends AbstractDao<Integer, Medicine> implements MedicineDao {
	@Override
	public Medicine createMedicine(int categoryId, String name, String avatar, Date expiryDate,
			int outStockAlertQuantity, float retailPrice, float costPrice, int status, String note, String storageUnit,
			String useUnit, String methodOfUse, String originalName, int outExpiryDateAlert) throws Exception {

		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_medicine", Medicine.class)
				.registerStoredProcedureParameter("categoryId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("avatar", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("expiryDate", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("outStockAlertQuantity", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("retailPrice", Float.class, ParameterMode.IN)
				.registerStoredProcedureParameter("costPrice", Float.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("note", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("storageUnit", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("useUnit", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("methodOfUse", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("originalName", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("outExpiryDateAlert", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("categoryId", categoryId);
		query.setParameter("name", name);
		query.setParameter("avatar", avatar);
		query.setParameter("expiryDate", expiryDate);
		query.setParameter("outStockAlertQuantity", outStockAlertQuantity);
		query.setParameter("retailPrice", retailPrice);
		query.setParameter("costPrice", costPrice);
		query.setParameter("status", status);
		query.setParameter("note", note);
		query.setParameter("storageUnit", storageUnit);
		query.setParameter("useUnit", useUnit);
		query.setParameter("methodOfUse", methodOfUse);
		query.setParameter("originalName", originalName);
		query.setParameter("outExpiryDateAlert", outExpiryDateAlert);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Medicine) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public List<Medicine> getMedicines(int categoryId, int medicineId, String keySearch, int status) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_medicines", Medicine.class)
				.registerStoredProcedureParameter("categoryId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("medicineId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("keySearch", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("categoryId", categoryId);
		query.setParameter("medicineId", medicineId);
		query.setParameter("keySearch", keySearch);
		query.setParameter("status", status);

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
	public Medicine getMedicine(int medicineId) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_medicine", Medicine.class)
				.registerStoredProcedureParameter("medicineId", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("medicineId", medicineId);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Medicine) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public List<MedicineInventoryModel> getMedicineInvetory(int categoryId, int medicineId) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_inventory", MedicineInventoryModel.class)
				.registerStoredProcedureParameter("categoryId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("medicineId", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("categoryId", categoryId);
		query.setParameter("medicineId", medicineId);

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
	public void updateMedicine(int categoryId, int medicineId, String name, String avatar, Date expiryDate,
			int outStockAlertQuantity, float retailPrice, float costPrice, int status, String note, String storageUnit,
			String useUnit, String methodOfUse, String originalName, int outExpiryDateAlert) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_update_medicine", Medicine.class)
				.registerStoredProcedureParameter("categoryId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("medicineId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("avatar", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("expiryDate", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("outStockAlertQuantity", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("retailPrice", Float.class, ParameterMode.IN)
				.registerStoredProcedureParameter("costPrice", Float.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("note", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("storageUnit", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("useUnit", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("methodOfUse", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("originalName", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("outExpiryDateAlert", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("categoryId", categoryId);
		query.setParameter("medicineId", medicineId);
		query.setParameter("name", name);
		query.setParameter("avatar", avatar);
		query.setParameter("expiryDate", expiryDate);
		query.setParameter("outStockAlertQuantity", outStockAlertQuantity);
		query.setParameter("retailPrice", retailPrice);
		query.setParameter("costPrice", costPrice);
		query.setParameter("status", status);
		query.setParameter("note", note);
		query.setParameter("storageUnit", storageUnit);
		query.setParameter("useUnit", useUnit);
		query.setParameter("methodOfUse", methodOfUse);
		query.setParameter("originalName", originalName);
		query.setParameter("outExpiryDateAlert", outExpiryDateAlert);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return;
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public List<MedicineHistoryModel> getMedicineHistory(int medicineId, String fromDate, String toDate)
			throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_medicine_history", MedicineHistoryModel.class)
				.registerStoredProcedureParameter("medicineId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("fromDate", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("toDate", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("medicineId", medicineId);
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);

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
