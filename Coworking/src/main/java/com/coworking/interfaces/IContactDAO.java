package com.coworking.interfaces;

import java.io.Serializable;
import java.util.List;

import com.coworking.domain.Contact;

public interface IContactDAO< T extends Serializable> {
	
	void save(Contact contact);
	
	List<Contact> findAll();
	
	Contact findByName(String firstName, String lastName);
	
	List<Contact> findByFirstName(String firstName);

}
