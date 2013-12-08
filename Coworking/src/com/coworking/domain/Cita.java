package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;


@Entity
@Table(name = "Cita")
public class Cita {

	@Id
	@Column(name = "idcita")
	private int idcita;
	
	@Column(name = "usuari")
	private String usuari;
	
	@Column(name = "confirmada")
	private boolean confirmada;
	
	@Column(name = "idcentre")
	private int idcentre;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "idsolicitud")
	private int idsolicitud;

	public int getIdcita() {
		return idcita;
	}

	public void setIdcita(int idcita) {
		this.idcita = idcita;
	}

	public String getUsuari() {
		return usuari;
	}

	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}

	public boolean isConfirmada() {
		return confirmada;
	}

	public void setConfirmada(boolean confirmada) {
		this.confirmada = confirmada;
	}

	public int getIdcentre() {
		return idcentre;
	}

	public void setIdcentre(int idcentre) {
		this.idcentre = idcentre;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIdsolicitud() {
		return idsolicitud;
	}

	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	
}
