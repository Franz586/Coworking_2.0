package com.coworking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.coworking.domain.Contact;
import com.coworking.interfaces.IContactDAO;

@Controller
@RequestMapping("contact")
public class ContactController {

	@Autowired
	private IContactDAO dao;
	
	@RequestMapping("/home")
	public ModelAndView home(ModelMap model){
		model.put("contacts", dao.findAll());
		System.out.println("Chivato: Genero un modelo con la lista de BD del contacts");
		return new ModelAndView("contact", model);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Contact saveContact(Contact contact) {
		dao.save(contact);
		System.out.println("Chivato: Guardo un Contact especifico a la BD mediante lo que me pasa el maper de JSON");
		
		return contact;
	}
}
