package com.coworking.dao;

import java.util.List;










import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coworking.domain.Centre_coworking;
import com.coworking.domain.Usuari_registrat;
import com.coworking.interfaces.IUsuari_registratDAO;





@Repository
public class Usuari_registratDAO implements IUsuari_registratDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveUsuari_registrat(Usuari_registrat usuari_registrat) {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(usuari_registrat);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Usuari_registrat> getUsuaris() {
		Session session = sessionfactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "From Usuari_registrat u";
		Query query = session.createQuery(hql);
		List<Usuari_registrat> userlist = query.list();
		tx.commit();
		return userlist;
	}
	
	@Override
	@Transactional
	public Usuari_registrat getUsuari_registrat(String email, String contrasenya) {
		@SuppressWarnings("unchecked")
		List<Usuari_registrat> res = sessionfactory.getCurrentSession()
				.createCriteria(Usuari_registrat.class).add(Restrictions.eq("email", email)).add(Restrictions.eq("contrasenya",contrasenya)).list();
		if(!res.isEmpty()){
			Usuari_registrat usuari = res.get(0);
			return usuari;
		}else{
			return null;
		}
	}
	public List<Centre_coworking> getAdmin_centres(Usuari_registrat usuari){
		
		return usuari.getcentres_administrats();
	}

	@Override
	@Transactional
	public void updateUsuari_registrat(Usuari_registrat usuari_registrat) {
	
			Session session = sessionfactory.getCurrentSession();
			session.update(usuari_registrat);	
			session.flush();
	}

	@Override
	@Transactional
	public Usuari_registrat getusuari_registrat(Integer userId) {
		Usuari_registrat usuari = (Usuari_registrat) sessionfactory.getCurrentSession().get(Usuari_registrat.class, userId);
		
		return usuari;
	}

	@Override
	public List<Usuari_registrat> getusuari_registrat(String nom) {
		List<Usuari_registrat> userlist = sessionfactory.getCurrentSession().createCriteria(Usuari_registrat.class)
				.add(Restrictions.eq("nom", nom).ignoreCase()).list();
		return userlist;
	}
	

}
