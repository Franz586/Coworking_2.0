package com.coworking.dao;

import java.util.List;

import com.coworking.domain.Tarifa;



public interface TarifaDao {
public void saveTarifa ( Tarifa tarifa );
public List<Tarifa> getTarifa();
}
