package com.beingjavaguys.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Usuari_registrat")
public class Usuari_registrat {

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "contrasenya")
	private String contrasenya;

	@Column(name = "adreca")
	private String adreca;

	@Column(name = "amb_prof")
	private String amb_prof;

	@Column(name = "dni")
	private String dni;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "cognom")
	private String cognom;
	
	@Column(name = "privacitat")
	private Boolean privacitat;
	
	@Column(name = "web")
	private String web;
	
	@Column(name = "data_naix")
	private Date data_naix;
	
	@Column(name = "sobre_mi")
	private String sobre_mi;
	
	@Column(name = "telefon")
	private Integer telefon;
	
	@Column(name = "premium")
	private Boolean premium;
	
	@Column(name = "data_caducitat")
	private Date data_caducitat;
	
	@Column(name = "actiu")
	private Boolean actiu;
	
	@Column(name = "admin_centre")
	private Boolean admin_centre;
	

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String getcontrasenya() {
		return contrasenya;
	}

	public void setcontrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	public String getadreca() {
		return adreca;
	}

	public void setadreca(String adreca) {
		this.adreca = adreca;
	}
	
	public String getamb_prof() {
		return amb_prof;
	}

	public void setamb_prof(String amb_prof) {
		this.amb_prof = amb_prof;
	}
	
	public String getdni() {
		return dni;
	}
	
	public void setdni(String dni) {
		this.dni = dni;
	}
	
	public String getnom() {
		return nom;
	}
	
	public void setnom(String nom) {
		this.nom = nom;
	}
	
	public String getcognom() {
		return cognom;
	}
	
	public void setcognom(String cognom) {
		this.cognom = cognom;
	}
	
	public Boolean getprivacitat() {
		return privacitat;
	}
	
	public void setprivacitat(Boolean privacitat) {
		this.privacitat = privacitat;
	}
	
	public String getweb() {
		return web;
	}
	
	public void setweb(String web) {
		this.web = web;
	}
	
	public Date getdata_naix() {
		return data_naix;
	}
	
	public void setdata_naix(Date data_naix) {
		this.data_naix = data_naix;
	}
	
	public String getsobre_mi() {
		return sobre_mi;
	}
	
	public void setsobre_mi(String sobre_mi) {
		this.sobre_mi = sobre_mi;
	}
	
	public Integer gettelefon() {
		return telefon;
	}
	
	public void settelefon(Integer telefon) {
		this.telefon = telefon;
	}
	
	public Boolean getpremium() {
		return premium;
	}
	
	public void setpremium(Boolean premium) {
		this.premium = premium;
	}
	
	public Date getdata_caducitat() {
		return data_caducitat;
	}
	
	public void setdata_caducitat(Date data_caducitat) {
		this.data_caducitat = data_caducitat;
	}
	
	public Boolean getactiu() {
		return actiu;
	}
	
	public void setactiu(Boolean actiu) {
		this.actiu = actiu;
	}
	
	public Boolean getadmin_centre() {
		return admin_centre;
	}
	
	public void setadmin_centre(Boolean admin_centre) {
		this.admin_centre = admin_centre;
	}


}
