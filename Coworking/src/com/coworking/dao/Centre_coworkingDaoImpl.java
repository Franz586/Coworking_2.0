package com.coworking.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coworking.domain.Centre_coworking;
import com.coworking.domain.Usuari_registrat;



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
	public List<Centre_coworking> getCentres() {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "From Centre_coworking c";
		Query query = session.createQuery(hql);
		List<Centre_coworking> centrelist = query.list();
		tx.commit();
		return centrelist;
	}

	@Override
	public Centre_coworking getCentre_coworking(int idCentre) {
		Centre_coworking centre = (Centre_coworking) sessionfactory.getCurrentSession().get(Centre_coworking.class, idCentre);
		
		return centre;
	}

	@Override
	public void SetCentre_coworking(int idCentre, String Adresa,
			String Descripcio, String Email, String Nom, String Web, int tlf) {
		
		Centre_coworking centre = this.getCentre_coworking(idCentre);
		
		centre.setAdreca(Adresa);
		centre.setDescripcio(Descripcio);
		centre.setEmail(Email);
		centre.setNom(Nom);
		centre.setWeb(Web);
		centre.setTelefon(tlf);
		
		this.deleteCentre_coworking(idCentre);
		this.saveCentre_coworking(centre);
	}

	@Override
	public void deleteCentre_coworking(int idCentre) {
		Centre_coworking centre = this.getCentre_coworking(idCentre);
		sessionfactory.getCurrentSession().delete(centre);
	}

}
