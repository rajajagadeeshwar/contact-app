package com.contactapp.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.contactapp.model.Contact;

public class ContactRepository {
	
	static Long generatedId = 0L;
	static Map<Long,Contact> database = new HashMap<>();
	

	public Contact save(Contact contact) {
		
		contact.setId(generatedId++);
		
		database.put(contact.getId(), contact);
	
		return contact;
	}
	
	
	public List<Contact> findAll(){
		
		return new ArrayList<>(database.values());		
	}
	
	
	public Contact findById(Long id) {
		return database.get(id);		

	}
	
	public void removeContact(Long id) {
		database.remove(id);
	}
	
	
	
}
