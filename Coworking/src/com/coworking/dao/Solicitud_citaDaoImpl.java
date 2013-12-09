package com.coworking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.coworking.domain.Solicitud_cita;



@Repository("solicitud_citaDao")
public class Solicitud_citaDaoImpl implements Solicitud_citaDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveSolicitud_cita(Solicitud_cita solicitud_cita) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(solicitud_cita);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Solicitud_cita> getSolicitud_cita() {
		@SuppressWarnings("unchecked")
		List<Solicitud_cita> solicitud_citalist = sessionfactory.getCurrentSession()
				.createCriteria(Solicitud_cita.class).list();
		return solicitud_citalist;
	}

}
