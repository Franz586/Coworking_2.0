package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;









import java.util.Date;
import java.util.List;


@Entity
@Table(name = "centre_coworking")
public class Centre_coworking {

	@Id
	@Column(name = "idcentre")
	private int idcentre;
	
	@Column(name = "adreca")
	private String adreca;
	
	@Column(name = "descripcio")
	private String descripcio;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "web")
	private String web;
	
	@Column(name = "telefon")
	private int telefon;
	
	@Column(name = "premium")
	private boolean premium;
	@Column(name = "data_caducitat")
	private Date data_caducitat;

	//RELATIONSHIPS
	//usuari_registrat - centre_coworking
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "admin_centre", referencedColumnName="email")})
	private Usuari_registrat admin_centre;
	//cita - centre_coworking
	@OneToMany(targetEntity=Cita.class, mappedBy="centre")
	private List<Cita> cites;
	
	//emprenedor_centre - centre_coworking
	@OneToMany(targetEntity=Emprenedor_centre.class, mappedBy="centre")
	private List<Emprenedor_centre> emprenedors;
	
	//lloc - centre_coworking
	@OneToMany(targetEntity=Lloc.class, mappedBy="centre")
	private List<Lloc> llocs;
	
	public int getIdcentre() {
		return idcentre;
	}

	public void setIdcentre(int idcentre) {
		this.idcentre = idcentre;
	}

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public Date getData_caducitat() {
		return data_caducitat;
	}

	public void setData_caducitat(Date data_caducitat) {
		this.data_caducitat = data_caducitat;
	}
	public Usuari_registrat getAdmin_centre() {
		return this.admin_centre;
	}

	public void setAdmin_centre(Usuari_registrat admin_centre) {
		this.admin_centre = admin_centre;
	}
	
	public List<Cita> getcites() {
		return this.cites;
	}
	
	public void setcites(List<Cita> cites) {
		this.cites = cites;
	}
	public void addcita(Cita cita){
		this.cites.add(cita);
	}
	
	public List<Emprenedor_centre> getemprenedors() {
		return this.emprenedors;
	}
	
	public void setcentres(List<Emprenedor_centre> emprenedors) {
		this.emprenedors = emprenedors;
	}
	public void addcentre(Emprenedor_centre emprenedor){
		this.emprenedors.add(emprenedor);
		
	}
	
	public List<Lloc> getLlocs() {
		return this.llocs;
	}
		public void setLlocs(List<Lloc> llocs) {
		this.llocs = llocs;
	}
	public void addLloc(Lloc lloc){
		this.llocs.add(lloc);
	}

}
