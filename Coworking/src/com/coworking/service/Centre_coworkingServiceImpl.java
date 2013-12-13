package com.coworking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.coworking.dao.Centre_coworkingDao;
import com.coworking.domain.Centre_coworking;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Centre_coworkingServiceImpl implements Centre_coworkingService{

	@Autowired
	Centre_coworkingDao centre_coworkingDao;
	
	@Override
	public void addCentre_coworking(Centre_coworking Centre_coworking) {
		centre_coworkingDao.saveCentre_coworking(Centre_coworking);		
	}

	@Override
	public Centre_coworking getCentre_coworking(int idCentre) {
		return centre_coworkingDao.getCentre_coworking(idCentre);
	}

	@Override
	public void setCentre_coworking(int idCentre, String Adresa,
			String Descripcio, String Email, String Nom, String Web, int tlf) {
		
		centre_coworkingDao.SetCentre_coworking(idCentre, Adresa, Descripcio, Email, Nom, Web, tlf);
	}

}
