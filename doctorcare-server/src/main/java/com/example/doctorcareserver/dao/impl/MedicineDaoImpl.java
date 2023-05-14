package com.example.doctorcareserver.dao.impl;


import java.util.ArrayList;

import javax.print.attribute.standard.Media;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.doctorcareserver.dao.AbstractDao;
import com.example.doctorcareserver.dao.MedicineDao;
import com.example.doctorcareserver.entity.Medicine;
import com.example.doctorcareserver.entity.User;


@Repository()
@SuppressWarnings("unchecked")
public class MedicineDaoImpl extends AbstractDao<Integer, Medicine> implements MedicineDao {

	@Override
	public ArrayList<Medicine> getMediasfrom(String name) {
		// TODO Auto-generated method stub
		ArrayList<Medicine> list = (ArrayList<Medicine>) this.getSession().createQuery("FROM Medicine M WHERE M.name like '"+name+"%' ").list();
		
		return list;
	}
	

}
