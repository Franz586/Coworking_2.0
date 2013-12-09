package com.coworking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.coworking.domain.Projecte;



@Repository("projecteDao")
public class ProjecteDaoImpl implements ProjecteDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveProjecte(Projecte projecte) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(projecte);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Projecte> getProjecte() {
		@SuppressWarnings("unchecked")
		List<Projecte> projectelist = sessionfactory.getCurrentSession()
				.createCriteria(Projecte.class).list();
		return projectelist;
	}

}
