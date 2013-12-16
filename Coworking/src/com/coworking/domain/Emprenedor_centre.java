package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprenedor_centre")
public class Emprenedor_centre {

	@Id
	@Column(name = "idemprenedor")
	private int idemprenedor;
	
	//RELATIONSHIPS
	//usuari_registrat - emprenedor_centre
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "usuari", referencedColumnName="email")})
	private Usuari_registrat usuari;
	
	//Centre_coworking - emprenedor_centre
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "idcentre", referencedColumnName="idcentre")})
	private Centre_coworking centre;

	public int getIdemprenedor() {
		return idemprenedor;
	}

	public void setIdemprenedor(int idemprenedor) {
		this.idemprenedor = idemprenedor;
	}

	public Usuari_registrat getUsuari() {
		return this.usuari;
	}

	public void setUsuari(Usuari_registrat usuari) {
		this.usuari = usuari;
	}

	public Centre_coworking getCentre() {
		return this.centre;
	}

	public void setCentre(Centre_coworking centre) {
		this.centre = centre;
	}
	
}
