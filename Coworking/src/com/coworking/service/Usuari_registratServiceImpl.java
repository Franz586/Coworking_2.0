package com.coworking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.coworking.dao.Usuari_registratDao;
import com.coworking.domain.Usuari_registrat;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Usuari_registratServiceImpl implements Usuari_registratService {

	@Autowired
	Usuari_registratDao usuari_registratDao;

	@Override
	public void addUsuari_registrat(Usuari_registrat usuari_registrat) {
		usuari_registratDao.saveUsuari_registrat(usuari_registrat);
	}

	@Override
	public List<Usuari_registrat> getUsuaris() {
		return usuari_registratDao.getUsuaris();
	}
	@Override
	public Usuari_registrat getUsuari_registrat(String email, String contrasenya) {
		return usuari_registratDao.getUsuari_registrat(email, contrasenya);
	}

}
