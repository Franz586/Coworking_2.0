package com.coworking.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coworking.domain.Centre_coworking;
import com.coworking.domain.Usuari_registrat;
import com.coworking.service.Centre_coworkingService;
import com.coworking.service.Usuari_registratService;

@Controller
public class HomeController {

	@Autowired
	private Usuari_registratService usuari_registratService;
	@Autowired
	private Centre_coworkingService centre_coworkingService;

	public Boolean loguejat = false;

	public String loginname;
	
	public Usuari_registrat userlogged;

	@RequestMapping("/home")
	public ModelAndView getLoginForm(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			BindingResult result) {
			System.out.println("loguejat = "+loguejat);
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("loguejat", loguejat);
			model.put("loginname", loginname);
			return new ModelAndView("Home", "model", model);
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			BindingResult result) {
			System.out.println("LOGIN ="+usuari_registrat.getemail());
			String email = usuari_registrat.getemail();
			String contrasenya = usuari_registrat.getcontrasenya();
			System.out.println("CONTRASENYA ="+usuari_registrat.getcontrasenya());
			userlogged = usuari_registratService.getUsuari_registrat(email, contrasenya);
			if(userlogged == null){
				System.out.println("Usuario erroneo");
				loguejat = false;
				loginname = null;
			}else{
				System.out.println("Usuario correcto");
				loguejat = true;
				loginname = userlogged.getemail();
			}
			return new ModelAndView("redirect:/home.html");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
			userlogged = null;
			loguejat = false;
			loginname = null;
			return new ModelAndView("redirect:/home.html");
	}
	
	@RequestMapping("/register")
	public ModelAndView getRegisterForm(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			BindingResult result) {
		usuari_registrat = new Usuari_registrat();
		ArrayList<String> ambit = new ArrayList<String>();
		ambit.add("Arquitecte");
		ambit.add("Enginyer de software");
		ambit.add("Matematic");
		ambit.add("Enginyer electronic");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ambit", ambit);
		System.out.println("Register Form");
		return new ModelAndView("Register", "model", model);
	}

	@RequestMapping("/saveUser")
	public ModelAndView saveUserData(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			BindingResult result) {
		usuari_registrat.setadmin_centre(true);
		usuari_registrat.setpremium(false);
		usuari_registrat.setactiu(true);
		usuari_registrat.setprivacitat(false);
		usuari_registrat.setweb(null);
		usuari_registrat.setdata_naix(null);
		usuari_registrat.setsobre_mi(null);
		usuari_registrat.settelefon(null);
		usuari_registrat.setdata_caducitat(null);
	
		try {
			usuari_registratService.addUsuari_registrat(usuari_registrat);
			//centre_coworkingService.addCentre_coworking(c1);
			System.out.println("Save usuari_registrat");
			return new ModelAndView("redirect:/userList.html");
		}catch(Exception e){
			System.out.println(e.getMessage());
			return this.getRegisterForm(usuari_registrat, result);
		}
		
		
	}

	@RequestMapping("/registerCentre")
	public ModelAndView getRegisterCentre(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			@ModelAttribute("centre_coworking") Centre_coworking centre_coworking,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("loguejat", loguejat);
		model.put("loginname", loginname);
		return new ModelAndView("RegisterCentre", "model", model);
	}

	@RequestMapping("/saveCentre")
	public ModelAndView saveCentreData(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			@ModelAttribute("centre_coworking") Centre_coworking centre_coworking, 
			BindingResult result) {
		centre_coworking.setAdmin_centre(userlogged);
		centre_coworking.setAdreca("lala");
		centre_coworking.setPremium(false);
		centre_coworking.setTelefon(0);
		userlogged.addcentre_administrat(centre_coworking);
		try {
			centre_coworkingService.addCentre_coworking(centre_coworking);
			System.out.println("Save centre_coworking");
			return new ModelAndView("redirect:/centresList.html");
		}catch(Exception e){
			System.out.println(e.getMessage());
			return this.getRegisterCentre(usuari_registrat, centre_coworking, result);
		}
		
		
	}
	
	@RequestMapping("/userList")
	public ModelAndView getUserList() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("llistat_usuaris", usuari_registratService.getUsuaris());
		model.put("loguejat", loguejat);
		model.put("loginname", loginname);
		System.out.println("SIZE= "+usuari_registratService.getUsuaris().size());
		return new ModelAndView("UserDetails", "model", model );

	}
	
	@RequestMapping("/centresList")
	public ModelAndView getCentresDetais(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("centre_coworking", centre_coworkingService.getCentres());
		model.put("loguejat", loguejat);
		model.put("loginname", loginname);
		System.out.println("TEEEEEEEEST2");
		return new ModelAndView("CentresDetails", "model", model);

	}
}
