package com.coworking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coworking.domain.Emprenedor_centre;



@Repository("emprenedor_centreDao")
public class Emprenedor_centreDaoImpl implements Emprenedor_centreDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveEmprenedor_centre(Emprenedor_centre emprenedor_centre) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(emprenedor_centre);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Emprenedor_centre> getEmprenedor_centre() {
		@SuppressWarnings("unchecked")
		List<Emprenedor_centre> emprenedorlist = sessionfactory.getCurrentSession()
				.createCriteria(Emprenedor_centre.class).list();
		return emprenedorlist;
	}

}
