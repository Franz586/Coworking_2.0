package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lloc")
public class Lloc {
	
	@Id
	@Column(name = "idlloc")
	private int idlloc;
	
	@Column(name = "idcentre")
	private int idcentre;
	
	@Column(name = "ocupat")
	private boolean ocupat;
	
	@Column(name = "tipus")
	private String tipus;
	
	@Column(name = "idemprenedor")
	private int idemprenedor;

	public int getIdlloc() {
		return idlloc;
	}

	public void setIdlloc(int idlloc) {
		this.idlloc = idlloc;
	}

	public int getIdcentre() {
		return idcentre;
	}

	public void setIdcentre(int idcentre) {
		this.idcentre = idcentre;
	}

	public boolean isOcupat() {
		return ocupat;
	}

	public void setOcupat(boolean ocupat) {
		this.ocupat = ocupat;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public int getIdemprenedor() {
		return idemprenedor;
	}

	public void setIdemprenedor(int idemprenedor) {
		this.idemprenedor = idemprenedor;
	}
		
}
