package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emprenedor_centre")
public class Emprenedor_centre {

	@Id
	@Column(name = "idemprenedor")
	private int idemprenedor;
	
	@Column(name = "usuari")
	private String usuari;
	
	@Column(name = "idcentre")
	private int idcentre;

	public int getIdemprenedor() {
		return idemprenedor;
	}

	public void setIdemprenedor(int idemprenedor) {
		this.idemprenedor = idemprenedor;
	}

	public String getUsuari() {
		return usuari;
	}

	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}

	public int getIdcentre() {
		return idcentre;
	}

	public void setIdcentre(int idcentre) {
		this.idcentre = idcentre;
	}
	
}
