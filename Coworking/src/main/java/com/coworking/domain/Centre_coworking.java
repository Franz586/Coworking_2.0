package com.coworking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;











import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "centre_coworking")
public class Centre_coworking {

	@Id
	@Column(name = "idcentre")
	private int idcentre;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "poblacio")
	private String poblacio;
	
	@Column(name = "carrer")
	private String carrer;
	
	@Column(name = "num_edifici")
	private String num_edifici;
	
	@Column(name = "descripcio")
	private String descripcio;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "link_foto")
	private String link_foto;
	
	@Column(name = "web")
	private String web;
	
	@Column(name = "telefon")
	private String telefon;
	
	@Column(name = "valoracio_mitja")
	private float valoracio_mitja;
	
	@Column(name = "premium")
	private String premium;
	
	@Column(name = "data_caducitat")
	private Date data_caducitat;
	
	//serveis
	@Column(name = "banys")
	private Boolean banys;
	@Column(name = "cafeteria")
	private Boolean cafeteria;
	@Column(name = "internet")
	private Boolean internet;
	@Column(name = "sala_reunions")
	private Boolean sala_reunions;
	
	
	@Column(name = "capacitat")
	private int capacitat;
	//RELATIONSHIPS
	//usuari_registrat - centre_coworking
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "admin_centre", referencedColumnName="idusuari")})
	private Usuari_registrat admin_centre;
	
	
	//lloc - centre_coworking
	@OneToMany(targetEntity=Lloc.class, mappedBy="centre")
	private List<Lloc> llocs;
	
	@OneToMany(targetEntity=Valoracions.class, mappedBy="centre")
	private List<Valoracions> valoracions = new ArrayList<Valoracions>();
	
	public int getIdcentre() {
		return idcentre;
	}

	public void setIdcentre(int idcentre) {
		this.idcentre = idcentre;
	}

	public String getCarrer() {
		return carrer;
	}

	public void setCarrer(String carrer) {
		this.carrer = carrer;
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

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getpoblacio() {
		return poblacio;
	}

	public void setpoblacio(String poblacio) {
		this.poblacio = poblacio;
	}
	
	public String getnum_edifici() {
		return num_edifici;
	}

	public void setnum_edifici(String num_edifici) {
		this.num_edifici = num_edifici;
	}
	
	public String getlink_foto() {
		return this.link_foto;
	}

	public void setlink_foto(String link_foto) {
		this.link_foto = link_foto;
	}
	
	public String isPremium() {
		return premium;
	}

	public void setPremium(String premium) {
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
	
	
	public List<Lloc> getLlocs() {
		return this.llocs;
	}
		public void setLlocs(List<Lloc> llocs) {
		this.llocs = llocs;
	}
	public void addLloc(Lloc lloc){
		this.llocs.add(lloc);
	}
	public Boolean getBanys(){
		
		return this.banys;
	}
	public void setBanys( Boolean banys){
		this.banys=banys;
	}
	public Boolean getCafeteria( ){
		
		return this.cafeteria;
	}
	public void setCafeteria( Boolean cafeteria){
		this.cafeteria=cafeteria;
	}
	public Boolean getInternet( ){
		
		return this.internet;
	}
	public void setInternet( Boolean internet){
		this.internet=internet;
	}
	public Boolean getSala_reunions( ){
		
		return this.sala_reunions;
	}
	public void setSala_reunions( Boolean sala_reunions){
		this.sala_reunions=sala_reunions;
	}

	public int getcapacitat() {
		return capacitat;
	}

	public void setcapacitat(int capacitat) {
		this.capacitat = capacitat;
	}
	public float getvaloracio() {
		return this.valoracio_mitja;
	}

	public void setvaloracio(float valoracio) {
		this.valoracio_mitja = valoracio;
	}
	@Override
	public boolean equals(Object object)
	{
	    boolean isEqual= false;

	    if (object != null && object instanceof Centre_coworking)
	    {
	        isEqual = (this.idcentre == ((Centre_coworking) object).getIdcentre());
	    }

	    return isEqual;
	}

	@Override
	public int hashCode() {
	    return this.idcentre;
	}
}
