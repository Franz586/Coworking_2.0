package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Date;


@Entity
@Table(name = "Cita")
public class Cita {

	@Id
	@Column(name = "idcita")
	private int idcita;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "confirmada")
	private boolean confirmada;
	
	//FK Cita - Usuari_registrat
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "usuari", referencedColumnName="email")})
	private Usuari_registrat usuari;
	
	//FK Cita - Centre_coworking
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "idcentre", referencedColumnName="idcentre")})
	private Centre_coworking centre;
	
	//FK Cita - Solicitud_cita
	@OneToOne
	@JoinColumns({@JoinColumn(name = "idsolicitud", referencedColumnName="idsolicitud")})
	private Solicitud_cita solicitud;

	public int getIdcita() {
		return idcita;
	}

	public void setIdcita(int idcita) {
		this.idcita = idcita;
	}

	public Usuari_registrat getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari_registrat usuari) {
		this.usuari = usuari;
	}

	public boolean isConfirmada() {
		return confirmada;
	}

	public void setConfirmada(boolean confirmada) {
		this.confirmada = confirmada;
	}

	public Centre_coworking getCentre() {
		return this.centre;
	}

	public void setCentre(Centre_coworking centre) {
		this.centre = centre;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Solicitud_cita getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(Solicitud_cita solicitud) {
		this.solicitud = solicitud;
	}
	
}
