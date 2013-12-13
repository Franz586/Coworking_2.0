package com.coworking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.coworking.dao.Solicitud_llocDao;
import com.coworking.domain.Solicitud_lloc;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Solicitud_llocServiceImpl implements Solicitud_llocService{

	@Autowired
	Solicitud_llocDao solicitud_llocDao;
	
	@Override
	public Solicitud_lloc getSolicitud_lloc(int idSolicitud) {
		  
		Solicitud_lloc sol = solicitud_llocDao.getSolicitud_lloc(idSolicitud);
	      
		return sol;
	}

}
