package com.coworking.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.coworking.domain.Centre_coworking;
import com.coworking.domain.Usuari_registrat;
import com.coworking.interfaces.ICentre_coworkingDAO;
import com.coworking.interfaces.IUsuari_registratDAO;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	//Testeando que se pueden hacer COMMITS
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private IUsuari_registratDAO Iusuari_registrat;
	@Autowired
	private ICentre_coworkingDAO Icentre_coworking;

	public Boolean loguejat = false;

	public String loginname;
	
	public Usuari_registrat userlogged;

	@RequestMapping("/home")
	public ModelAndView getLoginForm(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			ModelMap model,
			BindingResult result) {
			System.out.println("loguejat = "+loguejat);
			model.put("loguejat", loguejat);
			model.put("loginname", loginname);
			
			if (loguejat) {
				model.put("centresAdministrats", userlogged.getcentres_administrats());
			}
			
			return new ModelAndView("home", "model", model);
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			ModelMap model,
			BindingResult result) {
		
			String email = usuari_registrat.getemail();
			String contrasenya = usuari_registrat.getcontrasenya();
		
			System.out.println("LOGIN =" + email);
			System.out.println("CONTRASENYA =" + contrasenya);
			
			userlogged = Iusuari_registrat.getUsuari_registrat(email, contrasenya);
			
			if(userlogged == null){
				System.out.println("Usuario erroneo");
				loguejat = false;
				loginname = null;
			}else{
				System.out.println("Usuario correcto");
				loguejat = true;
				loginname = userlogged.getemail();
			}
		
			model.put("loguejat", loguejat);
			model.put("loginname", loginname);
			model.put("centresAdministrats", userlogged.getcentres_administrats());
			
			//return new ModelAndView("redirect:/home.html");
			return new ModelAndView("home", model);
	}
	
	/* ---------- Actualitza llista Els Meus Espais ------------- */
	@RequestMapping(value = "/espais", method = RequestMethod.GET)
	@ResponseBody
	public List<Centre_coworking> getCentresAdministrats() {
		System.out.println("Chivato: He clickat a a Els Meus Espais, generant una URL /home/espais que hem retorna a la funció AJAX una llista de Centres");
		return userlogged.getcentres_administrats();
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
		ambit.add("Matemàtic");
		ambit.add("Enginyer electronic");
		ArrayList<String> privacitat = new ArrayList<String>();
		privacitat.add("SI");
		privacitat.add("NO");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("ambit", ambit);
		model.put("privacitat", privacitat);
		
		System.out.println("Register Form");
		return new ModelAndView("Register", "model", model);
	}

	@RequestMapping("/saveUser")
	public ModelAndView saveUserData(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			BindingResult result) {
		usuari_registrat.setadmin_centre(false);
		usuari_registrat.setactiu(true);
		usuari_registrat.setdata_caducitat(null);
		/*Date data_naix = Date.
		usuari_registrat.setdata_naix(data_naix);*/
	
		try {
			Iusuari_registrat.saveUsuari_registrat(usuari_registrat);
			//Icentre_coworking.addCentre_coworking(c1);
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
		System.out.println("EMAIL = "+centre_coworking.getEmail());
		System.out.println("BANYS = "+centre_coworking.getBanys());
		System.out.println("CAFETERIA = "+centre_coworking.getCafeteria());
		userlogged.addcentre_administrat(centre_coworking);
		try {
			Icentre_coworking.saveCentre_coworking(centre_coworking);
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
		model.put("llistat_usuaris", Iusuari_registrat.getUsuaris());
		model.put("loguejat", loguejat);
		model.put("loginname", loginname);
		System.out.println("SIZE= "+Iusuari_registrat.getUsuaris().size());
		return new ModelAndView("UserDetails", "model", model );

	}
	
	@RequestMapping("/centresList")
	public ModelAndView getCentresDetais(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("centre_coworking", Icentre_coworking.getCentres());
		model.put("loguejat", loguejat);
		model.put("loginname", loginname);
		
		return new ModelAndView("CentresDetails", "model", model);

	}
	@RequestMapping("/mycentres")
	public ModelAndView getmycentres(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("centre_coworking", Icentre_coworking.getCentres());
		model.put("loguejat", loguejat);
		model.put("loginname", loginname);
		usuari_registrat = userlogged;
		if(!usuari_registrat.getcentres_administrats().isEmpty()){
			model.put("centres_admin", usuari_registrat.getcentres_administrats());	
		}else{
			System.out.println("este usuario no administra ningun centro");
		}
		return new ModelAndView("mycentres", "model", model);

	}
	@RequestMapping("/myprofile")
	public ModelAndView getmyprofile(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			BindingResult result) {
		usuari_registrat = userlogged;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("loguejat", loguejat);
		model.put("loginname", loginname);
		model.put("email", usuari_registrat.getemail());
		model.put("nom", usuari_registrat.getnom());
		model.put("cognom", usuari_registrat.getcognom());
		model.put("ambit", usuari_registrat.getamb_prof());
		model.put("dni", usuari_registrat.getdni());
		model.put("data_naix", usuari_registrat.getdata_naix()+"");
		model.put("telefon", usuari_registrat.gettelefon());
		model.put("privacitat", usuari_registrat.getprivacitat());
		model.put("sobre_mi", usuari_registrat.getsobre_mi());
		model.put("web", usuari_registrat.getweb());
		model.put("premium", usuari_registrat.getpremium());
	
						
		return new ModelAndView("myprofile", "model", model);

	}
	@RequestMapping("/editprofile")
	public ModelAndView editprofile(@ModelAttribute("usuari_registrat") Usuari_registrat usuari_registrat,
			BindingResult result) {
		usuari_registrat = userlogged;
		Map<String, Object> model = new HashMap<String, Object>();
		ArrayList<String> ambit = new ArrayList<String>();
		ambit.add("Arquitecte");
		ambit.add("Enginyer de software");
		ambit.add("Matematic");
		ambit.add("Enginyer electronic");
		//select boxes para privacitat y premium
		ArrayList<String> boxpriv = new ArrayList<String>();
		ArrayList<String> boxprem = new ArrayList<String>();
		model.put("loguejat", loguejat);
		model.put("loginname", loginname);
		model.put("email", usuari_registrat.getemail());
		model.put("nom", usuari_registrat.getnom());
		model.put("cognom", usuari_registrat.getcognom());
		model.put("ambit", ambit);
		model.put("dni", usuari_registrat.getdni());
		model.put("data_naix", usuari_registrat.getdata_naix()+"");
		model.put("telefon", usuari_registrat.gettelefon());
		model.put("contrasenya", usuari_registrat.getcontrasenya());
		model.put("adreca", usuari_registrat.getadreca());
		model.put("privacitat", usuari_registrat.getprivacitat());
		
		if(usuari_registrat.getprivacitat().matches("SI")){
			boxpriv.add("NO");
			model.put("boxpriv", boxpriv);
		}else{
			boxpriv.add("SI");
			model.put("boxpriv", boxpriv);
		}
		
		model.put("sobre_mi", usuari_registrat.getsobre_mi());
		model.put("web", usuari_registrat.getweb());
		model.put("premium", usuari_registrat.getpremium());
						
		if(usuari_registrat.getpremium().matches("SI")){
			boxprem.add("NO");
			model.put("boxprem", boxprem);
		}else{
			boxprem.add("SI");
			model.put("boxprem", boxprem);
		}
		return new ModelAndView("editprofile", "model", model);

	}
}
