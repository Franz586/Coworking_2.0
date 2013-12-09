package com.coworking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coworking.domain.Empresa;



@Repository("empresaDao")
public class EmpresaDaoImpl implements EmpresaDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveEmpresa(Empresa empresa) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(empresa);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Empresa> getEmpresa() {
		@SuppressWarnings("unchecked")
		List<Empresa> empresalist = sessionfactory.getCurrentSession()
				.createCriteria(Empresa.class).list();
		return empresalist;
	}

}
