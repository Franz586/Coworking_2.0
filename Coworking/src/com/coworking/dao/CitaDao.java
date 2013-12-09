package com.coworking.dao;

import java.util.List;

import com.coworking.domain.Cita;




public interface CitaDao {
public void saveCita ( Cita cita );
public List<Cita> getCita();
}
