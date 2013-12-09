package com.coworking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.coworking.domain.Solicitud_lloc;



@Repository("solicitud_llocDao")
public class Solicitud_llocDaoImpl implements Solicitud_llocDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveSolicitud_lloc(Solicitud_lloc solicitud_lloc) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(solicitud_lloc);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Solicitud_lloc> getSolicitud_lloc() {
		@SuppressWarnings("unchecked")
		List<Solicitud_lloc> solicitud_lloclist = sessionfactory.getCurrentSession()
				.createCriteria(Solicitud_lloc.class).list();
		return solicitud_lloclist;
	}

}
