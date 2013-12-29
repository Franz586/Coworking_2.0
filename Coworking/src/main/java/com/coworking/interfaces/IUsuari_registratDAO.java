package com.coworking.interfaces;

import java.util.List;

import com.coworking.domain.Usuari_registrat;



public interface IUsuari_registratDAO {
	public void saveUsuari_registrat(Usuari_registrat usuari_registrat);
	public List<Usuari_registrat> getUsuaris();
	public Usuari_registrat getUsuari_registrat(String email, String contrasenya);
}
