package com.coworking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coworking.domain.Contact;
import com.coworking.interfaces.IContactDAO;

@Repository
@Transactional
public class ContactDAO implements IContactDAO<Contact> {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void save(Contact contact) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(contact);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return factory.getCurrentSession().createCriteria(Contact.class).list();
	}

	@Override
	public Contact findByName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

}
