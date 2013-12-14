package com.coworking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.coworking.dao.Admin_sistemaDao;
import com.coworking.domain.Admin_sistema;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class Admin_sistemaServiceImpl implements Admin_sistemaService {

	@Autowired
	Admin_sistemaDao admin_sistemaDao;

	@Override
	public void addAdmin_sistema(Admin_sistema admin_sistema) {
		admin_sistemaDao.saveAdmin_sistema(admin_sistema);
	}

	@Override
	public List<Admin_sistema> getAdmin_sistema() {
		return admin_sistemaDao.getAdmin_sistema();
	}

}
