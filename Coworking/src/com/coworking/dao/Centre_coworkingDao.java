package com.coworking.dao;

import java.util.List;

import com.coworking.domain.Centre_coworking;




public interface Centre_coworkingDao {
	public void saveCentre_coworking ( Centre_coworking centre_coworking );
	public void deleteCentre_coworking (int idCentre);
	public List<Centre_coworking> getCentres();
	public Centre_coworking getCentre_coworking(int idCentre);
	public void SetCentre_coworking(int idCentre, String Adresa, String Descripcio, String Email, String Nom, String Web, int tlf);
}
