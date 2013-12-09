package com.coworking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coworking.domain.Tarifa;


@Repository("tarifaDao")
public class TarifaDaoImpl implements TarifaDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveTarifa(Tarifa tarifa) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(tarifa);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Tarifa> getTarifa() {
		@SuppressWarnings("unchecked")
		List<Tarifa> tarifalist = sessionfactory.getCurrentSession()
				.createCriteria(Tarifa.class).list();
		return tarifalist;
	}

}
