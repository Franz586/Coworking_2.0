package com.coworking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coworking.domain.Cita;


@Repository("citaDao")
public class CitaDaoImpl implements CitaDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveCita(Cita cita) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(cita);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Cita> getCita() {
		@SuppressWarnings("unchecked")
		List<Cita> citalist = sessionfactory.getCurrentSession()
				.createCriteria(Cita.class).list();
		return citalist;
	}

}
