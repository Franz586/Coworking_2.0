package com.coworking.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coworking.domain.Centre_coworking;
import com.coworking.domain.Usuari_registrat;
import com.coworking.interfaces.ICentre_coworkingDAO;




@Repository
public class Centre_coworkingDAO implements ICentre_coworkingDAO {

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
	public List<Centre_coworking> getCentresNom(String nom) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "Select * From Centre_coworking c Where c.nom LIKE '%"+nom+"%';";
		Query query = session.createQuery(hql);
		List<Centre_coworking> centrelist = query.list();
		tx.commit();
		return centrelist;
	}
	
	
	@Override
	public List<Centre_coworking> cercaAvancada(String nom, boolean banys, boolean cafe, boolean internet, boolean salaReunions, String poblacio) {
		Session session = sessionfactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Centre_coworking.class);
		List<Centre_coworking> centrelist;
		if(nom!=null){
			if(!nom.isEmpty()){
				criteria = criteria.add(Restrictions.like("nom", nom+"%"));
			}
		}
		if(cafe)
			criteria = criteria.add(Restrictions.eq("cafeteria", cafe));
		if(internet)
			criteria = criteria.add(Restrictions.eq("internet", internet));
		if(salaReunions)
			criteria = criteria.add(Restrictions.eq("sala_reunions", salaReunions));
		if(banys)
			criteria = criteria.add(Restrictions.eq("banys", banys));
		
		criteria = criteria.add(Restrictions.eq("poblacio", poblacio));
		centrelist= criteria.list();
	
		return centrelist;
	}

	@Override
	public void setCentre_coworking(int idCentre, String Adresa,
			String Descripcio, String Email, String Nom, String Web, int tlf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void updateCentre(Centre_coworking centre_coworking) {
		Session session = sessionfactory.getCurrentSession();
		if(centre_coworking.getAdmin_centre()== null){
			System.out.println("NUUUUUUUUUUUUUULLLLLLLL");
		}
		session.update(centre_coworking);
		session.flush();
		
		
	}

	@Override
	public List<Centre_coworking> getcentre_coworking(String nom) {
		List<Centre_coworking> centrelist = sessionfactory.getCurrentSession().createCriteria(Centre_coworking.class)
				.add(Restrictions.eq("nom", nom)).list();
		return centrelist;
	}
	@Override
	public List<Centre_coworking> gettop5centres() {
		List<Centre_coworking> centrelist = sessionfactory.getCurrentSession().createCriteria(Centre_coworking.class)
				.addOrder(Order.desc("valoracio_mitja")).setMaxResults(5).list();
		return centrelist;
	}

}
