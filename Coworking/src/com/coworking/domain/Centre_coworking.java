package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;


@Entity
@Table(name = "centre_coworking")
public class Centre_coworking {

	public int getIdcentre() {
		return idcentre;
	}

	public void setIdcentre(int idcentre) {
		this.idcentre = idcentre;
	}

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public Date getData_caducitat() {
		return data_caducitat;
	}

	public void setData_caducitat(Date data_caducitat) {
		this.data_caducitat = data_caducitat;
	}

	@Id
	@Column(name = "idcentre")
	private int idcentre;
	
	@Column(name = "adreca")
	private String adreca;
	
	@Column(name = "descripcio")
	private String descripcio;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "web")
	private String web;
	
	@Column(name = "telefon")
	private int telefon;
	
	@Column(name = "premium")
	private boolean premium;
	
	@Column(name = "data_caducitat")
	private Date data_caducitat;


}
