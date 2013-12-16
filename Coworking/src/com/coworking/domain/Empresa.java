package com.coworking.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "NIF")
	private String NIF;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "contrasenya")
	private String contrasenya;
	
	//RELATIONSHIPS
	//empresa - projecte
	//cita - centre_coworking
	@OneToMany(targetEntity=Projecte.class, mappedBy="empresa")
	private List<Projecte> projectes;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public List<Projecte> getProjectes() {
		return this.projectes;
	}
	
	public void setProjectes(List<Projecte> projectes) {
		this.projectes = projectes;
	}
	public void addProjecte(Projecte projecte){
		this.projectes.add(projecte);
	}
	
}
