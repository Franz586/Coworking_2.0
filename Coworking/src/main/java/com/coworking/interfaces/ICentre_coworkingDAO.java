package com.coworking.interfaces;

import java.util.List;

import com.coworking.domain.Centre_coworking;


public interface ICentre_coworkingDAO {
	public void saveCentre_coworking(Centre_coworking centre_coworking);
	

	public Centre_coworking getCentre_coworking(int idCentre);
	
	public void setCentre_coworking(int idCentre, String Adresa, String Descripcio, String Email, String Nom, String Web, int tlf);
	
	public List<Centre_coworking> getCentres();
}
