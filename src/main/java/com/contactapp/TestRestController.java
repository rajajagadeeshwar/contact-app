package com.contactapp;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactapp.model.Contact;
import com.contactapp.service.ContactService;

@RestController
public class TestRestController {

	private final ContactService contactService;
	
	public TestRestController(ContactService contactService) {
		this.contactService = contactService;
	}
	
//	@RequestMapping("/testallo")
	public void anyMethod() {
		System.out.println("Hello world, testing spring");
	}
	
	@PostMapping(path="/contact", consumes = "application/json", produces = "application/json")
	public void createContact(Contact contact) {
		contactService.createContact(contact);
	}
	
	
}
