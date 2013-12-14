package com.coworking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coworking.domain.Admin_sistema;


@Repository("admin_sistema")
public class Admin_sistemaDaoImpl implements Admin_sistemaDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveAdmin_sistema(Admin_sistema admin_sistema) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(admin_sistema);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Admin_sistema> getAdmin_sistema() {
		@SuppressWarnings("unchecked")
		List<Admin_sistema> adminlist = sessionfactory.getCurrentSession()
				.createCriteria(Admin_sistema.class).list();
		return adminlist;
	}

}
