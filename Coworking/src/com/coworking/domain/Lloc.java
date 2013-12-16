package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Lloc")
public class Lloc {
	
	@Id
	@Column(name = "idlloc")
	private int idlloc;
	
	@Column(name = "seient")
	private int seient;
	
	@Column(name = "ocupat")
	private boolean ocupat;
	
	@Column(name = "tipus")
	private String tipus;
	//RELATIONSHIPS
	//lloc - centre_coworking
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "idcentre", referencedColumnName="idcentre")})
	private Centre_coworking centre;
	
	//lloc - emprenedor_centre
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "idemprenedor", referencedColumnName="idemprenedor")})
	private Emprenedor_centre emprenedor;

	public int getIdlloc() {
		return idlloc;
	}

	public void setIdlloc(int idlloc) {
		this.idlloc = idlloc;
	}
	public int getseient() {
		return seient;
	}

	public void setseient(int seient) {
		this.seient = seient;
	}

	public Centre_coworking getcentre() {
		return this.centre;
	}

	public void setcentre(Centre_coworking centre) {
		this.centre = centre;
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

	public Emprenedor_centre getemprenedor() {
		return this.emprenedor;
	}

	public void setemprenedor(Emprenedor_centre emprenedor) {
		this.emprenedor = emprenedor;
	}
		
}
