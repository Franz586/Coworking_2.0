package com.coworking.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "solicitud_lloc")
public class Solicitud_lloc {
	
	@Id
	@Column(name = "idsolicitud")
	private int idsolicitud;
	
	@Column(name = "idlloc")
	private int idlloc;
	
	@Column(name = "acceptada")
	private boolean acceptada;

	@Column(name = "admin")
	private String admin;
	
	@Column(name = "usuari")
	private String usuari;
	
	@Column(name = "data_lloc")
	private Date data_lloc;

	public int getIdsolicitud() {
		return idsolicitud;
	}

	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}

	public int getIdlloc() {
		return idlloc;
	}

	public void setIdlloc(int idlloc) {
		this.idlloc = idlloc;
	}

	public boolean isAcceptada() {
		return acceptada;
	}

	public void setAcceptada(boolean acceptada) {
		this.acceptada = acceptada;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getUsuari() {
		return usuari;
	}

	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}
	
	public Date getData_lloc() {
		return data_lloc;
	}


	public void setData_lloc(Date data_lloc) {
		this.data_lloc = data_lloc;
	}
}
