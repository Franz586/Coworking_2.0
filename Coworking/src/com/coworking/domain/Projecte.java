package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Projecte")
public class Projecte {
	
	@Id
	@Column(name = "idprojecte")
	private int idprojecte;
	
	@Column(name = "descripcio")
	private String descripcio;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "empresa")
	private String empresa;

	public int getIdprojecte() {
		return idprojecte;
	}

	public void setIdprojecte(int idprojecte) {
		this.idprojecte = idprojecte;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}
