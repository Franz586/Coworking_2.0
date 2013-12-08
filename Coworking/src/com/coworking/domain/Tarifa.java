package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarifa")
public class Tarifa {

	@Id
	@Column(name = "idtarifa")
	private int idtarifa;
	
	@Column(name = "idcentre")
	private int idcentre;
	
	@Column(name = "descripcio")
	private String descripcio;
	
	@Column(name = "preu")
	private float preu;

	public int getIdtarifa() {
		return idtarifa;
	}

	public void setIdtarifa(int idtarifa) {
		this.idtarifa = idtarifa;
	}

	public int getIdcentre() {
		return idcentre;
	}

	public void setIdcentre(int idcentre) {
		this.idcentre = idcentre;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}
	
}
