package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "Admin_sistema")
public class Admin_sistema {

	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "contrasenya")
	private String contrasenya;
	
	@Column(name = "actiu")
	private boolean actiu;
	
	public String getemail() {
		return this.email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getcontrasenya() {
		return this.contrasenya;
	}

	public void setcontrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public Boolean getactiu() {
		return this.actiu;
	}

	public void setactiu(Boolean actiu) {
		this.actiu = actiu;
	}


}
