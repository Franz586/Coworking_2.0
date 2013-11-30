package com.beingjavaguys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.beingjavaguys.domain.Usuari_registrat;
import com.beingjavaguys.service.Usuari_registratService;

@Controller
public class HomeController {

	@Autowired
	private Usuari_registratService usuari_registratService;

	@RequestMapping("/register")
	public ModelAndView getRegisterForm(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			BindingResult result) {
		
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
		usuari_registrat.setadmin_centre(false);
		usuari_registrat.setpremium(false);
		usuari_registrat.setactiu(true);
		usuari_registrat.setprivacitat(false);
		usuari_registrat.setweb(null);
		usuari_registrat.setdata_naix(null);
		usuari_registrat.setsobre_mi(null);
		usuari_registrat.settelefon(null);
		usuari_registrat.setdata_caducitat(null);
		usuari_registratService.addUsuari_registrat(usuari_registrat);
		System.out.println("Save usuari_registrat");
		return new ModelAndView("redirect:/userList.html");
	}

	@RequestMapping("/userList")
	public ModelAndView getUserList() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("usuari_registrat", usuari_registratService.getUsuari_registrat());
		return new ModelAndView("UserDetails", model);

	}
}
