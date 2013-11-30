package com.coworking.service;

import java.util.List;

import com.coworking.domain.Usuari_registrat;

public interface Usuari_registratService {
	public void addUsuari_registrat(Usuari_registrat Usuari_registrat);

	public List<Usuari_registrat> getUsuari_registrat();
}
