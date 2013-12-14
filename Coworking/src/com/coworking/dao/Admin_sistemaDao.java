package com.coworking.dao;

import java.util.List;

import com.coworking.domain.Admin_sistema;


public interface Admin_sistemaDao {
public void saveAdmin_sistema ( Admin_sistema admin_sistema );
public List<Admin_sistema> getAdmin_sistema();
}