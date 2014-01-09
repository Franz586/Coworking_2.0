package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Valoracions")
public class Valoracions {
	
	@Id
	@Column(name = "idvaloracio")
	private int idvaloracio;
	
	@Column(name = "valoracio")
	private int valoracio;
	
	//RELATIONSHIPS
	//lloc - centre_coworking
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "idcentre", referencedColumnName="idcentre")})
	private Centre_coworking centre;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "usuari", referencedColumnName="idusuari")})
	private Usuari_registrat usuari;
	


	public int getIdvaloracio() {
		return idvaloracio;
	}

	public void setIdvaloraico(int idvaloracio) {
		this.idvaloracio = idvaloracio;
	}
	public int getvaloracio() {
		return valoracio;
	}

	public void setvaloracio(int valoracio) {
		this.valoracio = valoracio;
	}

	public Centre_coworking getcentre() {
		return this.centre;
	}

	public void setcentre(Centre_coworking centre) {
		this.centre = centre;
	}
	public Usuari_registrat getUsuari() {
		return this.usuari;
	}

	public void setUsuari(Usuari_registrat usuari) {
		this.usuari = usuari;
	}

}