package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "solicitud_cita")
public class Solicitud_cita {

	@Id
	@Column(name = "idsolicitud")
	private int idsolicitud;
	
	@Column(name = "esacceptada")
	private boolean esacceptada;
	
	@Column(name = "usuari")
	private String usuari;

	public int getIdsolicitud() {
		return idsolicitud;
	}

	public void setIdsolicitud(int idsolicitud) {
		this.idsolicitud = idsolicitud;
	}

	public boolean isEsacceptada() {
		return esacceptada;
	}

	public void setEsacceptada(boolean esacceptada) {
		this.esacceptada = esacceptada;
	}

	public String getUsuari() {
		return usuari;
	}

	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}
}
