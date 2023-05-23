package com.app.booking.springboot.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.booking.springboot.dao.RegistrationDao;
import com.app.booking.springboot.entity.Patient;
import com.app.booking.springboot.entity.Registration;

@Repository("registrationDao")
@Transactional
@SuppressWarnings("unchecked")
public class RegistrationDaoImpl extends AbstractDao<Integer,Registration> implements RegistrationDao  {

	@Override
	public Registration saveRegistration(Registration registration) throws Exception {
		// TODO Auto-generated method stub
		return (Registration) this.getSession().merge(registration);
	}

	@Override
	public int getSTTDate() {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		String hql = "SELECT R FROM Registration R " +
				 "WHERE R.createdAt = '"+dt.format(date)+" 00:00:00.0'"+
	             "ORDER BY R.stt DESC";
		List<Registration> ds = this.getSession().createQuery(hql).list();
		if(ds.size()>0)
		{
			Registration registration = ds.get(0);
			return registration.getStt();
		}
		else
		{
			return 0;
		}
		
	}

	@Override
	public List<Registration> getRegistration() {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		String hql = "SELECT R FROM Registration R " +
				 "WHERE R.createdAt = '"+dt.format(date)+" 00:00:00.0'"+
	             "ORDER BY R.stt";
		List<Registration> ds = this.getSession().createQuery(hql).list();
		return ds;
	}

}
