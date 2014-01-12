package com.coworking.interfaces;

import java.util.List;

import com.coworking.domain.Centre_coworking;


public interface ICentre_coworkingDAO {
	public void saveCentre_coworking(Centre_coworking centre_coworking);
	

	public Centre_coworking getCentre_coworking(int idCentre);
	
	public void setCentre_coworking(int idCentre, String Adresa, String Descripcio, String Email, String Nom, String Web, int tlf);
	
	public List<Centre_coworking> getCentres();


	public void updateCentre(Centre_coworking centre_coworking);


	List<Centre_coworking> cercaAvancada(String nom, boolean banys,
			boolean cafe, boolean internet, boolean salaReunions, String poblacio);


	List<Centre_coworking> getCentresNom(String nom);


	public List<Centre_coworking> getcentre_coworking(String search);
	
	public List<Centre_coworking> gettop5centres();
	
}
