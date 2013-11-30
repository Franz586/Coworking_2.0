package com.beingjavaguys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.beingjavaguys.dao.Usuari_registratDao;
import com.beingjavaguys.domain.Usuari_registrat;


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
	public List<Usuari_registrat> getUsuari_registrat() {
		return usuari_registratDao.getUsuari_registrat();
	}

}
