package com.coworking.service;

import com.coworking.domain.Centre_coworking;

public interface Centre_coworkingService {
	
	public void addCentre_coworking(Centre_coworking Centre_coworking);

	public Centre_coworking getCentre_coworking(int idCentre);
	
	public void setCentre_coworking(int idCentre, String Adresa, String Descripcio, String Email, String Nom, String Web, int tlf);
}
