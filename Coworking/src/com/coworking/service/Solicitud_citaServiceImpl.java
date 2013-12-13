package com.coworking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.coworking.dao.Solicitud_citaDao;
import com.coworking.domain.Solicitud_cita;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Solicitud_citaServiceImpl implements Solicitud_citaService {

	@Autowired
	Solicitud_citaDao solicitud_citaDao;
	
	@Override
	public Solicitud_cita getSolicitud_cita(int idSolicitud) {
		Solicitud_cita sol = solicitud_citaDao.getSolicitud_cita(idSolicitud);
		
		return sol;
	}

}
