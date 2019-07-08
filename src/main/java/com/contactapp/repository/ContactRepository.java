package com.contactapp.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import com.contactapp.model.Contact;

public class ContactRepository {
	
	static Long generatedId = 0L;
	static Map<Long,Contact> database = new HashMap<>();
	

	public Contact save(Contact contact) {
		
		contact.setId(generatedId++);
		
		database.put(contact.getId(), contact);
		
		
		database.forEach((key, value) -> {
			System.out.println("Key " + key );
			System.out.println("Value " + value);
		});
		
		return contact;
	}
	
	
}
