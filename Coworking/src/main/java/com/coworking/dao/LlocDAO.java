package com.coworking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coworking.domain.Lloc;
import com.coworking.interfaces.ILlocDAO;



@Repository("llocDao")
public class LlocDAO implements ILlocDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveLloc(Lloc lloc) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(lloc);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Lloc> getLloc() {
		@SuppressWarnings("unchecked")
		List<Lloc> lloclist = sessionfactory.getCurrentSession()
				.createCriteria(Lloc.class).list();
		return lloclist;
	}

}
