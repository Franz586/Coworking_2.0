package com.coworking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coworking.domain.Admin_sistema;
import com.coworking.interfaces.IAdmin_sistemaDAO;



@Repository
@Transactional
public class Admin_sistemaDAO implements IAdmin_sistemaDAO {

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

	@Override
	public void addAdmin_sistema(Admin_sistema Admin_sistema) {
		// TODO Auto-generated method stub
		
	}

}
