package com.coworking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coworking.domain.Centre_coworking;



@Repository("centre_coworkingDao")
public class Centre_coworkingDaoImpl implements Centre_coworkingDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveCentre_coworking(Centre_coworking centre_coworking) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(centre_coworking);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Centre_coworking> getCentre_coworking() {
		@SuppressWarnings("unchecked")
		List<Centre_coworking> centrelist = sessionfactory.getCurrentSession()
				.createCriteria(Centre_coworking.class).list();
		return centrelist;
	}

}
