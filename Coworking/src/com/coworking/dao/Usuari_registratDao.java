package com.coworking.dao;

import java.util.List;

import com.coworking.domain.Usuari_registrat;


public interface Usuari_registratDao {
public void saveUsuari_registrat ( Usuari_registrat usuari_registrat );
public List<Usuari_registrat> getUsuari_registrat();
public Usuari_registrat getUsuari_registrat(String email, String contrasenya);
}