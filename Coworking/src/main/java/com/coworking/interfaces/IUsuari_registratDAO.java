package com.coworking.interfaces;

import java.util.List;

import com.coworking.domain.Centre_coworking;
import com.coworking.domain.Usuari_registrat;



public interface IUsuari_registratDAO {
	public void saveUsuari_registrat(Usuari_registrat usuari_registrat);
	public void updateUsuari_registrat(Usuari_registrat usuari_registrat);
	public List<Usuari_registrat> getUsuaris();
	public Usuari_registrat getUsuari_registrat(String email, String contrasenya);
	public List<Centre_coworking> getAdmin_centres(Usuari_registrat usuari);
	public Usuari_registrat getusuari_registrat(Integer userId);
}
