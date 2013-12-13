package com.coworking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.coworking.dao.ProjecteDao;
import com.coworking.domain.Projecte;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProjecteServiceImpl implements ProjecteService {

	@Autowired
	ProjecteDao projecteDao;
	
	@Override
	public Projecte getProjecte(int idProj) {
		return projecteDao.getProjecte(idProj);
	}

}
